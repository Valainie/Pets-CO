<!DOCTYPE html>
<html>
<head>
    <%@include file="/includes/head.jsp"%>
    <title>PETS&CO</title>
</head>
<body>
    <%@include file="/includes/header.jsp"%>

   <%-- qui ci devono essere il pool delle immagini, lascia sta lo slogan di merda--%>
    <div class="bx hero">
        <div class="hero-1 hero-cta">
            <h1>Prenditi cura dei tuoi amici, abbiamo tutto noi!</h1>
        </div>
        <div class="hero-1 hero-image">
            <img src="${pageContext.request.contextPath}/Immagini/dog_cat.jpg" alt="Cane E gatto" width="400" height="392">

        </div>
    </div>
<%-- da mettere nella jsp della barra sinistra
            LASCIA QUESTA DIV <div
                class="col-lg-2 col-md-2 col-sm-2 col-xs-12 d-none d-lg-block ">
                <%@include file="includes/panelloSinistra.jsp"%>
            </div>
    <div class="bx content">
        <h2>Categoria</h2>
        <div class="content-info">
            <div>
                <img src="#">
                <p>Cibo</p>
            </div>
            <div>
                <img src="#">
                <p>accessori</p>
            </div>
            <div>
                <img src="#">
                <p>cura</p>
            </div>
        </div>
    </div>
    <div class="bx quote">
        --%>

    </div>
    <div class="bx sign-up">
        <div class="sign-item signs-text">
            <h3>rimani sul pezzo con le ultime offerte!</h3>
            <p>registrati qui con la tua email</p>
        </div>
        <div class="sign-item signs-button">
            <a class="sign-item signs-button" href="userJSP/register.jsp"> <!-- questo devo portare alla NEWSLETTER non al registrati DA modificare asap -->
            <button type="button">Iscriviti <%--da fare responsive--%>
            </button>
            </a>
        </div>
    </div>
    <div class="bx footer">
        <p>Copyright &copy; Pets&amp;CO 2022-2023. Tutti i diritti riservati.</p>
    </div>
</div>
    <%@include file="/includes/footer.jsp"%>
</body>
</html>