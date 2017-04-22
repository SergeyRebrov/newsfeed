<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-12">

    <c:url var="firstUrl" value="/news/1"/>
    <c:url var="lastUrl" value="/news/${totalPages}"/>
    <c:url var="prevUrl" value="/news/${currentIndex - 1}"/>
    <c:url var="nextUrl" value="/news/${currentIndex + 1}"/>

    <c:if test="${totalPages != 0}">
        <ul class="pagination">
            <c:choose>
                <c:when test="${currentIndex == 1}">
                    <li class="hidden"><a href="#">&lt;&lt;</a></li>
                    <li class="hidden"><a href="#">&lt;</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${firstUrl}">&lt;&lt;</a></li>
                    <li><a href="${prevUrl}">&lt;</a></li>
                </c:otherwise>
            </c:choose>
            <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
                <c:url var="pageUrl" value="/news/${i}"/>
                <c:choose>
                    <c:when test="${i == currentIndex}">
                        <li class="active"><a href="${pageUrl}"><c:out value="${i}"/></a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${pageUrl}"><c:out value="${i}"/></a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:choose>
                <c:when test="${currentIndex == totalPages}">
                    <li class="hidden"><a href="#">&gt;</a></li>
                    <li class="hidden"><a href="#">&gt;&gt;</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${nextUrl}">&gt;</a></li>
                    <li><a href="${lastUrl}">&gt;&gt;</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </c:if>
</div>