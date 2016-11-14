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
        <title>Login</title>
        <style>
            input[type="text"]{
                border-radius: 4px;
                width: 50%;
                height: 25px;
                background:activecaption;
            }
        </style>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/usuario!doLogin.action" method="POST">
            <p>Usuario: </p>
            <p><input type="text" name="usuario"></p>
            <p>Senha: </p>
            <p><input type="password" name="senha"></p>
            <a href="${pageContext.request.contextPath}/usuario/cadastrarusuario.jsp">Cadastrar-se</a>
          
            
            <input type="submit" value="Confirmar">
        </form>
       
    </body>
</html>
