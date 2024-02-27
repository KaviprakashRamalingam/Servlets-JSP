<%-- 
    Document   : movie-view
    Created on : Feb 18, 2024, 1:43:04 PM
    Author     : kaviprakashramalingam
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Movie View Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #F6F6F6;
        }
        .container {
            width: 80%;
            margin: 50px auto;
            padding: 30px;
            background-color: #FFFFFF;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
            color: #333;
        }
        tr:hover {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Movie View Page</h1>
        <form action="movies.htm?action=refresh.htm" method="get">
            <input type="hidden" name="action" value="refresh">
            <button type="submit" class="btn"><i class="fas fa-sync-alt"></i> Refresh</button>
        </form>
        <table>
            <tr>
                <th>Title</th>
                <th>Actor</th>
                <th>Actress</th>
                <th>Genre</th>
            </tr>
            <c:forEach var="m" items="${movies}">
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
