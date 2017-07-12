package com.flintgroup.core.util;

import de.hybris.platform.b2b.model.B2BCustomerModel;
import de.hybris.platform.b2b.model.B2BUnitModel;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.solrfacetsearch.search.Document;
import de.hybris.platform.solrfacetsearch.search.FacetSearchException;
import de.hybris.platform.solrfacetsearch.search.SearchQuery;
import de.hybris.platform.solrfacetsearch.search.SearchResult;
import de.hybris.platform.solrfacetsearch.search.context.FacetSearchContext;
import de.hybris.platform.solrfacetsearch.search.context.FacetSearchListener;
import de.hybris.platform.solrfacetsearch.search.impl.SolrSearchResult;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;



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

////		final SearchResult searchResult = facetSearchContext.getSearchResult();
////		if (searchResult != null && searchResult.getNumberOfResults() > 0)
////		{
////			final List<? extends ItemModel> results = searchResult.getResults();
////			final List<Document> documentList = searchResult.getDocuments();
////			final List<Document> documentListNew = new ArrayList<Document>();
////			final UserModel user = userService.getCurrentUser();
////			ProductModel productModel = null;
////			//this logic works for B2BCutomer, please add condition if you use normal User
////			try
////			{
////				if (user instanceof B2BCustomerModel)
////				{
////					final B2BCustomerModel b2bCustomer = (B2BCustomerModel) user;
////					for (int i = 0; i < results.size(); i++)
////					{
////						final ItemModel item = results.get(i);
////						if (item instanceof ProductModel)
////						{
////							productModel = (ProductModel) item;
////							if (null == productModel.getB2bunit() || productModel.getB2bunit().isEmpty())
////							{
////								documentListNew.add(documentList.get(i));
////							}
////							else
////							{
////								for (final B2BUnitModel custId : productModel.getB2bunit())
////								{
////									if (!b2bCustomer.getDefaultB2BUnit().getUid().equals(custId.getUid()))
////									{
////										documentListNew.add(documentList.get(i));
////									}
////								}
////							}
////						}
////					}
////				}
////				documentList.removeAll(documentListNew);
////				((SolrSearchResult) searchResult).setDocuments(documentList);
////				((SolrSearchResult) searchResult).setNumberOfResults(documentList.size());
////				facetSearchContext.setSearchResult(searchResult);
////			}
////			catch (final Exception exception)
////			{
////				LOG.error(exception);
////			}
//		}
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
	@Override
	public void beforeSearch(final FacetSearchContext facetSearchContext) throws FacetSearchException
	{
		final UserModel user = userService.getCurrentUser();

		if (user instanceof B2BCustomerModel)
		{
			final B2BCustomerModel b2bCustomer = (B2BCustomerModel) user;
			final SearchQuery searchQuery = facetSearchContext.getSearchQuery();

			if(searchQuery.getUserQuery()==null)
			{
				searchQuery.addQuery("b2bunit_string_mv", b2bCustomer.getDefaultB2BUnit().getUid());
			}
		}

	}


}
