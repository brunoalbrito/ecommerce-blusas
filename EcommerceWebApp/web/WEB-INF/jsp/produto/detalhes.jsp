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
        <title>Detalhes - ${produto.descricao} </title>
    </head>
    <body>
        <form method="POST" action="${pageContext.request.contextPath}/usuario!exibirItemCarrinho.action?id_produto=${produto.id_produto}">
            <%--<c:out value="${produto}"></c:out>--%>
            <img src="${pageContext.request.contextPath}/imagens/${produto.id_produto}" class="img-responsive" style="width:50%;height: 50%;" alt="Image">
            <input type="text" name="qtd" required="true" placeholder="Quantidade">
            <input type="submit" value="Comprar">
            <button type="button" onclick="addCarrinho()">Adicionar ao carrinho</button>
        </form>
        <script type="text/javascript">
            function addCarrinho() {
                var qtd = document.getElementsByName("qtd")[0].value;
                var redirect = ("${pageContext.request.contextPath}/usuario!addCarrinho.action?id_produto=${produto.id_produto}&qtd="+qtd);
                window.location = redirect;
            }
        </script>
    </body>
</html>
