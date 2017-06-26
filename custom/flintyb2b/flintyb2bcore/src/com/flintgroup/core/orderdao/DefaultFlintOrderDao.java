/**
 *
 */
package com.flintgroup.core.orderdao;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNull;

import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.internal.dao.AbstractItemDao;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author 629167
 *
 */
public class DefaultFlintOrderDao extends AbstractItemDao implements FlintOrderDao
{

	private static final String FIND_ORDERS_BY_CUSTOMER_CODE_STORE_QUERY = "SELECT {" + OrderModel.PK + "} FROM {"
			+ OrderModel._TYPECODE + "} WHERE {" + OrderModel.USER + "} = ?customer ORDER BY {" + OrderModel.PK + "} DESC";


	@Override
	public List<OrderModel> findRecentOrderByCustomer(final CustomerModel customerModel)
	{
		validateParameterNotNull(customerModel, "Customer must not be null");
		final Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("customer", customerModel);
		final SearchResult<OrderModel> result = getFlexibleSearchService().search(FIND_ORDERS_BY_CUSTOMER_CODE_STORE_QUERY,
				queryParams);
		return result.getResult();
	}

}
