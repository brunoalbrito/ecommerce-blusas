<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:import url="../../../template/header.jsp"/>

<h1 style="text-align: center">Compras Realizadas</h1>
        <div class="container">
            <div class="row">
                <c:forEach var="i" items="${compras}"> 
                    <div class="col-md-6 col-sm-12 col-xs-12">
                        <div class="panel panel-danger">
                            <%--<c:out value="${i}"></c:out>--%>
                            <div class="panel-heading">Pedido número: ${i.id_compra}</div><br/>
                            <div class="panel-body">
                                Nome do comprador: ${i.usuario.nome}&nbsp;${i.usuario.sobrenome}<br/>
                                Data do Pedido : ${i.dt_pedido}<br/>
                                Valor Total: R$ ${i.total}<br/>
                                Entregue: ${(i.entregue)?"Sim":"Não"}<br/>
                                Pagamento realizado : ${(i.pagamento)?"Sim":"Não"}<br/>
                            </div>
                            <div class="panel-footer"><a href="#">Simular Pagamento e Entrega</a></div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

<c:import url="../../../template/footer.jsp"/>
