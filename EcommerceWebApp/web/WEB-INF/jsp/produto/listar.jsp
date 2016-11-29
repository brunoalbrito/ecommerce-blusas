<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<c:import url="../../../template/header.jsp"/>--%>
<h1>Listar Produtos</h1>
<c:forEach var="i" items="${produtos}"> 
    <img src="${pageContext.request.contextPath}/imagens/${i.id_produto}">
        <p>Cor: <c:out value="${i.cor}"></c:out></br>
            Tamanho:<c:out value="${i.tamanho}"></c:out><br>&nbsp;Preço:<c:out value="${i.preco}"></c:out></br>
            Descrição:<c:out value="${i.descricao}"></c:out><br>
            <a href="${pageContext.request.contextPath}/produto!editar.action?id=${i.id_produto}">Editar</a>
        </p>
</c:forEach>
<%--<c:import url="../../../template/footer.jsp"/>--%>