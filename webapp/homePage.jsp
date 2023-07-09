<%--
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

        <div id="homecenter" class="col-lg-8 col-md-12 col-sm-12 col-xs-12" style="margin-top: 30px; border: 5px">

<%--
            <div class="container-fluid clearfix" style="margin-top: 30px">

                <div class="slideshow-container d-none d-md-block">

                    <div class="mySlides fade">
                        <div class="numbertext">1 / 3</div>
                        <a href="singleEvent?selEvento=2"><img class="fadimg" src="images/cavacon.jpg" style="width:100%; height:300px"></a>
                    </div>

                    <div class="mySlides fade">
                        <div class="numbertext">2 / 3</div>
                        <a href="singleEvent?selEvento=1"><img class="fadimg" src="images/fantaexpo.png" style="width:100%; height:300px"></a>
                    </div>

                    <div class="mySlides fade">
                        <div class="numbertext">3 / 3</div>
                        <a href="singleEvent?selEvento=3"><img class="fadimg" src="images/isola.png" style="width:100%; height:300px"></a>
                    </div>

                </div>
                <br>

                <div class="d-none d-md-block"style="text-align:center">
                    <a href="singleEvent?selEvento=2"><span class="dot"></span></a>
                    <a href="singleEvent?selEvento=1"><span class="dot"></span></a>
                    <a href="singleEvent?selEvento=3"><span class="dot"></span></a>
                </div>
                <!-- Lo script l'ho messo qui perchè se lo metto in un file js le immagini si accodano invece di scorrere -->
                <script>
                    var slideIndex = 0;
                    showSlides();
                    function showSlides() {
                        var i;
                        var slides = document.getElementsByClassName("mySlides");
                        var dots = document.getElementsByClassName("dot");

                        for (i = 0; i < slides.length; i++) {
                            slides[i].style.display = "none";
                        }
                        slideIndex++;
                        if (slideIndex > slides.length) {slideIndex = 1}
                        for (i = 0; i < dots.length; i++) {
                            dots[i].className = dots[i].className.replace(" active", "");
                        }

                        slides[slideIndex-1].style.display = "block";
                        dots[slideIndex-1].className += " active";
                        setTimeout(showSlides, 3000);
                    }
                </script>


                <!-- Inizio sezione offerte -->

                <div class="sectionstyle">Offerte

                    <a class="offnovlink" href="/Gameporium/productselection.jsp?attribute=offerta&value=true">Scoprile tutte</a>

                </div>



                <!-- Inizio iterazione cards-->

                <div class="row">
                    <c:set var="home" scope="request" value="true"/>

                    <jsp:include page="/productShow"/>

                    <c:set var="offerte" value='${requestScope["offerteHome"]}'/>

                    <c:forEach items="${offerte}" var="item" begin="0" end="8">
                        <%@include file="/WEB-INF/Includes/productcard.jsp"%>
                    </c:forEach>

                    <!-- fine iterazione cards -->

                </div>

                <!-- fine sezione offerte -->



                <!-- Inizio sezione novità -->

                <div class="sectionstyle">Novità

                    <a class="offnovlink" href="/Gameporium/productselection.jsp?attribute=novita&value=true">Scoprile tutte</a>

                </div>

                <!-- Inizio iterazione cards-->

                <div class="row">

                    <c:set var="novita" value='${requestScope["novitaHome"]}'/>

                    <c:forEach items="${novita}" var="item" begin="0" end="8">
                        <%@include file="/WEB-INF/Includes/productcard.jsp"%>
                    </c:forEach>

                    <!-- fine iterazione cards -->

                </div>

                <!-- fine sezione offerte -->

            </div>

            <!--fine container novità e offerte-->

--%>
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
