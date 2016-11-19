<%-- 
    Document   : cadastrarproduto
    Created on : 07/11/2016, 09:05:37
    Author     : 41583469
--%>


<%@page language="java" contentType="text/html;charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Login</title>
        <style>
            body{
                width: 100%;
                margin-top: 10%;
                font-family: sans-serif;
            }
            .text-middle{
                margin-right: auto;margin-left: auto;float: none;
            }
            .text-center{
                text-align: center;
            }

        </style>
    </head>
    <body>
        <div class="container">
            <h2 class="text-center">BLUSÃO FCI</h2>
            <div class="col-md-6 col-sm-6 col-xs-12 text-middle">
                <form action="${pageContext.request.contextPath}/usuario!doLogin.action" method="POST">
                    <div class="form-group">
                        <label for="user">Usuário:</label>
                        <input type="text" class="form-control" id="user" name="usuario" placeholder="user">
                    </div>
                    <div class="form-group">
                        <label for="pwd">Senha:</label>
                        <input type="password" class="form-control" id="pwd" name="senha" placeholder="password">
                    </div>
                    <div class="text-center">
                        <a class="btn btn-success" href="usuario!goToSignUp.action">Cadastrar-se</a>


                        <input class="btn btn-danger" type="submit" value="Confirmar">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
