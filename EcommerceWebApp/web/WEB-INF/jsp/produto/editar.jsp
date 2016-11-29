
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--<c:import url="../../../template/header.jsp"/>--%>
Editar Produto
<form method="POST" action="${pageContext.request.contextPath}">
    <c:out value="${produto}"></c:out>
        <p>Cor: </p>
        <p><input type="text"  name="cor" value="${produto.cor}"></p>

    <p>Tamanho:</p>
    <p><input type="text" name="tamanho" value="${produto.tamanho}"></p>
    <p>Preco: </p>
    <p><input type="text"  name="preco" value="${produto.preco}"></p>
    <p>Descrição</p>
    <p><textarea name="descricao"  rows="10" cols="50" maxlength="800">${produto.descricao}</textarea> </p>
    <button type="submit" class="btn btn-danger" formaction="${pageContext.request.contextPath}/produto!alterar.action?id_produto=${produto.id_produto}">Alterar</button>&nbsp;
    <button onclick="confirmar()" formaction="${pageContext.request.contextPath}/produto!remover.action?id_produto=${produto.id_produto}">Excluir Produto</button>
</form>
<%--<c:import url="../../../template/footer.jsp"/>--%>
