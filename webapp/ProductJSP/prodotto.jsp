<!DOCTYPE html>
<html>
<head>
 <script src="https://code.iconify.design/iconify-icon/1.0.7/iconify-icon.min.js"></script>
 <%@include file="/includes/head.jsp" %>
   <title>Spendi su Pets&co!</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/prodotto.css" type="text/css">


</head>
<body>
<%@include file="/includes/header.jsp" %>
<h1 class="Slogan">Dettagli del prodotto!</h1> <!-- Sto coso mi serve per tenere separati le barre e l'header che sennò sono appiccicati -->
<div class="row" style="margin-left: 1%">
 <div id="PanelloSx" class="col-lg-2 col-md-2 col-sm-2 col-xs-12 d-none d-lg-block "> <!-- PANNELLO SINISTRA! -->
  <%@include file="/includes/panelloSinistra.jsp" %>
 </div>


 <div class="col"> <!-- Questa è la colonna centrale - Questa è quella per mettere effettivamente la roba-->
     <div class="row">
     <div class="col">
         <img src="${pageContext.request.contextPath}/Immagini/immagini/P3.jpg" alt="Immagine prodotto">
     </div>
         <div class="col">
             <div class="title"><h3>Collare Scalibor</h3></div>
             <div class="barravoti">
                 <iconify-icon icon="ion:paw"></iconify-icon>
                 <iconify-icon icon="ion:paw"></iconify-icon>
                 <iconify-icon icon="ion:paw"></iconify-icon>
                 <iconify-icon icon="ion:paw"></iconify-icon>
                 <iconify-icon icon="ion:paw-outline"></iconify-icon>
             </div>
             <div class="descrizioneLunga">Da prendere dal DB. Far un rettangolo intorno.
                 Lorem ipsum dolor sit amet, eum aeque oblique ad, case tritani cu vel, id dicta nullam appareat pri.
                 Odio iracundia per ea. Nonumy prompta qui ne, an dicat appareat facilisi ius.
                 Cu everti adipisci cotidieque sea, ut iuvaret pertinacia argumentum vis.
                 Vel nonumes ancillae mediocritatem et, movet postea sensibus vim eu, an has ullum labore nominavi.</div>
             <div class="prezzo">Prezzo: <span>30&euro;</span></div>
         </div>
     </div>
     <div class="Spacer">SPAZIO (PROMEMORIA)</div>
     <div class="row">
         <div class="col">
             <h4>Recensione</h4>
             <div class="recensione">
                 <div class="commento">
                     <span>NOME UTENTE</span>
                     <span class="barravoti">
                         <iconify-icon icon="ion:paw"></iconify-icon>
                         <iconify-icon icon="ion:paw"></iconify-icon>
                         <iconify-icon icon="ion:paw"></iconify-icon>
                         <iconify-icon icon="ion:paw"></iconify-icon>
                         <iconify-icon icon="ion:paw-outline"></iconify-icon>
                     </span>
                     <div class="commento-testo>">
                         LOREM IPSUM
                     </div>
                 </div>
                 <div class="commento">
                     <span>NOME UTENTE</span>
                     <span class="barravoti">
                         <iconify-icon icon="ion:paw"></iconify-icon>
                         <iconify-icon icon="ion:paw"></iconify-icon>
                         <iconify-icon icon="ion:paw"></iconify-icon>
                         <iconify-icon icon="ion:paw"></iconify-icon>
                         <iconify-icon icon="ion:paw-outline"></iconify-icon>
                     </span>
                     <div class="commento-testo>">
                         LOREM IPSUM
                     </div>
                 </div>
             </div>
         </div>
         <div class="col">
             <button class="AddCart">Aggiungi al <iconify-icon icon="raphael:cart"></iconify-icon></button>
             <div>Dai un occhiata a questo consigliato:</div>
             <div class="consiglio">
                 <a href="http://tiktok.com/@diana_zorro"><img src="${pageContext.request.contextPath}/Immagini/immagini/P3.jpg" alt="Immagine prodotto"></a>
             </div>
         </div>
     </div>
 </div>

 <div id="pannelloDx" class= "col-lg-2 col-md-2 col-sm-2 col-xs-12 d-none d-lg-block"> <!-- PANNELLO DESTRA! -->
  <%@include file="/includes/panelloDestra.jsp" %>
 </div>



<%@include file="/includes/footer.jsp"%>
</body>
</html>