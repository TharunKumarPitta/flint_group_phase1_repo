package com.flintgroup.core.util;

import de.hybris.platform.b2b.model.B2BCustomerModel;
import de.hybris.platform.b2b.model.B2BUnitModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.solrfacetsearch.search.Document;
import de.hybris.platform.solrfacetsearch.search.FacetSearchException;
import de.hybris.platform.solrfacetsearch.search.QueryField;
import de.hybris.platform.solrfacetsearch.search.RawQuery;
import de.hybris.platform.solrfacetsearch.search.SearchQuery;
import de.hybris.platform.solrfacetsearch.search.SearchQuery.Operator;
import de.hybris.platform.solrfacetsearch.search.SearchResult;
import de.hybris.platform.solrfacetsearch.search.context.FacetSearchContext;
import de.hybris.platform.solrfacetsearch.search.context.FacetSearchListener;
import de.hybris.platform.solrfacetsearch.search.impl.SolrSearchResult;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hsqldb.lib.Set;



public class FlintSolrSearchListener implements FacetSearchListener
{

	private static final Logger LOG = Logger.getLogger(FlintSolrSearchListener.class);

	@Resource
	private UserService userService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hybris.platform.solrfacetsearch.search.context.FacetSearchListener#afterSearch(de.hybris.platform.solrfacetsearch
	 * .search.context.FacetSearchContext)
	 */
	@Override
	public void afterSearch(final FacetSearchContext facetSearchContext) throws FacetSearchException
	{

		//Add logic here after search
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hybris.platform.solrfacetsearch.search.context.FacetSearchListener#afterSearchError(de.hybris.platform.
	 * solrfacetsearch.search.context.FacetSearchContext)
	 */
	public void afterSearchError(final FacetSearchContext arg0) throws FacetSearchException
	{
		// YTODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hybris.platform.solrfacetsearch.search.context.FacetSearchListener#beforeSearch(de.hybris.platform.solrfacetsearch
	 * .search.context.FacetSearchContext)
	 */
	@SuppressWarnings("deprecation") 
	@Override
	public void beforeSearch(final FacetSearchContext facetSearchContext) throws FacetSearchException
	{
		final UserModel user = userService.getCurrentUser();
		//this logic works for B2BCutomer, please add condition if you use normal User
		if (user instanceof B2BCustomerModel)
		{
			final B2BCustomerModel b2bCustomer = (B2BCustomerModel) user;
			final SearchQuery searchQuery = facetSearchContext.getSearchQuery();
			if(searchQuery.getUserQuery()==null)
			{
				searchQuery.addQuery("b2bunit_string_mv", b2bCustomer.getDefaultB2BUnit().getUid());
			}
			else
			{
				final HashSet values=new HashSet();
				values.add(b2bCustomer.getDefaultB2BUnit().getUid());
				searchQuery.addFilterQuery("b2bunit_string_mv", Operator.AND, values);
				final RawQuery rawQuery=new RawQuery("b2bunit_string_mv", b2bCustomer.getDefaultB2BUnit().getUid(), Operator.AND);
				final QueryField queryField=new QueryField("b2bunit_string_mv", Operator.AND,  values);
				searchQuery.getFilterQueries().add(queryField);
			}
		}

	}


}
