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
        <title>Listar Produto</title>

        <style>
            body{
                width: 100%;
                font-family: sans-serif;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1 style="text-align: center">Listar Produtos</h1>
            <div class="row text-center slideanim">
                <div class="col-md-4">
                    <div class="thumbnail">
                        <c:forEach var="i" items="${produtos}">        
                            <img src="${pageContext.request.contextPath}/imagens/${i.id_produto}" style="width:100%">
                            <div class="caption">
                                <p>Cor: <c:out value="${i.cor}"></c:out></br>
                                    Tamanho:<c:out value="${i.tamanho}"></c:out><br>&nbsp;Preço:<c:out value="${i.preco}"></c:out></br>
                                    Descrição:<c:out value="${i.descricao}"></c:out><br>
                                    <a class="btn btn-info btn-xs" href="${pageContext.request.contextPath}/produto!editar.action?id=${i.id_produto}">Editar</a>
                                </p>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
