<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="col-md-12">
    <h3>News Line</h3>
</div>

<div class="col-md-12">
    <c:if test="${!empty listNews}">
        <div>
            <c:forEach items="${listNews}" var="oneNews">

                <div class="border">
                    <div class="small">
                        <fmt:formatDate value="${oneNews.publicationDate}"
                                        pattern="dd MMMM yyyy"/>
                    </div>
                    <div class="lead">${oneNews.heading}</div>

                    <div><img src="${oneNews.imageUrl}"></div>

                    <div>${oneNews.newsBody}</div>
                </div>

            </c:forEach>
        </div>
    </c:if>
</div>