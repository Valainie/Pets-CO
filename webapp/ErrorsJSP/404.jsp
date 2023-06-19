<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
    <script src="https://code.iconify.design/3/3.1.0/iconify.min.js"></script>
    <title>Not Found</title>
    <link href="${pageContext.request.contextPath}/css/error.css" rel="stylesheet" type="text/css" media="all"/>

</head>
<body class="error">

<h1>404</h1>

<div class="header">
    <img src="${pageContext.request.contextPath}/Immagini/ConfusedCat.jpg" alt="FOTO ERRORE" width="400" height="392">
    <p id="el">Not Found.</p>
</div>

<div class="error-searchbar">
    <span>
        <a href="${pageContext.request.contextPath}/homePage.jsp" target="_blank">
        <img width="124" height="115" src="${pageContext.request.contextPath}/Immagini/Logo.png" alt="Logo"/>
        </a>
    </span>
    <form action="productselection.jsp">
        <input type="text" placeholder="Search.." name="search2">
        <button type="submit"><span class="iconify" data-icon="material-symbols:search-rounded">Cerca</span></button>
    </form>
</div>

</body>
</html>