/**
 *
 */
package com.flintgroup.facades.order;
import de.hybris.platform.commercefacades.order.data.OrderHistoryData;
import java.util.List;


/**
 * @author 629167
 *
 */
public interface FlintOrderFacade
{
	List<OrderHistoryData> getRecetOrderOfCustomer();

}
