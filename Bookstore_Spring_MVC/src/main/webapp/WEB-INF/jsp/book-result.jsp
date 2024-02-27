<%-- 
    Document   : book-view
    Created on : Feb 16, 2024, 2:44:02 PM
    Author     : kaviprakashramalingam
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Search results Page</h1>
        <table>
        <tr><td>ISBN</td><td>TITLE</td><td>Author</td></tr>
        <c:forEach var="b" items="${requestScope.resultList}">
        <tr>
            <td><c:out value="${b.isbn}"></c:out></td>
            <td><c:out value="${b.title}"></c:out></td>
            <td><c:out value="${b.author}"></c:out></td>
        </tr>
        </c:forEach>
        </table>
    </body>
</html>
