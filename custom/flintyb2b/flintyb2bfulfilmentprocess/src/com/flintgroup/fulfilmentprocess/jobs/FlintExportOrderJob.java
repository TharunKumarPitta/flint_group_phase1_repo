package com.flintgroup.fulfilmentprocess.jobs;


import de.hybris.platform.core.enums.ExportStatus;
import de.hybris.platform.core.enums.OrderStatus;
import de.hybris.platform.core.enums.PaymentStatus;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.payment.model.PaymentTransactionEntryModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.exceptions.BusinessException;
import de.hybris.platform.util.Config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import de.hybris.platform.util.CSVWriter;
import javax.annotation.Resource;

import org.apache.log4j.Logger;




/**
 *
 */
public class FlintExportOrderJob extends AbstractJobPerformable<CronJobModel>
{

	private static final Logger LOG = Logger.getLogger(FlintExportOrderJob.class);
	/**
	 *
	 */
	private static final String ACCEPTED = "ACCEPTED";
	private static final String ENCODING = "UTF-8";
	private static final String TEMPEXT = ".txt";
	private static final String FILENAME = "Order";
	private static final String FILENAMEDATEFORMAT = "yyyyMMddHHmmss";
	private static final String CSVDATEFORMAT = "yyyyMMdd";

	

	@Override
	public PerformResult perform(final CronJobModel cronJob)
	{
		try
		{
			//select all non exported orders
			final OrderModel orderModel = new OrderModel();
			LOG.info("Invoking ExportOrder");
			orderModel.setExportStatus(ExportStatus.NOTEXPORTED);
			orderModel.setPaymentStatus(PaymentStatus.PAID);
			final List<OrderModel> orderList = flexibleSearchService.getModelsByExample(orderModel);

			if (orderList != null && orderList.size() > 0)
			{
				final String basePath = Config.getParameter("acceleratorservices.export.basefolder");
				File csvFile = null;
				CSVWriter writer = null;

				try
				{
					//export
					for (final OrderModel order : orderList)
					{
						final Date orderCreationDate = order.getModifiedtime();
						final String stamp = new SimpleDateFormat(FILENAMEDATEFORMAT).format(orderCreationDate);
						final String filename = basePath + File.separator + FILENAME + "-" + order.getCode() + "-" + stamp;
						csvFile = new File(filename + TEMPEXT);

						if (order.getVersionID() == null)
						{

							writer = new CSVWriter(csvFile, ENCODING);
							exportOrder(order, writer);
							writer.close();
							csvFile.renameTo(new File(filename + ".csv"));

							//mark as exported
							order.setExportStatus(ExportStatus.EXPORTED);
							modelService.save(order);
							LOG.info("Export Order: CSV file genrated successfully" + csvFile.getName());
						}
					}
				}
				catch (final Exception e)
				{
					writer.close();
					LOG.info("Exception in Export Order" + e);
					csvFile.delete();
					throw e;
				}

			}
		}
		catch (final FileNotFoundException fnfe)
		{
			LOG.error("Could not write file for CSV export ", fnfe);
			return new PerformResult(CronJobResult.FAILURE, CronJobStatus.FINISHED);
		}
		catch (final UnsupportedEncodingException e)
		{
			LOG.error(e.getMessage(), e);
			return new PerformResult(CronJobResult.FAILURE, CronJobStatus.FINISHED);
		}
		catch (final IOException e)
		{
			LOG.error(e.getMessage(), e);
			return new PerformResult(CronJobResult.FAILURE, CronJobStatus.FINISHED);
		}
		catch (final Exception e)
		{
			LOG.error(e.getMessage(), e);
			return new PerformResult(CronJobResult.FAILURE, CronJobStatus.FINISHED);
		}


		return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
	}


	/**
	 * Exports the order to CSV
	 * 
	 * @param writer
	 * @throws IOException
	 */
	private void exportOrder(final OrderModel order, final CSVWriter writer) throws IOException
	{
		LOG.info("Exporting order " + order.getCode());

		final Map<Integer, String> values = new HashMap();

		//prepare order info
		values.put(Integer.valueOf(0), order.getCode());
		values.put(Integer.valueOf(1), (order.getUnit() != null && order.getUnit().getSalesArea() != null) ? order.getUnit()
				.getSalesArea().getCode() : "");
		values.put(Integer.valueOf(2), order.getPurchaseOrderNumber());
		values.put(Integer.valueOf(3), new SimpleDateFormat(CSVDATEFORMAT).format(order.getDate()));
		values.put(Integer.valueOf(4), (order.getUser() != null) ? order.getUser().getUid() : "");

		//export each entry
		for (final AbstractOrderEntryModel entry : order.getEntries())
		{
			values.put(Integer.valueOf(5), entry.getEntryNumber().toString());
			values.put(Integer.valueOf(6), entry.getProduct().getCode());
			values.put(Integer.valueOf(7), entry.getQuantity().toString());
			writer.write(values);
		}
	}

}
