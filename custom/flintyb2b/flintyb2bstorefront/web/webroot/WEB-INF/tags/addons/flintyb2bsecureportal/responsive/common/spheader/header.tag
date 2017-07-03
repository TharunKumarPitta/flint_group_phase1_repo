<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="footer" tagdir="/WEB-INF/tags/responsive/common/footer"  %>

<spring:htmlEscape defaultHtmlEscape="true"/>

<cms:pageSlot position="TopHeaderSlot" var="component" element="div" class="container">
	<cms:component component="${component}" />
</cms:pageSlot>

<header class="main-header main-header-md">
    <nav class="navigation navigation--top ">
        <div class="row">
            <div class="col-sm-6 col-xs-3">
						<div class="nav__left js-site-logo">
							<cms:pageSlot position="SiteLogo" var="logo" limit="1">
								<cms:component component="${logo}"/>
							</cms:pageSlot>
						</div>
			</div>

			<div class="col-sm-6">

						<div class="header-lang-drop col-md-3 col-md-offset-3" style="margin-top: 55px;width: 110px;margin-left: 324px;">
							<footer:languageSelector languages="${languages}"
													 currentLanguage="${currentLanguage}" />
						</div>
						<div class="nav__left js-site-logo logo-rely logo-right">

							<c:choose>
								<c:when test="${currentLanguage.isocode eq 'zh'}">
									<img src="${commonResourcePath}/images/relyonus_zh.png" alt="rely on us" class="img-rely hidden-xs"/>
								</c:when>
								<c:otherwise>
									<img src="${commonResourcePath}/images/caption.png" alt="rely on us" class="img-rely hidden-xs"/>
								</c:otherwise>
							</c:choose>


							<img src="${commonResourcePath}/images/mobile-caption.png" alt="rely on us" class="img-rely visible-xs"/>
					<!-- 	<cms:pageSlot position="SiteLogo" var="logo" limit="1">
							<cms:component component="${logo}"/>
						</cms:pageSlot> -->
						</div>
			</div>
		</div>

    </nav>
</header>