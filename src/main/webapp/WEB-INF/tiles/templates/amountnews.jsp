<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="small"><a href="<c:url value="/addnews"/>">Add News</a></div>
<div class="col-lg-offset-8 col-lg-4">
    <h5>Amount of news on the page</h5>
    <c:url var="amountAction" value="/news/amount"/>
    <form:form action="${amountAction}" method="post">
        <label class="radio-inline">
            <c:choose>
                <c:when test="${amountNews == 10}">
                    <input name="radioGroup" value="10" checked="" type="radio"> 10
                </c:when>
                <c:otherwise>
                    <input name="radioGroup" value="10" type="radio"> 10
                </c:otherwise>
            </c:choose>
        </label>
        <label class="radio-inline">
            <c:choose>
                <c:when test="${amountNews == 20}">
                    <input name="radioGroup" value="20" checked="" type="radio"> 20
                </c:when>
                <c:otherwise>
                    <input name="radioGroup" value="20" type="radio"> 20
                </c:otherwise>
            </c:choose>
        </label>
        <label class="radio-inline">
            <c:choose>
                <c:when test="${amountNews == 50}">
                    <input name="radioGroup" value="50" checked="" type="radio"> 50
                </c:when>
                <c:otherwise>
                    <input name="radioGroup" value="50" type="radio"> 50
                </c:otherwise>
            </c:choose>
        </label>
        <input type="submit" class="btn btn-default" value="Choose"/>
    </form:form>
</div>
<div class="clearfix"></div>
