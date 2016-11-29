<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="${pageContext.request.contextPath}/jquery/jquery-3.1.1.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <title>Blusão FCI</title>     
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
                        <li>
                            <a href="<c:choose>
                                   <c:when test="${usuario != null}">
                                       ${pageContext.request.contextPath}/usuario!goToHome.action
                                   </c:when>
                                   <c:otherwise>
                                       ${pageContext.request.contextPath}/index.jsp
                                   </c:otherwise>
                               </c:choose>">Home</a></li>

                        <c:if test="${usuario != null && usuario.tipo.intTipo == 0}">
                            <li><a href="${pageContext.request.contextPath}/produto/cadastrarproduto.jsp">Cadastrar Produto</a></li>
                            <li><a href="${pageContext.request.contextPath}/produto!listarTodos.action">Produto</a></li>
                            <li><a href="${pageContext.request.contextPath}/usuario!goToCompras.action">Compras</a></li>
                            </c:if>

                        <c:if test="${usuario != null && usuario.tipo.intTipo == 1}">
                            <li>
                                <a href="${pageContext.request.contextPath}/usuario!goToCompras.action">
                                    Compras
                                </a>
                            </li>
                        </c:if>

                    </ul>
                    <ul class="nav navbar-nav navbar-right">

                        <c:if test="${usuario == null}">
                            <li><a href="usuario!goToSignUp.action"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                            <li>
                                <a href="login.jsp">
                                    <span class="glyphicon glyphicon-log-in"></span>
                                    Login
                                </a>
                            </li> 
                        </c:if>
                        <c:if test="${usuario != null}">
                            <li>
                                <a href="${pageContext.request.contextPath}/usuario!doLogout.action">
                                    <span class="glyphicon glyphicon-log-out"></span>
                                    Logout
                                </a>
                            </li> 
                        </c:if>
                    </ul>
                </div>
            </div>
        </nav>