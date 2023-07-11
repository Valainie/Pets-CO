
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
    <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@include file="/includes/header.jsp"%>
    <%@include file="/includes/head.jsp"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/loginservlet.css" type="text/css">
</head>
<body>
<h1 class="Slogan">Welcome Back! Pets&CO is here for all your pet's needs</h1>
        <!-- 	fine messaggi di errore nella registrazione -->

        <!-- sistema di colonne -->
        <div class="row">

            <!-- colonna sinistra -->
            <div
                    class="col-lg-2 col-md-2 col-sm-2 col-xs-12 d-none d-lg-block ">
                <%@include file="/includes/panelloSinistra.jsp"%>
            </div>
            <!-- fine colonna sinistra -->

            <!-- colonna centrale -->

            <div class="col-lg-8 col-md-12 ">
                <div class="row">
                    <div id="regcenter" class = "container col-lg-6">
                        <div class="container1">
                            <img class="catpic" alt="kitty" src="${pageContext.request.contextPath}/Immagini/kitten.jpg">

                            <form action="${pageContext.request.contextPath}/LoginServlet" name="loginpage" method="post" >
                                <div class="form-group" >
                                    <input id="emailInput" placeholder="Username" oninput="validateLogin(document.loginpage.pw, document.loginpage.un, document.loginpage.btn)"
                                           class="form-control form-control-sm" type="text" name="un"
                                           required autocomplete="off" value="${cookie.saveEmail.value}">
                                </div>

                                <div class="form-group">
                                    <input id="passwordInput" placeholder="Password" oninput="validateLogin(document.loginpage.pw, document.loginpage.un, document.loginpage.btn)" required
                                           class="form-control form-control-sm" type="password" name="pw" autocomplete="off" value="${cookie.savePass.value}">
                                </div>

                                <div class="form-check text-right">
                                    <input type="checkbox" class="form-check-input active unchecked" id="exampleCheck1" name="remember">
                                    <label class="form-check-label" for="exampleCheck1">Ricordami</label>
                                </div>

                                <div class="form-group">
                                    <button type="submit" class="btn btn-success btn-lg btn-block" name="btn" id="button" >Login</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- fine colonna centrale -->
            <!-- colonna destra -->
            <div
                    class="col-lg-2 col-md-2 col-sm-2 col-xs-12 d-none d-lg-block ">
                <%@include file="../includes/panelloDestra.jsp"%>
            </div>

            <!-- fine sistema di colonne -->
        </div>
</body>
</html>
