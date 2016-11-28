<%-- 
    Document   : cadastrarproduto
    Created on : 07/11/2016, 09:05:37
    Author     : 41583469
--%>


<%@page language="java" contentType="text/html;charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
    <head>
        <meta charset="ISO-8859-1">
        <title>Login Form</title>
    </head>

    <body>
        <div class="login">
            <h1>Login</h1>
            <form action="${pageContext.request.contextPath}/usuario!doLogin.action" method="POST">
                <input type="text" name="usuario" placeholder="Username" required="required" />
                <input type="password" name="senha" placeholder="Password" required="required" />
                <button type="submit" class="">Confirmar</button>
            </form>
        </div>
    </body>
</html>

