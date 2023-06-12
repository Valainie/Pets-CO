
<!DOCTYPE html>
<html lang="en">
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
    <label>
        Email:
        <input type="text" name="Email"/>
        <br>
        Password:
        <input type="text" name="Password"/>
        <input  type="submit" value="submit">
    </label>

</form>
</body>
</html>
