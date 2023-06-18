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
    <div class="container">
        <h1>Prenditi cura dei tuoi amici, abbiamo tutto noi!</h1>

        <div class="container">
            <div class="productsBeLike">
                <div class="products">
                    <div class="image">
                        <img src="${pageContext.request.contextPath}/Immagini/immagini/P2.jpg" alt="">
                    </div>
                    <div class="content">
                        <div class="title">Cuccia per cani</div>
                        <div class="prezzo">Prezzo:<span>120&euro; </span></div>
                        <div class="descrizioneBreve">Da prendere dal DB.</div>
                        <button class="AddToCart">add to cart need href</button>
                        <button class="dettagli">dettagli need href</button>
                    </div>
                </div>
                <%--FINE PRIMO PRODOTTO--%>
                <div class="products">
                    <div class="image">
                        <img src="${pageContext.request.contextPath}/Immagini/immagini/P3.jpg" alt="">
                    </div>
                    <div class="content">
                        <div class="title">Collare Scalibor</div>
                        <div class="prezzo">Prezzo:<span>30&euro;</span></div>
                        <div class="descrizioneBreve">Da prendere dal DB.</div>
                        <button class="AddToCart">add to cart need href</button>
                        <button class="dettagli">dettagli need href</button>
                    </div>
                </div>

                <%-- CONTINUA A COPIARE DA PRODUCTS A ALLA FINE--%>
            </div>
        </div>

        <%--  <div class="hero-1 hero-image">
              <img src="${pageContext.request.contextPath}/Immagini/dog_cat.jpg" alt="Cane E gatto" width="50" height="30">
          </div> --%>
    </div>
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

</div>
<%@include file="includes/footer.jsp"%>
</body>
</html>