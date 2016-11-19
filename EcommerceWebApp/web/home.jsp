<%-- 
    Document   : index
    Created on : 16/11/2016, 18:17:17
    Author     : Leonardo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Blusão FCI</title>
        <style>
            /* Remove the navbar's default rounded borders and increase the bottom margin */
            .navbar {

                border-radius: 0;
            }

            /* Remove the jumbotron's default bottom margin */
            .jumbotron {
                margin-bottom: 0;
                background-color: #d43f3a;
                color: white; 
            }

            /* Add a gray background color and some padding to the footer */
            footer {
                color: white; 
                background-color: #000;
                padding: 25px;
            }
        </style>
    </head>
    <body>

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li><a href="#index.jsp">Home</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="usuario!goToSignUp.action"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                        <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    </ul>
                </div>
            </div>
        </nav>

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
        <footer class="container-fluid text-center">
            <p>© TODOS OS DIREITOS RESERVADOS</p>
        </footer>
    </body>
</html>