<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<style>
    #meio{
        height: 76.5%;
    }
</style>
<c:import url="../../template/header.jsp"/>

<section id="meio">
    <h1 class="text-center">Deu ruim!</h1></br>
    <div class="container">
        <div class="col-md-12 col-sm-12 col-xs-12 text-center">
            <p>${erro}</p>
        </div>
    </div>
</section>


<c:import url="../../template/footer.jsp"/>
