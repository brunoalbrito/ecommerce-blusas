<%--    Document   : cadastrarproduto
    Created on : 07/11/2016, 09:05:37
    Author     : 41583469
--%>


<%@page language="java" contentType="text/html;charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/produto/default.css " />
        <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cadastrar Produto</title>
    </head>
    <body>
        <div class="container">
            <h2 class="text-center">Cadastrar Blusas</h2>
            <div class="col-md-6 col-sm-6 col-xs-12 text-middle">
                <form action="${pageContext.request.contextPath}/produto!insert.action" method="POST" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="color">Cor:</label>
                        <input type="text" class="form-control" id="color" name="cor">
                    </div>
                    <div class="form-group">
                        <label for="tam">Tamanho:</label>
                        <input type="text" class="form-control" id="tam" name="tamanho">
                    </div>
                    <div class="form-group">
                        <label for="price">Preço:</label>
                        <input type="text" class="form-control" id="price" name="preco">
                    </div>
                    <div class="form-group">
                        <label for="desc">Descrição:</label>
                        <textarea class="form-control" rows="5" id="desc" name="descricao"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="img">Imagem:</label>
                        <input type="file" id="imge" name="imagem">
                    </div>
                    <div class="form-group text-center">
                        <button type="submit" class="btn btn-danger">Confirmar</button>         
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
