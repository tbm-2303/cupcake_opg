<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:genericpage>
<jsp:attribute name="header">
         lagt i kurv
    </jsp:attribute>

<jsp:attribute name="footer">
    </jsp:attribute>

<jsp:body>


    <c:if test="${requestScope.error != null }">
        <p style="color:red">
                ${requestScope.error}
        </p>
    </c:if>

    <c:if test="${not empty param.msg}">
        <p style="font-size: large">${param.msg}</p>
    </c:if>
</jsp:body>
</t:genericpage>