
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/LoginServlet" method="post" >
    <p> Hey there!</p>
    <p>Pets&CO is here for all your pet's needs</p><br><br>
    <img alt="govno" src="https://i.ytimg.com/vi/fOd16PT1S7A/maxresdefault.jpg" style="width: 600px; height: 400px; class:center">

    <br>
    <br>



    Email:  <input align="right" type="text" name="Email"/><br>
Password:  <input align="right" type="text" name="Password"/>
    <input  align="right" type="submit" value="submit">

</form>
</body>
</html>
