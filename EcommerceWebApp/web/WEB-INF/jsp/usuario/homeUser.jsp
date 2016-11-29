<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:import url="../../../template/header.jsp"/>

<h1 style="text-align: center">Produtos</h1>

<c:if test="${produtos.isEmpty()}">
    Não há produtos disponíveis.
</c:if>
<form action="${pageContext.request.contextPath}/usuario!comprar.action" method="post">
    <c:forEach var="i" items="${produtos}"> 
        <img src="${pageContext.request.contextPath}/imagens/${i.id_produto}">
        <p>Cor: <c:out value="${i.cor}"></c:out></br>
            Tamanho:<c:out value="${i.tamanho}"></c:out><br>&nbsp;Preço:<c:out value="${i.preco}"></c:out></br>
            Descrição:<c:out value="${i.descricao}"></c:out><br>
            Quantidade: <input type="number" name="${i.id_produto}" value="0" min="0">
        </p>
    </c:forEach>
    <input type="submit" value="Comprar">
</form>
<%--<c:import url="../../../template/footer.jsp"/>--%>