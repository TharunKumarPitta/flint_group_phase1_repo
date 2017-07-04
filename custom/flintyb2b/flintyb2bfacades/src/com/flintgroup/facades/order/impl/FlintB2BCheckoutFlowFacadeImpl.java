package com.flintgroup.facades.order.impl;

import de.hybris.platform.b2b.model.B2BCommentModel;
import de.hybris.platform.b2bacceleratorfacades.order.impl.DefaultB2BCheckoutFacade;
import de.hybris.platform.b2bacceleratorservices.enums.CheckoutPaymentType;
import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.core.enums.ExportStatus;


public class FlintB2BCheckoutFlowFacadeImpl extends DefaultB2BCheckoutFacade
{

	@Override
	public CartData updateCheckoutCart(final CartData cartData)
	{
		final CartModel cartModel = getCart();
		
		cartModel.setExportStatus(ExportStatus.NOTEXPORTED);
		getModelService().save(cartModel);
		return getCheckoutCart();

	}

}
