<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<c:import url="../../../template/header.jsp"/>--%>

<h1 class="text-center">Produtos comprados: </h1></br>
<c:forEach items="${compra.itens}" var="i">
    <%--<c:out value="${i}"></c:out>--%>
    <p>Produto: ${i.produto.descricao}</p>
    <p>Quantidade: ${i.qtd}</p>
</c:forEach>
<p style="font-weight: bold">Preço total: ${compra.total}</p></div><br/>
<%--<c:import url="../../../template/footer.jsp"/>--%>
