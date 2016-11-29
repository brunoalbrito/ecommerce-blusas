<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html;charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>

<c:import url="../../../template/header.jsp"/>
<h2 class="text-center">Cadastre-se</h2>
<h3 class="text-center">Informações Pessoais</h3>
<div class="text-middle">
    <form action="${pageContext.request.contextPath}/usuario!insert.action" method="POST">
        <p>Nome: </p>
        <p><input type="text" name="nome"></p>

        <p>Sobrenome: </p>
        <p><input type="text" name="sobrenome"></p>

        <p>Data de Nascimento</p>
        <p><input type="date" name="dt_nascimento"></p>

        <p>CPF: </p>
        <p><input type="text" name="cpf"></p>

        <p>Usuario:</p>

        <p><input type="text" name="usuario"></p>
        <p>Senha: </p>

        <p><input type="password" name="senha"></p>

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

        <button type="submit" class="btn btn-danger">Confirmar</button>         
</form>

<%--<c:import url="../../../template/footer.jsp"/>--%>