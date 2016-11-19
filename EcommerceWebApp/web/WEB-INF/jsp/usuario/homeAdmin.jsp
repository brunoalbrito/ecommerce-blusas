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
                font-family: sans-serif;
            }
            .text-middle{
                margin-right: auto;margin-left: auto;float: none;
                text-align: center;
            }
            .text-center{
                text-align: center;
            }
            footer {
                color: white; 
                background-color: #000;
                padding: 25px;
                float:end;
                bottom: 0;

            }
        </style>
    </head>
    <body>

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                        <li><a href="${pageContext.request.contextPath}/produto/cadastrarproduto.jsp">Cadastrar Produto</a></li>
                        <li><a href="${pageContext.request.contextPath}/produto!listarTodos.action">Listar Produto</a></li>
                        <li><a href="${pageContext.request.contextPath}/compra!listarTodos.action">Listar Compras</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <footer class="container-fluid text-center">
            <p>© TODOS OS DIREITOS RESERVADOS</p>
        </footer>
    </body>
</html>