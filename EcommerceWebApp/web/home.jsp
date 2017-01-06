<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="template/header.jsp"/>

<!--Inicio do container-->
<div class="container">
    <!--inicio da div-12-->
    <div class="col-md-12 col-sm-12 col-xs-12">
        <c:forEach var="i" items="${produtos}">
            <div class="col-md-6 col-sm-6 col-xs-12">
                <form method="POST" action="${pageContext.request.contextPath}/produto!detalhes.action?id_produto=${i.id_produto}">

                    <input type=image src="${pageContext.request.contextPath}/imagens/${i.id_produto}" width="50%" height="50%"> </br>
                <!--<img src="${pageContext.request.contextPath}/imagens/${i.id_produto}" class="img-responsive" style="width:50%;height: 50%;" alt="Image"></br>-->
                    <div class="col-md-12">
                        Descrição: <c:out value="${i.descricao}"></c:out>
                        </div>
                        <div class="col-md-12">
                            Valor: RS <c:out value="${i.preco}"></c:out>
                        </div>
                    </form>
                </div>
        </c:forEach>
    </div>
</div>

<c:import url="template/footer.jsp"/>
