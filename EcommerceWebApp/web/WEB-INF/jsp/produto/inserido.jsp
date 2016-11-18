<%-- 
    Document   : insertido
    Created on : 07/11/2016, 13:40:03
    Author     : 41583469
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <!--Necessario colocar o pageContext pra funcionar -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estoque/default.css " />
        <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    </head>
    <body>
        <h2 class="text-center">Registrar no Estoque</h2>

        <div class="container">
            <div class="col-md-5 col-sm-5 col-xs-5 text-middle">
                <form action="${pageContext.request.contextPath}/estoque!insert.action" method="POST" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="color">Cor:</label>
                        <input type="text" class="form-control" id="color" name="cor" value="${produto.cor}" disabled>
                    </div>
                    <div class="form-group">
                        <label for="tam">Tamanho:</label>
                        <input type="text" class="form-control" id="tam" name="tamanho" value="${produto.tamanho}" disabled>
                    </div>
                    <div class="form-group">
                        <label for="price">Preço:</label>
                        <input type="text" class="form-control" id="price" name="preco" value="${produto.preco}" disabled>
                    </div>
                    <div class="form-group">
                        <label for="desc">Descrição:</label>
                        <textarea class="form-control" rows="5" id="desc" name="descricao"  disabled>${produto.descricao}</textarea>
                    </div>
                    <div class="form-group">
                        <label for="desc">Quantidade:</label>
                        <input type="text" class="form-control" id="price" name="quantidade">
                    </div>
                    <div class="form-group text-center">
                        <button type="submit" class="btn btn-danger">Confirmar</button>         
                    </div>
                </form>   
            </div>
        </div>
    </body>
</html>
