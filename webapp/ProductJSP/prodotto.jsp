
<!DOCTYPE html>
<html>
<head>
 <%@include file="/includes/head.jsp" %>
   <title>Spendi su Pets&co!</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/prodotto.css" type="text/css">


</head>
<body>
<%@include file="/includes/header.jsp" %>

<div class="row" style="margin-left: 1%">

 <div  class="col-lg-2 col-md-2 col-sm-2 col-xs-12 d-none d-lg-block "> <!-- Questo èla colonna SX-->

 </div>
 <div class="col"> <!-- Questo èla colonna centrale-->
 <div class="col"> <!-- Questo èla colonna centrale latoSX-->
  <div class="row">
   <img src="${pageContext.request.contextPath}/Immagini/immagini/P3.jpg" alt="">

  </div>
 </div>

 <div class="col"> <!-- Questo èla colonna centrale latoDX-->
  <div class="row">
   <div class="title">Collare Scalibor</div>
  </div>
  <div class="row">
   <div class="prezzo">Prezzo:<span>30&euro;</span></div>
  </div>
  <div class="row">
   <div class="descrizioneBreve">Da prendere dal DB.</div>
  </div>


 </div>
 </div>

  <div class="col-lg-2 col-md-2 col-sm-2 col-xs-12 d-none d-lg-block "> <!-- Questo èla colonna DX-->




 </div>
 </div>



</body>
</html>