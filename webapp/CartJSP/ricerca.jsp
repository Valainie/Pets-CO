<%--

--%>
<!DOCTYPE html><html>
<head>
    <title>Spendi i soldi dai</title>
  <%@include file="/includes/head.jsp" %>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ricerca.css" type="text/css">
</head>
<body>
<div data-asin="" data-index="1" class="a-section a-spacing-none s-result-item s-flex-full-width s-border-bottom-none s-widget s-widget-spacing-large" data-cel-widget="search_result_1"><div data-uuid="7fbf0e7e-5c25-477d-9626-987ed3195664" cel_widget_id="MAIN-TOP_BANNER_MESSAGE-1" class="s-widget-container s-spacing-mini s-widget-container-height-mini celwidget slot=MAIN template=TOP_BANNER_MESSAGE widgetId=messaging-messages-results-header-builder-legal-disclaimer-and-ranking-disclosure-builder" data-csa-c-id="6ktxul-dasm8o-mvspwr-4t6hie" data-cel-widget="MAIN-TOP_BANNER_MESSAGE-1">

  <%@include file="/includes/header.jsp" %>




    <h1 class="Slogan">Risulatti per: -inserisci oggetto ricerca-</h1> <!--deve prendere l' input da barraricerca!!!! -->

    <div class="row" style="margin-left: 1%">
      <div id="PanelloSx" class="col-lg-2 col-md-2 col-sm-2 col-xs-12 d-none d-lg-block "> <!-- PANNELLO SINISTRA -->
        <%@include file="/includes/panelloSinistra.jsp" %>
      </div>


      <div class="col" style="max-width: 65%">
        <table>
          <tr>

            <td>
              <div class="products">

                <img src="${pageContext.request.contextPath}/Immagini/immagini/P3.jpg" alt="">

                <div class="content">
                  <div class="title"></div>
                  <div class="prezzo">Prezzo:<span>&euro;</span></div>
                  <div class="descrizioneBreve">.</div>
                  <button class="AddToCart">add to cart need href</button>
                  <button class="dettagli">dettagli need href</button>
                </div>
              </div>
            </td>

            <td>
              <div class="products">

                <img src="${pageContext.request.contextPath}/Immagini/immagini/P3.jpg" alt="">

                <div class="content">
                  <div class="title"></div>
                  <div class="prezzo">Prezzo:<span>&euro;</span></div>
                  <div class="descrizioneBreve">.</div>
                  <button class="AddToCart">add to cart need href</button>
                  <button class="dettagli">dettagli need href</button>
                </div>
              </div>
            </td>
          <tr>

        </table>







    </div>


  <div id="pannelloDx" class= "col-lg-2 col-md-2 col-sm-2 col-xs-12 d-none d-lg-block"> <!-- PANNELLO DESTRA! -->
    <%@include file="/includes/panelloDestra.jsp" %>
  </div>
</div>
  <div class="row" >
    <%@include file="/includes/footer.jsp"%>
  </div>

</body>
</html>
