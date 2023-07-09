<%@ page import="bean.PBean" %>
<%@ page import="DAO.product.PModelDS" %>
<%@ page import="java.sql.SQLException" %><%--
 Qui c'è il codice per recuperare eventualmente le categorie
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Pets&Co</title>
    <%@include file="/includes/head.jsp" %>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/categoria.css" type="text/css">
    <script src="${pageContext.request.contextPath}/JS/Prodotto.js"></script>

</head>
<body>

<div class= "header">
    <%@include file="includes/header.jsp"%>
</div>

<div class="allpagecontainer container-fluid">

    <!-- sistema di colonne -->

    <div class="row columnsystem">



        <!-- colonna sinistra -->

        <div

                class="sidepanel col-lg-2 col-xs-12 d-none d-lg-block">

            <%@include file="/includes/panelloSinistra.jsp"%>

        </div>

        <!-- fine colonna sinistra -->

        <!-- colonna centrale -->

        <div class="col" >

            <div class="row">
                <div class="col">
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
                        <tr>
                            <td>
                                <div class="products">

                                    <img src="${pageContext.request.contextPath}/Immagini/immagini/P3.jpg" alt="">

                                    Valainië, [7/9/2023 6:44 PM]
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
            </div>

            <div class="footer" style="margin-top:100% ">
    <%@include file="/includes/footer.jsp"%>
            </div>

        </div>

        <!-- fine colonna centrale -->



        <!-- colonna destra -->

        <div

                class="sidepanel col-lg-2 col-xs-12 d-none d-lg-block ">

            <%@include file="/includes/panelloDestra.jsp"%>

        </div>

        <!-- fine sistema di colonne -->

    </div>

</div>

</body>
</html>
