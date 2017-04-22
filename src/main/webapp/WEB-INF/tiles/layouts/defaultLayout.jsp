<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Sergey
  Date: 18.04.2017
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/custom.css" />"/>
</head>
<body>
<div class="container">
    <div class="row border col-md-10 col-md-offset-1">
        <tiles:insertAttribute name="addNews"/>
        <tiles:insertAttribute name="amountNews"/>
        <tiles:insertAttribute name="newsLine"/>
        <tiles:insertAttribute name="pagination"/>
        <tiles:insertAttribute name="body"/>
    </div>
</div>
</body>
</html>
