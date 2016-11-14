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
        <form action="${pageContext.request.contextPath}/usuario!insert.action" method="GET">
            <p>Nome: </p>
            <p><input type="text" name="name"></p>
            <p>Sobrenome: </p>
            <p><input type="text" name="sobrenome"></p>
            <p>Data de Nascimento</p>
            <p><input type="date" name="dt_nascimento"></p>
            <p>CPF: </p>
            <p><input type="text" name="cpf"></p>
            <p>Usuario: </p>
            <p><input type="text" name="usuario"></p>
            <p>Senha: </p>
            <p><input type="password" name="senha"></p>
            <p>Tipo de Usuário: </p>
            <select>
                <option>Tipo 1</option>
                <option>Tipo 2</option>
            </select>
            <hr>
            <h3>Endereço</h3>
            
            <p>Rua: </p>
            <p><input type="text" name="rua"></p>
            <p>Bairro: </p>
            <p><input type="text" name="bairro"></p>
            <p>Cidade: </p>
            <p><input type="text" name="cidade"></p>
            <p>Estado: </p>
            <p><input type="text" name="estado"></p>
            <p>CEP: </p>
            <p><input type="text" name="cep"></p>
            
            <input type="submit" value="Confirmar">
        </form>
    </body>
</html>
