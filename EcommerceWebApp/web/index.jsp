<%-- 
    Document   : index
    Created on : 19/11/2016, 17:15:46
    Author     : Bruno
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <c:set var="valor" scope="session" value="${false}"/>
    <c:if test="${valor == false}">
        <c:redirect url="/produto!showHome.action"/>
    </c:if>
    </body>
</html>
