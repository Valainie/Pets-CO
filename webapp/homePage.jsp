<!DOCTYPE html>
<html>
<head>
    <%@include file="/includes/head.jsp" %>
    <title>PETS&CO</title>
</head>
<body>
<%@include file="/includes/header.jsp" %>


<h1 class="Slogan">Prenditi cura dei tuoi amici, abbiamo tutto noi!</h1>

<div class="contenitore">


<div class="pannelloSx">
    <%@include file="/includes/panelloSinistra.jsp" %>
</div>

<%-- qui ci devono essere il pool delle immagini, lascia sta lo slogan di merda--%>



    <div class="vetrina">

        <div class="offerte_novita" >
            <h2> <span class="highlight"> NOVIT&Agrave;</span>        </h2>
        </div>

        <div>
            <table>
                <tr>
                    <td>
                        <div class="products">

                            <img src="${pageContext.request.contextPath}/Immagini/immagini/P3.jpg" alt="">

                            <div class="content">
                                <div class="title">Collare Scalibor</div>
                                <div class="prezzo">Prezzo:<span>30&euro;</span></div>
                                <div class="descrizioneBreve">Da prendere dal DB.</div>
                                <button class="AddToCart">add to cart need href</button>
                                <button class="dettagli">dettagli need href</button>
                            </div>
                        </div>
                    </td>
                    <td>
                        <div class="products">

                            <img src="${pageContext.request.contextPath}/Immagini/immagini/P3.jpg" alt="">

                            <div class="content">
                                <div class="title">Collare Scalibor</div>
                                <div class="prezzo">Prezzo:<span>30&euro;</span></div>
                                <div class="descrizioneBreve">Da prendere dal DB.</div>
                                <button class="AddToCart">add to cart need href</button>
                                <button class="dettagli">dettagli need href</button>
                            </div>
                        </div>
                    </td>
                    <td>
                   <span class="products">

                        <img src="${pageContext.request.contextPath}/Immagini/immagini/P3.jpg" alt="">

                    <div class="content">
                        <div class="title">Collare Scalibor</div>
                        <div class="prezzo">Prezzo:<span>30&euro;</span></div>
                        <div class="descrizioneBreve">Da prendere dal DB.</div>
                        <button class="AddToCart">add to cart need href</button>
                        <button class="dettagli">dettagli need href</button>
                    </div>
                </span>
                    </td>
                    <td>
                        <div class="products">

                            <img src="${pageContext.request.contextPath}/Immagini/immagini/P3.jpg" alt="">

                            <div class="content">
                                <div class="title">Collare Scalibor</div>
                                <div class="prezzo">Prezzo:<span>30&euro;</span></div>
                                <div class="descrizioneBreve">Da prendere dal DB.</div>
                                <button class="AddToCart">add to cart need href</button>
                                <button class="dettagli">dettagli need href</button>
                            </div>
                        </div>
                    </td>
                </tr>
            </table>
        </div>

        <div class="offerte_novita" >
            <h2> <span class="highlight"> OFFERTE</span>       </h2>
        </div>

        <div>
            <table>
                <tr>
                    <td>
                        <div class="products">

                            <img src="${pageContext.request.contextPath}/Immagini/immagini/P3.jpg" alt="">

                            <div class="content">
                                <div class="title">Collare Scalibor</div>
                                <div class="prezzo">Prezzo:<span>30&euro;</span></div>
                                <div class="descrizioneBreve">Da prendere dal DB.</div>
                                <button class="AddToCart">add to cart need href</button>
                                <button class="dettagli">dettagli need href</button>
                            </div>
                        </div>
                    </td>
                    <td>
                   <span class="products">

                        <img src="${pageContext.request.contextPath}/Immagini/immagini/P3.jpg" alt="">

                    <div class="content">
                        <div class="title">Collare Scalibor</div>
                        <div class="prezzo">Prezzo:<span>30&euro;</span></div>
                        <div class="descrizioneBreve">Da prendere dal DB.</div>
                        <button class="AddToCart">add to cart need href</button>
                        <button class="dettagli">dettagli need href</button>
                    </div>
                </span>
                    </td>
                    <td>
                        <div class="products">

                            <img src="${pageContext.request.contextPath}/Immagini/immagini/P3.jpg" alt="">

                            <div class="content">
                                <div class="title">Collare Scalibor</div>
                                <div class="prezzo">Prezzo:<span>30&euro;</span></div>
                                <div class="descrizioneBreve">Da prendere dal DB.</div>
                                <button class="AddToCart">add to cart need href</button>
                                <button class="dettagli">dettagli need href</button>
                            </div>
                        </div>
                    </td>
                    <td>
                        <div class="products">

                            <img src="${pageContext.request.contextPath}/Immagini/immagini/P3.jpg" alt="">

                            <div class="content">
                                <div class="title">Collare Scalibor</div>
                                <div class="prezzo">Prezzo:<span>30&euro;</span></div>
                                <div class="descrizioneBreve">Da prendere dal DB.</div>
                                <button class="AddToCart">add to cart need href</button>
                                <button class="dettagli">dettagli need href</button>
                            </div>
                        </div>
                    </td>
                </tr>
            </table>
        </div>



        <%-- CONTINUA A COPIARE DA PRODUCTS A ALLA FINE--%>

    </div>

</div>
<div class="pannelloDx">
    <%@include file="/includes/panelloDestra.jsp" %>
</div>
</div>





</div>
<div class="bx-sign-up">
    <div class="sign-text">
        <h3> rimani sul pezzo con le ultime offerte!</h3>
        <p>registrati qui con la tua email</p>

        <div class="sign-item signs-button">
            <a class="sign-item signs-button" href="userJSP/register.jsp">
                <!-- questo devo portare alla NEWSLETTER non al registrati DA modificare asap -->
                <button class="button-Iscriviti"><span>Iscriviti </span><%--da fare responsive--%>
                </button>
            </a>
        </div>
    </div>
</div>

</div>
<%@include file="includes/footer.jsp" %>
</body>
</html>