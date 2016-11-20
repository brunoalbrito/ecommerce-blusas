<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="template/header.jsp"/>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="${pageContext.request.contextPath}/img/vinho.jpg" class="img-responsive center-block" alt="Image">
            <div class="carousel-caption">
                <h3>BLUSÃO FCI - VINHO</h3>
            </div>
        </div>

        <div class="item">
            <img src="${pageContext.request.contextPath}/img/preto.jpg" class="img-responsive center-block" alt="Image">
            <div class="carousel-caption">
                <h3>BLUSÃO FCI - PRETO</h3>
            </div>
        </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<br>
<div class="container">
    <div class="row">
        <c:forEach var="i" items="${produtos}">
            <div class="col-sm-6">
                <div class="panel panel-danger">
                    <div class="panel-heading"><c:out value="${i.descricao}"></c:out></div>
                    <div class="panel-body"><img src="${pageContext.request.contextPath}/imagens/${i.id_produto}" class="img-responsive" style="width:100%" alt="Image"></div>
                    <div class="panel-footer">Valor: RS <c:out value="${i.preco}"></c:out></div>
                    </div>
                </div>
        </c:forEach>
    </div>
</div>
<br>

<c:import url="template/footer.jsp"/>
