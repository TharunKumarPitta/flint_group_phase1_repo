/**
 *
 */
package com.flintgroup.facades.ticket.impl;

import com.flintgroup.facades.ticket.FlintTicketFacade;
import de.hybris.platform.converters.Converters;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.customerticketingfacades.customerticket.DefaultCustomerTicketingFacade;
import de.hybris.platform.customerticketingfacades.data.TicketData;
import de.hybris.platform.ticket.model.CsTicketModel;
import de.hybris.platform.ticket.service.TicketService;

import java.util.List;

import com.flintgroup.facades.ticket.FlintTicketFacade;



/**
 * @author 629167
 *
 */
public class DefaultFlintTicketFacade extends DefaultCustomerTicketingFacade implements FlintTicketFacade
{

	private TicketService ticketService;

	@Override
	public TicketService getTicketService()
	{
		return ticketService;
	}

	@Override
	public void setTicketService(final TicketService ticketService)
	{
		this.ticketService = ticketService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.flintgroup.facade.ticket.FlintTicketFacade#getRecentTicketOfCustomer()
	 */
	@Override
	public List<TicketData> getRecentTicketOfCustomer()
	{
		final CustomerModel currentCustomer = (CustomerModel) getUserService().getCurrentUser();
		final List<CsTicketModel> tickeList = getTicketService().getTicketsByCustomer(currentCustomer);
		return Converters.convertAll(tickeList, getTicketListConverter());
	}

}
