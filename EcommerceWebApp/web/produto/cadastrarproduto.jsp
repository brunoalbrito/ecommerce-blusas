<%--    Document   : cadastrarproduto
    Created on : 07/11/2016, 09:05:37
    Author     : 41583469
--%>


<%@page language="java" contentType="text/html;charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="../js/jquery.js" type="text/javascript"></script>
        <script src="../js/bootstrap.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cadastrar Produto</title>
        <style>
            input[type="text"]{
                border-radius: 4px;
            }
            h2{text-align: center}
        </style>
    </head>
    <body>
        <h2>Cadastrar BLUSÃO FCI</h2>
        <form action="${pageContext.request.contextPath}/produto!insert.action" method="POST" enctype="multipart/form-data">
            <div class="container">
                <div class="form-group">
                    <label for="color">Cor:</label>
                    <input type="text" class="form-control" id="color">
                </div>
                <div class="form-group">
                    <label for="tam">Tamanho:</label>
                    <input type="text" class="form-control" id="tam">
                </div>
                <div class="form-group">
                    <label for="price">Preço:</label>
                    <input type="text" class="form-control" id="price">
                </div>
                <div class="form-group">
                    <label for="desc">Descrição:</label>
                    <textarea class="form-control" rows="5" id="desc"></textarea>
                </div>
                <div class="form-group">
                    <label for="img">Imagem:</label>
                    <input type="file" id="imge">
                </div>
                <button type="submit" class="btn btn-danger">Confirmar</button>         
        </form>
    </body>
</html>
