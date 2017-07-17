/**
 *
 */
package com.flintgroup.core.order;

import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.impl.DefaultCalculationService;
import de.hybris.platform.order.strategies.calculation.FindPriceStrategy;
import de.hybris.platform.util.PriceValue;


/**
 * @author 629167
 *
 */
public class FlintDefaultCalculationService extends DefaultCalculationService
{
	private FindPriceStrategy findPriceStrategy;

	/**
	 * @return the findPriceStrategy
	 */
	public FindPriceStrategy getFindPriceStrategy()
	{
		return findPriceStrategy;
	}

	/**
	 * @param findPriceStrategy
	 *           the findPriceStrategy to set
	 */
	@Override
	public void setFindPriceStrategy(final FindPriceStrategy findPriceStrategy)
	{
		this.findPriceStrategy = findPriceStrategy;
	}



	@Override
	protected PriceValue findBasePrice(final AbstractOrderEntryModel entry) throws CalculationException
	{
		final Object price = (double) getFindPriceStrategy().findBasePrice(entry).getValue();
		return price.equals(new Double(0.0)) ? new PriceValue("CNY", 0.0, true) : getFindPriceStrategy().findBasePrice(entry);
	}
}
