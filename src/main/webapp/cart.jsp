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
</head>
<body>
 <tr>
        <th>Tipo</th>
        <th>DescrizioneBreve</th>
     <th>DescrizioneLunga</th>
     <th>Photo</th>
        <th>Price</th>

    </tr>
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