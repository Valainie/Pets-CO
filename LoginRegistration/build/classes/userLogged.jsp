<%--
  Created by IntelliJ IDEA.
  User: Diana
  Date: 04/05/2023
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (session.getAttribute("name") == null) {
        response.sendRedirect(request.getContextPath() + "/invalidLogin.jsp");
        return;
    }
    String name = session.getAttribute("name").toString();
%>
<html>
<head>
    <title>Pets&CO</title>
</head>
<body>

    current session info: <%= name %> <br> <br>

    <img alt="govno" src="https://static.wikia.nocookie.net/cutekittycats/images/a/ad/Caty.jpeg" style="width: 400px; height: 300px; class: center">


</body>
</html>
