<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="../../../template/header.jsp"/>
<h1>Compras</h1>
<c:forEach var="i" items="${compras}"> 
    <%--<c:out value="${i}"></c:out>--%>
    Pedido número: ${i.id_compra}
    Nome do comprador: ${i.usuario.nome}&nbsp;${i.usuario.sobrenome}<br/>
    Data do Pedido : ${i.dt_pedido}<br/>
    Valor Total: R$ ${i.total}<br/>
    Entregue: ${(i.entregue)?Sim:Não}<br/>
    Pagamento realizado : ${(i.pagamento)?Sim:Não}<br/>
    Simular Pagamento e Entrega
</c:forEach>
<c:import url="../../../template/footer.jsp"/>
