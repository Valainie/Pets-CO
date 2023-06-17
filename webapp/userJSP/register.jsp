
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Registrati a Pets&CO!</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@include file="/includes/header.jsp"%>
    <%@include file="/includes/head.jsp"%>


    <link rel="stylesheet" href="../css/register.css" type="text/css">
</head>
<body>
<form action="${pageContext.request.contextPath}/LoginServlet" method="post" >

<h1>How can you not be our member yet?</h1>

    <img alt="govno" src="https://media.tenor.com/gASV-vc37AsAAAAM/pretty-please-please.gif" style="width: 100px; height: 150px; class:right">

    <!-- 	messaggi di errore nella registrazione -->
    <c:set var="notRegistered" value='${requestScope["notRegistered"]}' />
    <c:set var="mailPresent" value='${requestScope["mailPresent"]}' />
    <c:set var="userPresent" value='${requestScope["userPresent"]}' />

    <div class="allpagecontainer container-fluid ">
        <c:if test="${notRegistered}">
            <div>
                <a class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Attenzione,</strong> la registrazione non è andata a buon fine, riprovare!
            </div>
        </c:if>

        <c:if test="${mailPresent}">
                <a class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Attenzione,</strong> l'indirizzo email inserito è già in uso!
        </c:if>

        <c:if test="${userPresent}">
            <div class="alert alert-warning alert-dismissible fade-in" role="alert">
                <a class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Attenzione,</strong> l'username inserito è già in uso!
            </div>
        </c:if>

        <!-- 	fine messaggi di errore nella registrazione -->

        <!-- sistema di colonne -->
        <div class="row">

            <!-- colonna sinistra -->
            <div
                    class="col-lg-2 col-md-2 col-sm-2 col-xs-12 d-none d-lg-block ">
                <%@include file="../includes/panelloSinistra.jsp"%>
            </div>
            <!-- fine colonna sinistra -->

            <!-- colonna centrale -->

            <div class="col-lg-8 col-md-12 ">
                <div class="row">
                    <div id="regcenter" class = "container ">
                        <form id="reg" action="${pageContext.request.contextPath}/RegisterServlet" name="registerform" method="post" id="reg">
                            <h2>Registrati</h2>
                            <p class="hint-text">Crea un account. Ci vorrà solo un minuto!</p>

                            <div class="form-group">
                                <input type="text" class="form-control" name="name" placeholder="Nome" required>
                                <input type="text" class="form-control" name="surname" placeholder="Cognome" required>
                            </div>

                            <div class="form-group">
                                <input type="text" class="form-control" name="user" placeholder="Username" required>
                            </div>

                            <div class="form-group">
                                <input type="email" class="form-control" name="mail" placeholder="Email" required>
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" name="pass" placeholder="Password (tra 7 e 20 caratteri)" required>
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" name="confirmPass" placeholder="Conferma password" required>
                            </div>
                            <div class="form-group center-block">
                                <label class="checkbox-inline">
                                    <input type="checkbox" name="check" required> Accetto i <a href="#">Termini di Uso</a> e le <a href="#">Norme della privacy</a>
                                </label>
                            </div>
                            <div id="regbutton" class="center-block form-group">
                                <button type="button" onclick="validateRegister(document.registerform)" class="btn btn-success btn-lg btn-block" >Registrati adesso!</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- fine colonna centrale -->
            <!-- colonna destra -->
            <!-- fine sistema di colonne -->
        </div>
    </div>
    <%@include file="/includes/footer.jsp"%>
</body>
</html>