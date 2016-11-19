<%-- 
    Document   : index
    Created on : 07/11/2016, 09:16:58
    Author     : 41583469
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Blusas Mackenzie</title>

        <style>
            body{
                width: 100%;
                margin-top: 10%;
                font-family: sans-serif;
            }
            .text-middle{
                margin-right: auto;margin-left: auto;float: none;
                text-align: center;
            }
            .text-center{
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Blusão FCI</h1>
            <div class="col-md-6 col-sm-6 col-xs-12 text-middle">
                <p><a class="btn btn-success" href="${pageContext.request.contextPath}/produto/cadastrarproduto.jsp">Cadastrar Produto</a>
                <p><a class="btn btn-warning" href="${pageContext.request.contextPath}/produto!listarTodos.action">Listar Produto</a>  
                <p><a class="btn btn-warning" href="${pageContext.request.contextPath}/compra!listarTodos.action">Listar Compras</a>  
            </div>
        </div>
    </body>
</html>