<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="DAO.product.PModelDS"%>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
    <%
        DataSource ds;

        try {
        Context initCtx = new InitialContext();
        Context envCtx = (Context) initCtx.lookup("java:comp/env");

        ds = (DataSource) envCtx.lookup("jdbc/storage");

    } catch (NamingException e) {
        System.out.println("Error:" + e.getMessage());
        }%>
    <title>Online Shopping System</title>
    <!-- Importing all ui libs -->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <link href="../css/style.css" rel="stylesheet" />
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <link href="../css/style.css" rel="stylesheet" type="text/css" media="all" />
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script src="js/simpleCart.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
    <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,900,900italic,700italic' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <script src="js/jquery.easing.min.js"></script>
    <script src='../../../../../../ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js'></script>
    <script src="../../../../../../m.servedby-buysellads.com/monetization.js" type="text/javascript"></script>
</head>
<body>
<body>
<div class="ban-top">
    <div class="container">
        <div class="top_nav_left">
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed"
                                data-toggle="collapse"
                                data-target="#bs-example-navbar-collapse-1"
                                aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span> <span
                                class="icon-bar"></span> <span class="icon-bar"></span> <span
                                class="icon-bar"></span>
                        </button>
                    </div>
                    <jsp:include page="../includes/header.jsp"></jsp:include>
                </div>
            </nav>
        </div>

        <div class="top_nav_right">
            <div class="cart box_1">
                <a href="checkout.jsp">
                    <%
                        PreparedStatement resultCount =ds.getConnection().prepareStatement(
                                "SELECT count (*) FROM Acquisto where usernameCliente=? " + session.getAttribute("codice") + "");
                        ResultSet rs = resultCount.executeQuery();
                        rs.next();
                        int count = rs.getInt(1);
                    %>
                    <h3>
                        <div class="total">
                            <i class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></i>
                            (
                            <%=count%>
                            items )
                        </div>

                    </h3>
                </a>
            </div>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<div class="page-head">
    <div class="container">
        <h3>Products</h3>
    </div>
</div>
<br/>
<div class="electronics">
    <div class="container">
        <div class="clearfix"></div>
        <div class="ele-bottom-grid">
            <h3>
                Our Products
            </h3>
            <%
                PreparedStatement ps1 =ds.getConnection().prepareStatement(
                        "SELECT * FROM Prodotto");
            %>
            <form action="addToCartServlet" method="post">

                        <div class="item-info-product ">
                            <h4>
                                <%=PModelDS.
                                %>
                            </h4>
                            <div class="info-product-price">
                                <input type="hidden" name="price" value="<%=retriveProduct.getString("price")%>">
                                <input type="hidden" name="mrp_price" value="<%=retriveProduct.getString("mrp_price")%>"> <span class="item_price"><%=retriveProduct.getString("price")%> Rs.</span>
                                <del><%=retriveProduct.getString("mrp_price")%> Rs.</del>
                            </div>
                            <input type="submit" value="Add to cart" class="btn btn-warning" onclick="return confirm('Are you sure Do you want to add this item in cart?');">
                        </div>
                    </div>
                </div>
            </form>
            <%
                }
            %>
        </div>
    </div>
</div>
<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>