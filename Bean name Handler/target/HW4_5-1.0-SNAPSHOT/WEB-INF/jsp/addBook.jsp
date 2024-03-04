<%-- 
    Document   : addBook
    Created on : Feb 18, 2024, 9:08:01 PM
    Author     : kaviprakashramalingam
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Books</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        input[type="text"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Add Books</h2>
        <form action="book.htm" method="POST">
            <table>
                <tr>
                    <th>ISBN</th>
                    <th>Title</th>
                    <th>Authors</th>
                    <th>Price</th>
                </tr>
                <c:forEach var="i" begin="1" end="${requestScope.book_count}">
                    <tr>
                        <td><input type="text" name="isbn${i}"></td>
                        <td><input type="text" name="title${i}"></td>
                        <td><input type="text" name="authors${i}"></td>
                        <td><input type="text" name="price${i}"></td>
                    </tr>
                </c:forEach>
            </table>
            <input type="hidden" name="file" value="addbook"/>
            <input type="hidden" name="numberofbooks" value="${requestScope.book_count}"/>
            <input type="submit" name="submit" value="Submit">
        </form>
    </div>
</body>
</html>
