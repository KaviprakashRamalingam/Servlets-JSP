<%-- 
    Document   : movie-search
    Created on : Feb 18, 2024, 2:08:58 PM
    Author     : kaviprakashramalingam
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Search Movies</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f4f4f4;
            }
            .container {
                width: 50%;
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
            form {
                text-align: center;
            }
            input[type="text"] {
                width: 60%;
                padding: 10px;
                margin-bottom: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
                box-sizing: border-box;
            }
            input[type="submit"] {
                background-color: #4caf50;
                color: #fff;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }
            input[type="submit"]:hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Search Movies</h1>
            <form method="get" action="movies.htm">
                <input type="text" name="searchkey" placeholder="Enter keyword">
                <br>
                <input type="radio" name="searchBy" value="title" checked>Title
                <input type="radio" name="searchBy" value="actor">Actor
                <input type="radio" name="searchBy" value="actress">Actress
                <input type="radio" name="searchBy" value="genre">Genre
                <br>
                <input type="hidden" name="action" value="results"> 
                <input type="submit" value="Search Movies">
            </form>
        </div>
    </body>
</html>

