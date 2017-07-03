<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>


<footer>


    <cms:pageSlot position="Footer" var="feature" >

        &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;<cms:component component="${feature}" />&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;

    </cms:pageSlot>
    
   
</footer>

