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
            <h1>Movie View Page</h1>
            <form action="movies.htm" method="GET">
                <input type="hidden" name="action" value="refresh">
                <button type="submit">Refresh</button><br/>
            </form>
            <table>
                <tr>
                    <th>Title</th>
                    <th>Actor</th>
                    <th>Actress</th>
                    <th>Genre</th>
                </tr>
                <c:forEach var="m" items="${applicationScope.movieList}">
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
