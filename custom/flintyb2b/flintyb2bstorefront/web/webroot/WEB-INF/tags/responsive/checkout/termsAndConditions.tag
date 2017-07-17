<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/checkout/multi/summary/view" var="summaryViewUrl"/>

<cms:pageSlot position="Section2B" var="feature" class="termsAndConditions-section" element="div">
	<cms:component component="${feature}" element="div" class="clearfix"/>
	<input type="hidden" id="popup-title" value = "<spring:theme code='term.condition'/>">
	<a href="${summaryViewUrl}" class="btn btn-primary btn-block">
		<spring:theme code="checkout.summary.placeOrder.readTermsAndConditions.close" text="Close" />
	</a>
</cms:pageSlot>
