<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<c:import url="../../../template/header.jsp"/>
<!--<a href="template/header.jsp"></a>-->
<link href="${pageContext.request.contextPath}/css/produto/default.css" rel="stylesheet" type="text/css"/>
<div class="container">
    <h1 class="text-center">Cadastrar Blusão FCI</h1>
    <div class="col-md-6 col-sm-12 col-xs-12 text-middle">
        <form action="${pageContext.request.contextPath}/produto!insert.action" method="POST" enctype="multipart/form-data">
            <div class="form-group">
                <div class="col-md-8 col-sm-12 col-xs-12">
                    <label for="color">Cor:</label>
                    <input type="text" class="form-control" id="color" name="cor">
                </div>
                <div class="col-md-4 col-sm-12 col-xs-12">
                    <label for="tam">Tamanho:</label>
                    <input type="text" class="form-control" id="tam" name="tamanho">
                </div>
            </div>
            <div class="form-group col-md-12 col-sm-12 col-xs-12">
                <label for="price">Preço:</label>
                <input type="text" class="form-control" id="price" name="preco">
            </div>
            <div class="form-group col-md-12 col-sm-12 col-xs-12">
                <label for="desc">Descrição:</label>
                <textarea class="form-control" rows="5" id="desc" name="descricao"></textarea>
            </div>
            <div class="form-group col-md-12 col-sm-12 col-xs-12">
                <label for="img">Imagem:</label>
                <input type="file" id="imge" name="imagem">
            </div>
            <div class="form-group text-center">
                <button type="submit" class="btn btn-danger">Confirmar</button>         
            </div>
        </form>
    </div>
</div>
<%--<c:import url="../../../template/footer.jsp"/>--%>
