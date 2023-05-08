<%--
  Created by IntelliJ IDEA.
  User: Diana
  Date: 04/05/2023
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrati al nostro sito</title>
</head>
<body>
<h1>How can you not be our member yet?</h1>

<form action="${pageContext.request.contextPath}/RegisterServlet" method="post" >
    <img alt="govno" src="https://media.tenor.com/gASV-vc37AsAAAAM/pretty-please-please.gif" style="width: 400px; height: 600px; class:right">

    <br><br>
    Codice Fiscale:
      <input type="text" name="Cf" />
    <br>
    <br>
      Username:
      <input type="text" name="Username" />
    <br>
    <br>
      Password:
      <input type="password" name="password" />
    <br>
    <br>
      Nome:
      <input type="text" name="Nome" />
    <br>
    <br>
      Cognome:
      <input type="text" name="Cognome" />
    <br>
    <br>
      Telefono:
      <input type="text" name="Telefono" />
    <br>
    <br>
     Email:
      <input type="text" name="Email" />
    <br>
    <br>
      Fax:
      <input type="text" name="Fax" />
    <br>
    <br>
      Civico:
     <input type="text" name="Civico" />
    <br>
    <br>
      Via:
      <input type="text" name="Via" />
    <br>
    <br>
      Cap:
      <input type="text" name="Cap" />
    <br>
    <br>
      Dettagli:
      <input type="text" name="Dettagli" />

    <input type="submit" value="Submit" /></form>
</body>
</html>
