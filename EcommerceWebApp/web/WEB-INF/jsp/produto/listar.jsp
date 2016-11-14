<%-- 
    Document   : listar
    Created on : 08/11/2016, 11:22:52
    Author     : 41583469
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Produto</title>
    </head>
    <body>
        <h1 style="text-align: center">Listar Todos os Produtos</h1>
    <c:forEach var="i" items="${produtos}">        
        <img src="${pageContext.request.contextPath}/imagens/${i.id_produto}" width="256" height="256">
        <p>Cor: <c:out value="${i.cor}"></c:out></br>
            Tamanho:<c:out value="${i.tamanho}"></c:out>&nbsp;Preço:<c:out value="${i.preco}"></c:out></br>
            Descrição:<c:out value="${i.descricao}"></c:out>
            <a href="${pageContext.request.contextPath}/produto!editar.action?id=${i.id_produto}">Editar</a>
        </p>
    </c:forEach>
    </body>
</html>
