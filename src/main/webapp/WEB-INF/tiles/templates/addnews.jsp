<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<div class="small"><a href="/">Home Page</a></div>
<div class="col-md-12">
    <h3>Add news</h3>
    <c:url var="addAction" value="/addnews/add"/>
    <form:form action="${addAction}" method="post" modelAttribute="news"
               enctype="multipart/form-data" cssClass="form-horizontal col-xs-6">

        <div class="form-group">
            <form:label path="heading">Heading</form:label>
            <div>
                <form:input path="heading" cssClass="form-control"/>
                <form:errors path="heading" cssClass="alert-danger"/>
            </div>
        </div>
        <div class="form-group">
            <label>Publication Date</label>
            <div>
                <input type="date" name="publicationDate" class="form-control" placeholder="yyyy-MM-dd"/>
                <form:errors path="publicationDate" cssClass="alert-danger"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="newsBody">Text News</form:label>
            <div>
                <form:textarea path="newsBody" cssClass="form-control"/>
                <form:errors path="newsBody" cssClass="alert-danger"/>
            </div>
        </div>

        <div class="form-group">
            <label>Upload image</label>
            <div>
                <input type="file" name="image">
                <div class="alert-danger">${error}</div>
            </div>
        </div>

        <div class="form-group">
            <div>
                <input type="submit" value="Add News" class="btn btn-default"/>
            </div>
        </div>
    </form:form>
    <div class="clearfix"></div>
</div>