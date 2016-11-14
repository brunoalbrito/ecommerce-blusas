<%--    Document   : cadastrarproduto
    Created on : 07/11/2016, 09:05:37
    Author     : 41583469
--%>


<%@page language="java" contentType="text/html;charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cadastrar Produto</title>
        <style>
            input[type="text"]{
                border-radius: 4px;
                width: 50%;
                height: 25px;
            }
        </style>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/produto!insert.action" method="POST" enctype="multipart/form-data">
            <p>Cor: </p>
            <p><input type="text" name="cor"></p>
            <p>Tamanho:</p>
            <p><input type="text" name="tamanho"></p>
            <p>Preco: </p>
            <p><input type="text" name="preco"></p>
            <p>Descri��o</p>
            <p><textarea name="descricao" rows="10" cols="50" maxlength="800"></textarea> </p>
            <p>Imagem:</p>
            <p><input type="file" name="imagem"/></p>
            <input type="submit" value="Confirmar">            
        </form>
    </body>
</html>