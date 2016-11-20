<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html;charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>

<c:import url="../../../template/header.jsp"/>

        <form action="${pageContext.request.contextPath}/usuario!insert.action" method="GET">
            <p>Nome: </p>
            <p><input type="text" name="nome"></p>
            
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
            
            <select name="tipo">
                <c:forEach var="tipo" items="${tipoUsuarios}" varStatus="cont">
                    <option value="${cont.index}">${tipo.toString()}</option>                    
                </c:forEach>
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
            
<c:import url="../../../template/footer.jsp"/>