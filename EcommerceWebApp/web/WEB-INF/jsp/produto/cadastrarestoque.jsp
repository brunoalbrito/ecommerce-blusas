
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<c:import url="template/header.jsp"/>
<link href="${pageContext.request.contextPath}/css/produto/default.css" rel="stylesheet" type="text/css"/>
<body>
    <div class="container">
        <h1 class="text-center">Registrar no Estoque</h1>

        <div class="col-md-6 col-sm-12 col-xs-12 text-middle">
            <form action="${pageContext.request.contextPath}/estoque!insert.action" method="POST" enctype="multipart/form-data">
                <div class="form-group">
                    <div class="col-md-8 col-xs-12 col-sm-12">
                        <label>Cor:</label>
                        <input type="text" class="form-control" name="cor" value="${produto.cor}" disabled>
                    </div>
                    <div class="col-md-4 col-xs-12 col-sm-12">
                        <label>Tamanho:</label>
                        <input type="text" class="form-control" name="tamanho" value="${produto.tamanho}" disabled>
                    </div>
                </div>
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="form-group">
                        <label>Preço:</label>
                        <input type="text" class="form-control" name="preco" value="${produto.preco}" disabled>
                        <label>Descrição:</label>
                        <textarea  class="form-control" rows="5" id="desc" name="descricao"  disabled>${produto.descricao}</textarea>
                        <label>Quantidade:</label>
                        <input type="text" class="form-control" id="price" name="quantidade">  
                    </div>  
                </div>
                <div class="form-group text-center">
                    <button type="submit" class="btn btn-danger">Confirmar</button>         
                </div>
            </form> 
        </div>  
    </div>
</body>
<%--<c:import url="../../../template/footer.jsp"/>--%>
