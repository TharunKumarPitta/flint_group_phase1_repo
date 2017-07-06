/**
 *
 */
package com.flintgroup.storefront.security;

import de.hybris.platform.acceleratorstorefrontcommons.constants.WebConstants;
import de.hybris.platform.acceleratorstorefrontcommons.security.StorefrontAuthenticationSuccessHandler;
import de.hybris.platform.core.Constants;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;


/**
 * @author 629167
 *
 */
public class FlintStorefrontAuthenticationSuccessHandler extends StorefrontAuthenticationSuccessHandler
{

	private static final Logger LOG = Logger.getLogger(FlintStorefrontAuthenticationSuccessHandler.class);

	@Override
	public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response,
			final Authentication authentication) throws IOException, ServletException
	{
		//if redirected from some specific url, need to remove the cachedRequest to force use defaultTargetUrl
		final RequestCache requestCache = new HttpSessionRequestCache();
		final SavedRequest savedRequest = requestCache.getRequest(request, response);

		if (savedRequest != null)
		{
			for (final String redirectUrlForceDefaultTarget : getListRedirectUrlsForceDefaultTarget())
			{
				if (savedRequest.getRedirectUrl().contains(redirectUrlForceDefaultTarget))
				{
					requestCache.removeRequest(request, response);
					break;
				}
			}
		}
		getCustomerFacade().loginSuccess();
		request.setAttribute(WebConstants.CART_MERGED, Boolean.FALSE);

		// Check if the user is in role admingroup
		if (!isAdminAuthority(authentication))
		{
			getCartRestorationStrategy().restoreCart(request);
			getBruteForceAttackCounter().resetUserCounter(getCustomerFacade().getCurrentCustomerUid());
			// When Authenticated the following URL's are not valid hence redirect to homepage
			if (savedRequest != null &&
					(savedRequest.getRedirectUrl().contains("/login?error=true")) || (savedRequest.getRedirectUrl().contains("login?site=flint-zh")))
			{
				this.getRedirectStrategy().sendRedirect(request, response, "/");
			}
			else
			{
				super.onAuthenticationSuccess(request, response, authentication);
			}

		}
		else
		{
			LOG.warn("Invalidating session for user in the " + Constants.USER.ADMIN_USERGROUP + " group");
			invalidateSession(request, response);
		}
	}
}
