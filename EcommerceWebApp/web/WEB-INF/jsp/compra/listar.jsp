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
        <title>Listar Compra</title>
    </head>
    <body>
        <h1 style="text-align: center">Listar Todos os Produtos</h1>
    <c:forEach var="i" items="${compras}">        
        <%--<c:out value="${i}"></c:out>--%>
        Compra:
        Id: ${i.id_compra}<br/>
        Nome do comprador: ${i.usuario.nome}&nbsp;${i.usuario.sobrenome}<br/>
        Data do Pedido : ${i.dt_pedido}<br/>
        Valor: ${i.dt_pedido}<br/>
        Entrega: ${i.entregue}<br/>
        Pagamento realizado : ${i.pagamento}<br/>
        <a href="#">Simular Pagamento e Entrega</a>
    </c:forEach>
    </body>
</html>
