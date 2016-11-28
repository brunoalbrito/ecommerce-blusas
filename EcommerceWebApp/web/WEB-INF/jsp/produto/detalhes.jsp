<%-- 
    Document   : detalhes
    Created on : 28/11/2016, 15:29:13
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
        <form method="POST" action="${pageContext.request.contextPath}/usuario!exibirItemCarrinho.action?id_produto=${produto.id_produto}">
            <c:out value="${produto}"></c:out>
            <img src="${pageContext.request.contextPath}/imagens/${produto.id_produto}" class="img-responsive" style="width:50%;height: 50%;" alt="Image">
            <input type="submit" value="Comprar">
        </form>
        <form method="POST" action="${pageContext.request.contextPath}/usuario!addCarrinho.action?id_produto=${produto.id_produto}">
            <input type="submit" value="Adicionar ao carrinho">
        </form>
    </body>
</html>
