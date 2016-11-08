<%-- 
    Document   : cadastrarproduto
    Created on : 07/11/2016, 09:05:37
    Author     : 41583469
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html;charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Editar Produto</title>
        <style>
            input[type="text"]{
                border-radius: 4px;
                width: 50%;
                height: 25px;
            }
        </style>
    </head>
    <body>
        <h1>Editar Produto</h1>
        <form>
            <p>Cor: </p>
            <p><input type="text" name="cor" value="${produto.cor}"></p>
            <p>Tamanho:</p>
            <p><input type="text" name="tamanho" value="${produto.tamanho}"></p>
            <p>Preco: </p>
            <p><input type="text" name="preco" value="${produto.preco}"></p>
            <p>Descrição</p>
            <p><textarea name="descricao" rows="10" cols="50" maxlength="800">${produto.descricao}</textarea> </p>
            <input type="submit" value="Alterar">
        </form>
    </body>
</html>
