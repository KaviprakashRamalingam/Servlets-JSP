<%-- 
    Document   : add-movie
    Created on : Feb 18, 2024, 1:43:35 PM
    Author     : kaviprakashramalingam
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Movie</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 50%;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
        }
        form {
            max-width: 400px;
            margin: 0 auto;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Add Movie</h1>
        <form action="movies.htm?action=add1" method="post">
            <label for="title">Title:</label>
            <input type="text" id="title" name="title">
            <label for="actor">Actor:</label>
            <input type="text" id="actor" name="actor">
            <label for="actress">Actress:</label>
            <input type="text" id="actress" name="actress">
            <label for="genre">Genre:</label>
            <input type="text" id="genre" name="genre">
            <input type="submit" value="Add Movie">
        </form>
    </div>
</body>
</html>
