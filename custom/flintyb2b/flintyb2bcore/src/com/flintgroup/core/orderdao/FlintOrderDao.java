/**
 *
 */
package com.flintgroup.core.orderdao;

import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.user.CustomerModel;

import java.util.List;


/**
 * @author 629167
 *
 */
public interface FlintOrderDao
{
	List<OrderModel> findRecentOrderByCustomer(CustomerModel customerModel);
}
