<%--
  Created by IntelliJ IDEA.
  User: Diana
  Date: 15/05/2023
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
    <title>Pets&CO Cart</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.min.js"></script>
    <script src = "https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/locale/lt.js"></script>
    <script type="text/javascript" src="../JS/formVal.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>
    <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>


    <c:set var="total" value="0"></c:set>
    <c:forEach var="item" items="${sessionScope.cart }">
        <c:set var="total" value="${total + item.product.price * item.quantity }"></c:set>
        <tr>
                <a href="${pageContext.request.contextPath }/cart?action=remove&id=${item.product.id }"
                   onclick="return confirm('Are you sure?')">Remove</a>
            </td>
            <td>${item.product.id }</td>
            <td>${item.product.name }</td>
            <td>
                <img src="${pageContext.request.contextPath }/assets/images/${item.product.photo }" width="120">
            </td>
            <td>${item.product.price }</td>
            <td>${item.quantity }</td>
            <td>${item.product.price * item.quantity }</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="6" align="right">Total</td>
        <td>${total }</td>
    </tr>
</table>
<br>
<a href="${pageContext.request.contextPath }/ProdottoServlet">Continue Shopping</a>

</body>
</html>