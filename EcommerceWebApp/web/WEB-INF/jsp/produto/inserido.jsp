
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:import url="../../../template/header.jsp"/>
        <h2 class="text-center">Registrar no Estoque</h2>

        <div class="container">
            <div class="col-md-12 col-sm-12 col-xs-12">
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
<c:import url="../../../template/footer.jsp"/>
