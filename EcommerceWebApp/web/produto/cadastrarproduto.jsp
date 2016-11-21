<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="../template/header.jsp"/>
        <div class="container">
            <h2 class="text-center">Cadastrar Blusão FCI</h2>
            <div class="col-md-12 col-sm-12 col-xs-12 text-middle">
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
<c:import url="../template/footer.jsp"/>