<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html;charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>

<c:import url="../../../template/header.jsp"/>
<script src="${pageContext.request.contextPath}/js/endereco.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/css/singup/default.css" rel="stylesheet" type="text/css"/>
<body>
    <h2 class="text-center">Cadastre-se</h2>
    <h3 class="text-center">Informações Pessoais</h3>
    <div class="col-md-12 col-sm-12 col-xs-12 text-middle form-group">
        <div class="col-md-6 col-sm-6 col-xs-12 text-middle">
            <form action="${pageContext.request.contextPath}/usuario!insert.action" method="POST">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <label>Nome: </label>
                    <p><input class="form-control" type="text" name="nome"></p>

                    <label>Sobrenome: </label>
                    <p><input class="form-control" type="text" name="sobrenome"></p>

                    <label>Data de Nascimento</label>
                    <p><input class="form-control" type="date" name="dt_nascimento"></p>

                    <label>CPF: </label>
                    <p><input class="form-control" type="text" name="cpf"></p>

                    <label>Usuario:</label>
                    <p><input class="form-control" type="text" name="usuario"></p>

                    <label>Senha: </label>
                    <p><input class="form-control" type="password" name="senha"></p>
                </div>

                <!--ENDEREÇO-->
                <h3 class="text-center">Endereço</h3>


                <label>CEP: </label>
                <p><input class="form-control" id="cep" type="text" name="cep"></p>


                <label>Rua: </label>
                <p><input class="form-control" id="rua" type="text" name="rua" readonly></p>

                <label>Bairro: </label>
                <p><input class="form-control" id="bairro" type="text" name="bairro" readonly></p>


                <div class="col-md-8 col-sm-8 col-xs-12">
                    <label>Cidade: </label>
                    <p><input class="form-control" id="cidade" type="text" name="cidade" readonly></p>
                </div>

                <div class="col-md-4 col-sm-4 col-xs-12">
                    <label>Estado: </label>
                    <p><input class="form-control" id="uf" type="text" name="estado" readonly></p>
                </div>


                <label>Número: </label>
                <p><input class="form-control"  type="text" name="numero" value="Não está no Banco de Dados"></p>


                <div class="col-md-5 col-sm-12 col-xs-12 text-middle">
                    <input id="button_confirmar" type="submit" class="btn btn-danger" value="Confirmar">
                </div>
            </form>  
        </div>
    </div>
</body>
<c:import url="../../../template/footer.jsp"/>