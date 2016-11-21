<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="../../../template/header.jsp"/>
        <div class="container">
            <h1 style="text-align: center">Listar Produtos</h1>
            <div class="row text-center slideanim">
                <c:forEach var="i" items="${produtos}"> 
                    <div class="col-md-6">
                        <div class="thumbnail">
                            <img src="${pageContext.request.contextPath}/imagens/${i.id_produto}" style="width:100%">
                            <div class="caption">
                                <p>Cor: <c:out value="${i.cor}"></c:out></br>
                                    Tamanho:<c:out value="${i.tamanho}"></c:out><br>&nbsp;Preço:<c:out value="${i.preco}"></c:out></br>
                                    Descrição:<c:out value="${i.descricao}"></c:out><br>
                                    <a class="btn btn-danger btn-group-lg" href="${pageContext.request.contextPath}/produto!editar.action?id=${i.id_produto}">Editar</a>
                                </p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
<c:import url="../../../template/footer.jsp"/>