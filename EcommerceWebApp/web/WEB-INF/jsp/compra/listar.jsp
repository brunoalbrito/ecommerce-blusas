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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Listar Compra</title>
    </head>
    <body>
        <h1 style="text-align: center">Listar Compras</h1>
        <div class="container">
            <div class="row">
                <c:forEach var="i" items="${compras}"> 
                    <div class="col-md-6 col-sm-12 col-xs-12">
                        <div class="panel panel-danger">
                            <%--<c:out value="${i}"></c:out>--%>
                            <div class="panel-heading">Pedido número: ${i.id_compra}</div><br/>
                            <div class="panel-body">
                                Nome do comprador: ${i.usuario.nome}&nbsp;${i.usuario.sobrenome}<br/>
                                Data do Pedido : ${i.dt_pedido}<br/>
                                Valor Total: R$ ${i.total}<br/>
                                Entrega: ${i.entregue}<br/>
                                Pagamento realizado : ${i.pagamento}<br/>
                            </div>
                            <div class="panel-footer"><a href="#">Simular Pagamento e Entrega</a></div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
