<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="template/header.jsp"/>


<c:forEach var="i" items="${produtos}">
    <form method="POST" action="${pageContext.request.contextPath}/produto!detalhes.action?id_produto=${i.id_produto}">
        <c:out value="${i.descricao}"></c:out>
        
            <input type=image src="${pageContext.request.contextPath}/imagens/${i.id_produto}" width="50%" height="50%"> </br>
        <!--<img src="${pageContext.request.contextPath}/imagens/${i.id_produto}" class="img-responsive" style="width:50%;height: 50%;" alt="Image"></br>-->
        Valor: RS <c:out value="${i.preco}"></c:out>
        <hr>
        </form>
</c:forEach>


<c:import url="template/footer.jsp"/>
