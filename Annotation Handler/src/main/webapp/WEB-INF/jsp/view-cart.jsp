<%-- 
    Document   : view-cart
    Created on : Feb 24, 2024, 2:43:50 PM
    Author     : kaviprakashramalingam
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>View Cart</title>
    </head>
    <body>
        <h2>The following items have been added to your shopping cart successfully</h2>
        <c:choose>
            <c:when test="${not empty cartItems}">
                <form method='post' action='removeItems.htm'>
                    <table border='1'>
                        <tr>
                            <th>Action</th>
                            <th>Item</th>
                        </tr>
                        <c:forEach items="${cartItems}" var="item">
                            <tr>
                                <td><input type='checkbox' name='item' value='${item}' /></td>
                                <td>${item}</td>
                            </tr>
                        </c:forEach>
                    </table>
                    <br/>
                    <input type='submit' value='Remove Selected Items' onclick='showRemoveConfirmation()'/>
                </form>
            </c:when>
            <c:otherwise>
                <p>Cart is empty</p>
            </c:otherwise>
        </c:choose>
        <a href='shoppingCart.htm'>[ Back to Shopping ]</a>
        <a href='books.htm'>[ Go to Books Page ]</a>
        <a href='music.htm'>[ Go to Music Page ]</a>
        <a href='computers.htm'>[ Go to Computers Page ]</a>
        <script src="${pageContext.request.contextPath}/resources/js/Confirmation.js"></script>
    </body>
</html>
