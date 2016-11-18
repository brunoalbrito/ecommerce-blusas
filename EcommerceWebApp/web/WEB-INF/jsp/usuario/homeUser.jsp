<%-- 
    Document   : homeUser
    Created on : 14/11/2016, 12:59:13
    Author     : Beatriz
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
        <h1>Produtos</h1>

        <c:choose>
            <c:when test="${produtos.isEmpty()}">
                Não há produtos disponíveis.
            </c:when>
            <c:when test="${!produtos.isEmpty()}">
                <form action="${pageContext.request.contextPath}/compra!comprar.action" method="POST">
                    <ul>
                        <c:forEach var="produto" items="${produtos}" varStatus="cont">
                            <li>
                                <img src="${pageContext.request.contextPath}/imagens/${produto.id_produto}" width="256" height="256"><br/>
                                Cor: ${produto.cor}</br>
                                Tamanho: ${produto.tamanho} &nbsp; Preço: ${produto.preco}</br>
                                Descrição: ${produto.descricao} </br>

                                <label for="qtd">Quantidade </label>
                                <input type="number" min="1" id="qtd" value="0" name="${produto.id_produto}"/>
                            </li>
                        </c:forEach>
                    </ul>
                    <input type="submit" value="Comprar">
                </form>

            </c:when>
        </c:choose>
    </body>
</html>
