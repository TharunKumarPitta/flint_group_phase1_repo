/**
 *
 */
package com.flintgroup.core.orderservice;

import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.user.CustomerModel;

import java.util.List;


/**
 * @author 629167
 *
 */
public interface FlintRecentOrderService
{
	List<OrderModel> getRecentOrder(CustomerModel customerModel);
}
