<%-- 
    Document   : movie-result
    Created on : Feb 18, 2024, 1:43:49 PM
    Author     : kaviprakashramalingam
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Results</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            width: 80%;
            margin: auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Search Results</h1>
        <table>
            <tr>
                <th>Title</th>
                <th>Actor</th>
                <th>Actress</th>
                <th>Genre</th>
            </tr>
            <c:forEach var="m" items="${resultList}">
                <tr>
                    <td><c:out value="${m.title}"/></td>
                    <td><c:out value="${m.actor}"/></td>
                    <td><c:out value="${m.actress}"/></td>
                    <td><c:out value="${m.genre}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
