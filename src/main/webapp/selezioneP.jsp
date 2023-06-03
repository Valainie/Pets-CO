<%--
  Created by IntelliJ IDEA.
  User: Diana
  Date: 24/05/2023
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
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

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>

    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


    <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

    <link rel="stylesheet" href="css/style.css" type="text/css">
    <%@include file="/includes/header.jsp"%>

</head>



<body>

<div class="container-fluid ">

    <!-- sistema di colonne -->

    <div class="row">



        <!-- colonna sinistra -->

        <div

                class="col-lg-2 col-md-2 col-sm-2 col-xs-12 d-none d-lg-block ">

            <%@include file="/includes/panelloSinistra.jsp"%>

        </div>

        <!-- fine colonna sinistra -->



        <!-- colonna centrale -->

        <div id="pscenter" class="col-lg-8 col-md-12 col-sm-12 col-xs-12 ">

            <div class="container-fluid clearfix">


                <!-- Inizio sezione risultati -->

                <div class="sectionstyle"> Risultati Ricerca </div>



                <!-- Inizio iterazione cards-->

                <!--<div class="row">

                    <jsp:include page="/ShowPServlet"/>

                    <c:set var="results" value='${sessionScope["listaRisultati"]}'/>

                    <c:forEach items="${results}" var="item">
                        <%@include file="prodotto.jsp"%>
                    </c:forEach>

                </div> -->

                <!-- fine iterazione cards -->

                <!-- fine sezione risultati -->



            </div>

            <!--fine container novità e offerte-->



        </div>

        <!-- fine colonna centrale -->



        <!-- colonna destra -->

        <div

                class="col-lg-2 col-md-2 col-sm-2 col-xs-12 d-none d-lg-block ">

            <%@include file="includes/panelloDestra.jsp"%>

        </div>

        <!-- fine colonna destra -->



        <!-- fine sistema di colonne -->

    </div>

</div>

<%@include file="includes/footer.jsp"%>

</body>

</html>
