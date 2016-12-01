
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="../../../template/header.jsp"/>
<section id="meio">
    <h1 class="text-center">Bem vindo ${sessionScope.usuario.nome} ${sessionScope.usuario.sobrenome} </h1>
    <%--<c:out value="${sessionScope.usuario}"></c:out>--%>
</section>
<%--<c:import url="../../../template/footer.jsp"/>--%>
