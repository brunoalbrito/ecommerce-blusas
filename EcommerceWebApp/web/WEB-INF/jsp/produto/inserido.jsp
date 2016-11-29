
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<%--<c:import url="../../../template/header.jsp"/>--%>
<h2 class="text-center">Registrar no Estoque</h2>

<form action="${pageContext.request.contextPath}/estoque!insert.action" method="POST" enctype="multipart/form-data">
    <label>Cor:</label>
    <input type="text" id="color" name="cor" value="${produto.cor}" disabled>
    <label>Tamanho:</label>
    <input type="text" name="tamanho" value="${produto.tamanho}" disabled>
    <label>Preço:</label>
    <input type="text" name="preco" value="${produto.preco}" disabled>
    <label >Descrição:</label>
    <textarea rows="5" id="desc" name="descricao"  disabled>${produto.descricao}</textarea>
    <label>Quantidade:</label>
    <input type="text" id="price" name="quantidade">
    <button type="submit" >Confirmar</button>         
</form>   
<%--<c:import url="../../../template/footer.jsp"/>--%>
