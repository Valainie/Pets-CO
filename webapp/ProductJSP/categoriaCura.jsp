<%--
 Qui c'è il codice per recuperare i file della CURA
--%>
<!DOCTYPE html>
<html>
<head>
  <title>Cibo</title>
  <%@include file="/includes/head.jsp" %>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/categoria.css" type="text/css">
</head>
<body>

<%@include file="/includes/header.jsp" %>
<h1 class="Slogan">Cura</h1> <!-- Sto coso mi serve per tenere separati le barre e l'header che sennò sono appiccicati -->
<div class="row" style="margin-left: 1%">

  <div class="col" > <!-- Questa è la colonna centrale - Questa è quella per mettere effettivamente la roba-->


    <div class="row">
      <div id="PanelloSx" class="col-lg-2 col-md-2 col-sm-2 col-xs-12 d-none d-lg-block "> <!-- PANNELLO SINISTRA! -->
        <%@include file="/includes/panelloSinistra.jsp" %>
      </div>
      <div class="col" style="max-width: 65%">
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


      <div id="pannelloDx" class= "col-lg-2 col-md-2 col-sm-2 col-xs-12 d-none d-lg-block"> <!-- PANNELLO DESTRA! -->
        <%@include file="/includes/panelloDestra.jsp" %>
      </div>
    </div>
    <div class="row" >
      <%@include file="/includes/footer.jsp"%>
    </div>

</body>
</html>
