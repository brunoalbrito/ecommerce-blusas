
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--<c:import url="../../../template/header.jsp"/>--%>
<c:import url="template/header.jsp"/>
<link href="${pageContext.request.contextPath}/css/produto/default.css" rel="stylesheet" type="text/css"/>
<body>
    <div class="container">
        <h1 class="text-center">Editar Produto</h1>
        <div class="col-md-6 col-sm-12 col-xs-12 text-middle">
            <form method="POST" action="${pageContext.request.contextPath}">
                <div class="form-group">
                    Cor:
                    <input type="text" class="form-control" name="cor" value="${produto.cor}">
                </div>
                <div class="form-group">
                    Tamanho:
                    <input type="text" class="form-control" name="tamanho" value="${produto.tamanho}">
                </div>       
                <div class="form-group">
                    Preco:
                    <input type="text" class="form-control" name="preco" value="${produto.preco}">
                </div>
                <div class="form-group">
                    Descrição
                    <textarea name="descricao" class="form-control" rows="10" cols="50" maxlength="800">${produto.descricao}</textarea>
                </div>
                <div class="form-group text-center">
                    <button type="submit" class="btn btn-danger btn-lg" formaction="${pageContext.request.contextPath}/produto!alterar.action?id_produto=${produto.id_produto}">Alterar</button>
                </div>                
                <div class="form-group text-center">
                    <button onclick="confirmar()" class="btn btn-default" formaction="${pageContext.request.contextPath}/produto!remover.action?id_produto=${produto.id_produto}">Excluir Produto</button>
                </div>                
            </form>
        </div>
    </div>
</body>
<%--<c:import url="../../../template/footer.jsp"/>--%>
