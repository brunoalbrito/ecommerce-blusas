<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html;charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>

<c:import url="../../../template/header.jsp"/>
<h2 class="text-center">Cadastre-se</h2>
<h3 class="text-center">Informações Pessoais</h3>
<div class="container">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <form action="${pageContext.request.contextPath}/usuario!insert.action" method="GET">
            <p>Nome: </p>
            <p><input type="text" class="form-control" name="nome"></p>

            <p>Sobrenome: </p>
            <p><input type="text" class="form-control" name="sobrenome"></p>

            <p>Data de Nascimento</p>
            <p><input type="date" class="form-control" name="dt_nascimento"></p>

            <p>CPF: </p>
            <p><input type="text" class="form-control" name="cpf"></p>

            <p>Usuario: </p>

            <p><input type="text" class="form-control" name="usuario"></p>
            <p>Senha: </p>

            <p><input type="password" class="form-control" name="senha"></p>

            <hr>

            <h3 class="text-center">Endereço</h3>

            <p>Rua: </p>
            <p><input type="text" class="form-control" name="rua"></p>

            <p>Bairro: </p>
            <p><input type="text" class="form-control" name="bairro"></p>

            <p>Cidade: </p>
            <p><input type="text" class="form-control" name="cidade"></p>

            <p>Estado: </p>
            <p><input type="text" class="form-control" name="estado"></p>

            <p>CEP: </p>
            <p><input type="text" class="form-control" name="cep"></p>
        </div>
        <div class="form-group text-center">
            <button type="submit" class="btn btn-danger">Confirmar</button>         
        </div>
    </form>
</div>
</div>

<c:import url="../../../template/footer.jsp"/>