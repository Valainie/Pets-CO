<!DOCTYPE html>
<html lang="en">

<head>
    <title>Pets&CO</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>
    <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <script type="text/javascript" src="JS/formVal.js"></script>
    <link rel="stylesheet" href="css/style.css" type="text/css">

    <%@include file="/includes/header.jsp"%>
</head>

<body>
<div class="allpagecontainer container-fluid ">
    <!-- sistema di colonne -->
    <div class="row">
        <!-- colonna sinistra -->
        <div class="col-lg-2 col-md-2 col-sm-2 col-xs-12 d-none d-lg-block ">
            <%@include file="/includes/panelloSinistra.jsp"%>
        </div>
        <!-- fine colonna sinistra -->
        <!-- colonna centrale -->
        <div id="mlcenter" class="col-lg-8 col-md-12 ">

            <div class="container">
                <div class="row">

                    <div class="col-12 mx-auto">
                        <h2>Accedi</h2>

                        <p class="hint-text">Inizia a fare acquisti su Pets&CO!</p>
                        <form action="login" name="loginmobile" class="form-signin">


                            <div class="loginform form-label-group">
                                <input type="text" id="inputEmail" name="un" oninput="validateMLogin(document.loginmobile.pw, document.loginmobile.un)"
                                       class="form-control" placeholder="Username"  value="${cookie.saveUser.value}">
                            </div>


                            <div class="loginform form-label-group">
                                <input type="password" id="inputPassword" name="pw" oninput="validateMLogin(document.loginmobile.pw, document.loginmobile.un)"
                                       class="form-control" placeholder="Password" value="${cookie.savePass.value}">
                            </div>

                            <div class="loginform form-check text-right">
                                <input type="checkbox" class="form-check-input active unchecked" id="exampleCheck1" name="remember">
                                <label class="form-check-label" for="exampleCheck1">Ricordami</label>
                            </div>

                            <button
                                    class="loginbtnm btn btn-lg btn-primary btn-block text-uppercase" id="prova"
                                    type="submit" disabled>Accedi</button>
                            <hr class="my-4">
                            <button
                                    class="btn btn-primary btn-block btn-sm text-uppercase"
                                    type="button" onclick="window.location='/Gameporium/register.jsp';">
                                Registra un nuovo account
                            </button>
                        </form>
                    </div>

                </div>
            </div>

        </div>
        <!-- fine colonna centrale -->

        <!-- colonna destra -->
        <div id="mlrightcol" class="clearfix col-lg-2 col-md-2 col-sm-2 col-xs-12 d-none d-lg-block">
        </div>
        <!-- fine sistema di colonne -->
    </div>
</div>
</body>
</html>