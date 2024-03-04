<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome to Book Inventory</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #F6F6F6;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            text-align: center;
            background-color: #FFFFFF;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #4CAF50;
            margin-bottom: 20px;
        }
        input[type="text"] {
            width: 300px;
            padding: 12px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #4285F4;
            color: white;
            padding: 12px 30px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #0F9D58;
        }
        .info {
            font-size: 18px;
            margin-top: 20px;
        }
        .info i {
            margin-right: 5px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to Book Inventory</h1>
        <form method="post" action="book.htm">
            <input type="text" name="book_count" placeholder="Enter the number of books">
            <input type="hidden" name="file" value="home">
            <input type="submit" name="submit" value="Submit">
        </form>
        <div class="info">
            <i class="fas fa-info-circle"></i> Please enter the number of books you want to add.
        </div>
    </div>
</body>
</html>
