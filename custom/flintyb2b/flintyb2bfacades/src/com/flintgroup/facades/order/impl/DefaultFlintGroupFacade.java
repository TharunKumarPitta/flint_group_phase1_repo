/**
 *
 */
package com.flintgroup.facades.order.impl;

import de.hybris.platform.commercefacades.order.impl.DefaultOrderFacade;
import de.hybris.platform.converters.Converters;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.commercefacades.order.data.OrderHistoryData;
import java.util.List;

import com.flintgroup.core.orderservice.FlintRecentOrderService;
import com.flintgroup.facades.order.FlintOrderFacade;


/**
 * @author 629167
 *
 */
public class DefaultFlintGroupFacade extends DefaultOrderFacade implements FlintOrderFacade
{

	private FlintRecentOrderService flintRecentOrderService;

	/**
	 * @return the flintRecentOrderService
	 */
	public FlintRecentOrderService getFlintRecentOrderService()
	{
		return flintRecentOrderService;
	}

	/**
	 * @param flintRecentOrderService
	 *           the flintRecentOrderService to set
	 */
	public void setFlintRecentOrderService(final FlintRecentOrderService flintRecentOrderService)
	{
		this.flintRecentOrderService = flintRecentOrderService;
	}

	@Override
	public List<OrderHistoryData> getRecetOrderOfCustomer()
	{
		final CustomerModel currentCustomer = (CustomerModel) getUserService().getCurrentUser();
		final List<OrderModel> orderList = getFlintRecentOrderService().getRecentOrder(currentCustomer);
		return Converters.convertAll(orderList, getOrderHistoryConverter());
		//return orderList;
	}

	/*
	 * public List<FlintOrderData> getRecentOrderData(final List<OrderModel> orderList) { final List<FlintOrderData>
	 * orderDataList = new ArrayList<FlintOrderData>(); for (int i = 0; i < orderList.size() || i <= 5; i++) { final
	 * FlintOrderData orderData = new FlintOrderData(); System.out.println("=====================" +
	 * orderList.get(i).getStatusDisplay()); System.out.println("=====================" +
	 * orderList.get(i).getCreationtime()); orderData.created = orderList.get(i).getCreationtime();
	 * orderData.statusDisplay = orderList.get(i).getStatusDisplay(); orderDataList.add(orderData); } return
	 * orderDataList; }
	 */


}