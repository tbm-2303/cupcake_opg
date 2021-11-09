<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Home
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div class="bodyBg">
            <h2 class="display-4">Velkommen ombord</h2>

            <p class="lead velkommenP">
                Øens bedste cupcakes. Vælg og bestil her:
            </p>

            <div class="btnOptions">
                <a type="button" class="btn btn-sm btn-primary btn-lg mb-5" href="${pageContext.request.contextPath}/fc/orderpage">Bestil cupcakes</a>

                <a type="button" class="btn btn-sm btn-primary btn-lg mb-5" href="">Se udvalg</a>

            </div>

            <c:if test="${sessionScope.role == 'employee' }">
            <p style="font-size: larger">This is what you can do,
                since your are logged in as an employee</p>
            <p><a href="fc/employeepage">Employee Page</a>
                </c:if>

                <c:if test="${sessionScope.role == 'customer' }">
            <p style="font-size: larger">This is what you can do, since your
                are logged in as a customer</p>
            <p><a href="fc/customerpage">Customer Page</a>
                </c:if>

        </div>

    </jsp:body>
</t:genericpage>