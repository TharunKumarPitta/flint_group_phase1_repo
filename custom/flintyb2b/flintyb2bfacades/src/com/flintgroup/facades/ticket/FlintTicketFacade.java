/**
 *
 */
package com.flintgroup.facades.ticket;

import de.hybris.platform.customerticketingfacades.data.TicketData;

import java.util.List;


/**
 * @author 629167
 *
 */
public interface FlintTicketFacade
{
	List<TicketData> getRecentTicketOfCustomer();
}
