<%-- 
    Document   : cadastrarproduto
    Created on : 07/11/2016, 09:05:37
    Author     : 41583469
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Produto</title>
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
        <form>
            <p>Cor: </p>
            <p><input type="text" name="cor" ></p>
            <p>Tamanho:</p>
            <p><input type="text" name="tamanho"></p>
            <p>Preco: </p>
            <p><input type="text" name="preco"></p>
            <p>Descrição</p>
            <p><input type="text" name="descricao"></p>
            <input type="button" value="Confirmar">
        </form>
    </body>
</html>
