<%-- 
    Document   : exibirItens
    Created on : 28/11/2016, 17:18:49
    Author     : Bruno
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach var="i" items="${sessionScope.itens}">
            <c:out value="${i}">
            </c:out>
            </br>
        </c:forEach>
    </body>
</html>
