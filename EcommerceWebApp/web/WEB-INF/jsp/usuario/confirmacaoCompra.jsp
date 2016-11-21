<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<style>
    #meio{
        height: 76.5%;
    }
    .text-middle{
        margin-left: auto;margin-right: auto;float: none;
    }
</style>
<c:import url="../../../template/header.jsp"/>

<section id="meio">
    <h1 class="text-center">Produtos comprados: </h1></br>
    <div class="container">
            <c:forEach items="${compra.itens}" var="i">
                <div class="panel panel-danger">
                    <%--<c:out value="${i}"></c:out>--%>
                    <div class="panel-body">
                        <p>Produto: ${i.produto.descricao}</p>
                        <p>Quantidade: ${i.qtd}</p>
                    </div>
                </div>
            </c:forEach>
            <div style="background: #d43f3a"><p style="font-weight: bold">Preço total: ${compra.total}</p></div><br/>
        </div>
    </div>
</section>




<c:import url="../../../template/footer.jsp"/>
