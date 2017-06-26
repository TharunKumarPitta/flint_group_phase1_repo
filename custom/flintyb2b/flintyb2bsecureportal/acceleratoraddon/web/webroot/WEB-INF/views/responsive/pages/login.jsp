<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sptemplate" tagdir="/WEB-INF/tags/addons/secureportaladdon/responsive/sptemplate" %>
<%@ taglib prefix="spuser" tagdir="/WEB-INF/tags/addons/secureportaladdon/responsive/spuser" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<sptemplate:page pageTitle="${pageTitle}">
	<jsp:body>
        <div class="row">
            <div class="col-sm-6 col-md-6">
                <div class="lets-talk-session">
                   <!-- <div class="account-text">Don't have an account ?</div> -->
                     <div class="account-letstalk-text"> <img src="${commonResourcePath}/images/account.png"/></div>
                     <div class="account-letstalk"><button type="button" class="btn btn-talk but"></button></div>
                </div>
            </div>
            
            <div class="col-sm-4 col-md-4">
                <div class="login-section flint-login-section">
                    <c:url value="/j_spring_security_check" var="loginActionUrl"/>
                    <spuser:login actionNameKey="login.login" action="${loginActionUrl}"/>
                </div>
            </div>
        </div>
	</jsp:body>
</sptemplate:page>
