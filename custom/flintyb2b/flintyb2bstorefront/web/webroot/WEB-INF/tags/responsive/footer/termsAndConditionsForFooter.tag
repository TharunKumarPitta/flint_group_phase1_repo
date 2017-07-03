<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="currentURL" value="${pageContext.request.contextPath}" />

<cms:pageSlot position="Section2B" var="feature" class="termsAndConditions-section" element="div">
	<cms:component component="${feature}" element="div" class="clearfix"/>
	<a href="${currentURL}" class="btn btn-primary btn-block">
		<spring:theme code="checkout.summary.placeOrder.readTermsAndConditions.close" text="Close" />
	</a>
</cms:pageSlot>
