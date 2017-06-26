<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="footer" tagdir="/WEB-INF/tags/responsive/common/footer"  %>

<div class="container-fluid">
    <div class="footer__top">
        <div class="row">
            <div class="footer__left col-xs-12 col-sm-12 col-md-12">
                <div class="row">
                    <!-- <c:forEach items="${navigationNodes}" var="node">
                        <c:if test="${node.visible}">
                            <c:forEach items="${node.links}" step="${component.wrapAfter}"
                                       varStatus="i">

                                <div class="footer__nav--container col-xs-12 col-sm-3">
                                    <c:if test="${component.wrapAfter > i.index}">
                                        <div class="title">${node.title}</div>
                                    </c:if>
                                    <ul class="footer__nav--links">
                                        <c:forEach items="${node.links}" var="childlink"
                                                   begin="${i.index}" end="${i.index + component.wrapAfter - 1}">
                                            <cms:component component="${childlink}"
                                                           evaluateRestriction="true" element="li" class="footer__link"/>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </c:forEach>
                        </c:if>
                    </c:forEach> -->
                    
                    <div class="footer__nav--container col-xs-12 col-sm-2">
                     <ul class="footer__nav--links">
                         <li> <a href="http://www.flintgrp.com/en/news-information/press-releases/" target="_blank"> About Flint Group </a> </li>
                        </ul>
                    </div>
                    
                    <div class="footer__nav--container col-xs-12 col-sm-2">
                     <ul class="footer__nav--links">
                         <li> <a href="http://www.flintgrp.com/en/contact/" target="_blank"> General Inquiries </a> </li>
                        </ul>
                    </div>
                    
                    
                    <div class="footer__nav--container col-xs-12 col-sm-2">
                     <ul class="footer__nav--links">
                         <li style="margin-left: 10px;"> <a href="http://www.flintgrp.com/en/careers/" target="_blank"> FAQ </a> </li>
                        </ul>
                    </div>
                    
                     <div class="footer__nav--container col-xs-12 col-sm-2">
                     <ul class="footer__nav--links">
                         <li> <a href="http://www.flintgrp.com/en/company/conditions-of-sale/" target="_blank"> Terms & Conditions </a> </li>
                        </ul>
                    </div>
                    
                    
                     <div class="footer__nav--container col-xs-12 col-sm-2">
                     <ul class="footer__nav--links">
                         <li> <a href="http://www.flintgrp.com/en/news-information/press-releases/" target="_blank"> News & Information </a> </li>
                        </ul>
                    </div>
                    
                    
                     <div class="footer__nav--container col-xs-12 col-sm-2">
                     <ul class="footer__nav--links">
                         <li> <a href="http://www.flintgrp.com/en/privacy-note/" target="_blank"> Privacy Policy </a> </li>
                        </ul>
                    </div>
                    
                    
                    
                    
                    
                </div>
            </div>
            <div class="footer__right col-xs-12 col-md-3">
            
              <!--  <c:if test="${showLanguageCurrency}">
                    <div class="row">
                        <div class="col-xs-6 col-md-6 footer__dropdown">
                            <footer:languageSelector languages="${languages}"
                                                     currentLanguage="${currentLanguage}" />
                        </div>
                        <div class="col-xs-6 col-md-6 footer__dropdown">
                            <footer:currencySelector currencies="${currencies}"
                                                     currentCurrency="${currentCurrency}" />
                        </div>
                    </div>
                </c:if> -->
            </div>
        </div>
    </div>
</div>

<div class="footer__bottom">
    <div class="footer__copyright">
      <!--  <div class="container">${notice}</div> -->
        <div class="container foot-container">
        <p class="pull-left"> <img src="${commonResourcePath}/images/footer-logo.png"/> </p>
            <div class="pull-right">
                <ul class="nav nav-pills payments">
                    <li> <a href="#"><img src="${commonResourcePath}/images/twitter.png"/></a></li>
                    <li> <a href="#"><img src="${commonResourcePath}/images/instagram.png"/></a></li>
                    <li> <a href="#"><img src="${commonResourcePath}/images/in.png"/></a></li>
                    <li> <a href="#"><img src="${commonResourcePath}/images/fb.png"/></a></li>                  
                </ul> 
            </div>
        
        </div>
    </div>
</div>
