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
        <form method="POST" action="${pageContext.request.contextPath}">
            <c:out value="${produto}"></c:out>
            <p>Cor: </p>
            <p><input type="text" name="cor" value="${produto.cor}"></p>
            <p>Tamanho:</p>
            <p><input type="text" name="tamanho" value="${produto.tamanho}"></p>
            <p>Preco: </p>
            <p><input type="text" name="preco" value="${produto.preco}"></p>
            <p>Descrição</p>
            <p><textarea name="descricao" rows="10" cols="50" maxlength="800">${produto.descricao}</textarea> </p>
            <button type="submit" formaction="${pageContext.request.contextPath}/produto!alterar.action?id_produto=${produto.id_produto}">Alterar</button>&nbsp;
            <button onclick="confirmar()" formaction="${pageContext.request.contextPath}/produto!remover.action?id_produto=${produto.id_produto}">Excluir Produto</button>
        </form>
<!--        <script type="text/javascript">
            function confirmar()
            {
                var resp = confirm("Deseja realmente excluir");
                if(resp){
                    window.location.
                }
            }
        </script>-->
    </body>
</html>
