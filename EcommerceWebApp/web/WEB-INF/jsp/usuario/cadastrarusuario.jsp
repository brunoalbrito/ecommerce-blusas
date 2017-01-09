<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html;charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>

<c:import url="../../../template/header.jsp"/>
<link href="${pageContext.request.contextPath}/css/singup/default.css" rel="stylesheet" type="text/css"/>
<body>
    <h2 class="text-center">Cadastre-se</h2>
    <h3 class="text-center">Informações Pessoais</h3>
    <div class="col-md-12 col-sm-12 col-xs-12 text-middle form-group">
        <div class="col-md-6 col-sm-6 col-xs-12 text-middle">
            <form action="${pageContext.request.contextPath}/usuario!insert.action" method="POST">
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

                <h3 class="text-center">Endereço</h3>
                
                <label>CEP: </label>
                <p><input class="form-control" type="text" name="cep"></p>

                <label>Rua: </label>
                <p><input class="form-control" type="text" name="rua"></p>

                <label>Bairro: </label>
                <p><input class="form-control" type="text" name="bairro"></p>

                <label>Cidade: </label>
                <p><input class="form-control" type="text" name="cidade"></p>

                <label>Estado: </label>
                <p><input class="form-control" type="text" name="estado"></p>

                <div class="col-md-5 col-sm-12 col-xs-12 text-middle">
                    <input id="button_confirmar" type="submit" class="btn btn-danger" value="Confirmar">
                </div>
            </form>            
        </div>
    </div>
    <c:import url="../../../template/footer.jsp"/>
</body>