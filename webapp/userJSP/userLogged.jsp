<!DOCTYPE html>
<html>
<head>
    <title>Pagina Cliente Pets&Co</title>
    <%@include file="/includes/head.jsp"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/userLogged.css" type="text/css">
</head>
<body>
<%@include file="/includes/header.jsp" %>

<h1 class="Slogan">Username's Page</h1>

<div class="row" style="margin-left: 1%">
    <div id="PanelloSx" class="col-lg-2 col-md-2 col-sm-2 col-xs-12 d-none d-lg-block ">
        <%@include file="/includes/panelloSinistra.jsp" %>
    </div>
    <div class="col" style="max-width: 65%">
        <div class="anagrafica">
            <p><b>Username</b>: Username</p>
            <p><b>Nome</b>: Nome Cognome</p>
            <p><b>Codice Fiscale</b>: CFahdiem0m013905</p>
            <p><b>Telefono</b>: +39 123-4567890</p>
            <p><b>Email</b>: indirizzo.mail@email.ml</p>
            <p><a href="${pageContext.request.contextPath}/userJSP/preferiti.jsp">Visualizza Preferiti</a> o
                <a href="${pageContext.request.contextPath}/userJSP/myOrders.jsp">Visualizza Ordini Passati</a></p>
        </div>
    </div>
    <div class="col">
        <div class="indirizzi">
            <div class = "indirizzo">
                <p><b>Città</b>: Città (CAP: )</p>
                <p><b>Indirizzo</b>: Via Strada N. Civico</p>
            </div>
            <div class = "indirizzo">
                <p><b>Città</b>: Città (CAP: )</p>
                <p><b>Indirizzo</b>: Via Strada N. Civico</p>
            </div>
        </div>
    </div>
    <div class="col">
        <div class="metodi">
            <div class="metodo">
                <p><b>Carta</b>: Circuito *********NNN </p>
                <p><b>Scadenza</b>: Data-di-scadenza</p>
            </div>
            <div class="metodo">
                <p><b>Carta</b>: Circuito *********NNN </p>
                <p><b>Scadenza</b>: Data-di-scadenza</p>
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