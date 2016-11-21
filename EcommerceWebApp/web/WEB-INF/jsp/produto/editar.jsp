
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:import url="../../../template/header.jsp"/>
        <h1 class="text-center">Editar Produto</h1>
        <div class="container">
            <div class="col-md-12 col-sm-12 col-xs-12">
        <form method="POST" action="${pageContext.request.contextPath}">
            <c:out value="${produto}"></c:out>
            <div class="form-group">
                <p>Cor: </p>
                <p><input type="text" class="form-control" name="cor" value="${produto.cor}"></p>
            </div>
            <div class="form-group">
            <p>Tamanho:</p>
            <p><input type="text" class="form-control" name="tamanho" value="${produto.tamanho}"></p>
            </div>
            <div class="form-group">
            <p>Preco: </p>
            <p><input type="text" class="form-control" name="preco" value="${produto.preco}"></p>
            </div>
            <div class="form-group">
            <p>Descrição</p>
            <p><textarea name="descricao" class="form-control" rows="10" cols="50" maxlength="800">${produto.descricao}</textarea> </p>
            </div>
            <div class="form-group text-center">
            <button type="submit" class="btn btn-danger" formaction="${pageContext.request.contextPath}/produto!alterar.action?id_produto=${produto.id_produto}">Alterar</button>&nbsp;
            <button onclick="confirmar()" class="btn btn-danger"formaction="${pageContext.request.contextPath}/produto!remover.action?id_produto=${produto.id_produto}">Excluir Produto</button>
            </div>
            </form>
        </div>
        </div>
        <!--        <script type="text/javascript">
                    function confirmar()
                    {
                        var resp = confirm("Deseja realmente excluir");
                        if(resp){
                            window.location.
                        }
                    }
                </script>-->
<c:import url="../../../template/footer.jsp"/>
