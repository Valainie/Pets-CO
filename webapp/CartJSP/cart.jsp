<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Carrello</title>
    <%@include file="/includes/head.jsp"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cart.css" type="text/css">
</head>
<body>
<%@include file="/includes/header.jsp" %>

<h1 class="Slogan">Rivedi i tuoi acquisti</h1>

<div class="row" style="margin-left: 1%">
    <div id="PanelloSx" class="col-lg-2 col-md-2 col-sm-2 col-xs-12 d-none d-lg-block ">
        <%@include file="/includes/panelloSinistra.jsp" %>
    </div>
    <div class="col" style="max-width: 65%">
        <div class="row">
            <div class="col">
                <div class="carrello">
                    <div class="prodottocart">
                        <div class="row">
                            <div class="col" style="max-width: 25%">
                                <img src="${pageContext.request.contextPath}/Immagini/immagini/P3.jpg" alt="prod.">
                            </div>
                            <div class="col">
                                <h4>Nome Prodotto</h4><span style="align-self: end">Prezzo: SOLDI €</span><br>
                                <p>Quantità: <input type="number" value="1" min="1" style="max-width: 10%"required></p>
                            </div>
                            <div class="col" style="max-width: 15%">
                                <button type="button" class="removeCart">Rimuovi</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col" style="max-width: 30%;">
                <div class="resocontocart">
                    <h4>Totale nel Carrello</h4>
                    <b>SOLDI €</b> <br>
                    <button class="confirm">Procedi all'acquisto</button>
                </div>
            </div>
        </div>
    </div>
    <div id="pannelloDx" class= "col-lg-2 col-md-2 col-sm-2 col-xs-12 d-none d-lg-block">
        <%@include file="/includes/panelloDestra.jsp" %>
    </div>
</div>
<%@include file="/includes/footer.jsp" %>

</body>
</html>