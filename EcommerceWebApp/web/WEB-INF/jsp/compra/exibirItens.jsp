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
        <form method="POST" action="${pageContext.request.contextPath}/usuario!comprar.action">
            <c:forEach var="i" items="${sessionScope.itens}">
                <c:out value="${i}">
                </c:out>
                </br>
            </c:forEach>
            <input type="submit" value="Finalizar Compra">
        </form>
    </body>
</html>
