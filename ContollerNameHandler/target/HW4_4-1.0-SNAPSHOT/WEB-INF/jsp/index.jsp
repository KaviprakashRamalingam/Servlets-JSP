<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Movie Database</title>
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
            text-align: center;
        }
        h1 {
            margin-bottom: 30px;
            color: #333;
        }
        .btn {
            display: inline-block;
            padding: 12px 30px;
            margin: 10px;
            border: none;
            border-radius: 5px;
            background-color: #4285F4; /* Changed button color */
            color: #fff;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            text-decoration: none;
        }
        .btn:hover {
            background-color: #0F9D58; /* Changed button hover color */
        }
        .icon {
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to Movie Database</h1>
        <a href="movies.htm?action=view.htm" class="btn"><i class="fas fa-eye icon"></i>View all Movies</a>
        <a href="movies.htm?action=search.htm" class="btn"><i class="fas fa-search icon"></i>Search Movies</a>
        <a href="movies.htm?action=add.htm" class="btn"><i class="fas fa-plus icon"></i>Add Movies</a>
    </div>
</body>
</html>
