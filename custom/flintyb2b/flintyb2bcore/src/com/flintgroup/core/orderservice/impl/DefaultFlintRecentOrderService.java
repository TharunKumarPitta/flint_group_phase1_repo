/**
 *
 */
package com.flintgroup.core.orderservice.impl;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNull;

import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.user.CustomerModel;

import java.util.List;

import javax.annotation.Resource;

import com.flintgroup.core.orderdao.FlintOrderDao;
import com.flintgroup.core.orderservice.FlintRecentOrderService;


/**
 * @author 629167
 *
 */
@Resource
public class DefaultFlintRecentOrderService implements FlintRecentOrderService
{

	private FlintOrderDao flintOrderDao;

	public FlintOrderDao getFlintOrderDao()
	{
		return flintOrderDao;
	}

	public void setFlintOrderDao(final FlintOrderDao flintOrderDao)
	{
		this.flintOrderDao = flintOrderDao;
	}

	@Override
	public List<OrderModel> getRecentOrder(final CustomerModel customerModel)
	{
		validateParameterNotNull(customerModel, "Customer model cannot be null");
		return getFlintOrderDao().findRecentOrderByCustomer(customerModel);
	}

}
