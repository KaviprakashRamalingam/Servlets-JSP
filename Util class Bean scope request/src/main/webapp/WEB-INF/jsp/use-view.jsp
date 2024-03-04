<%-- 
    Document   : use-view
    Created on : Feb 25, 2024, 2:14:06 PM
    Author     : kaviprakashramalingam
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Message from UtilClass</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #F6F6F6;
            margin: 0;
            padding: 0;
        }
        .container {
            margin: 50px auto;
            width: 60%;
            background-color: #FFFFFF;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h1 {
            color: #4CAF50;
            margin-bottom: 20px;
        }
        p {
            color: #333;
            font-size: 18px;
            margin-top: 20px;
        }
        .message {
            background-color: #FFFFFF;
            padding: 20px;
            border-radius: 8px;
            margin-top: 20px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        .message p:first-of-type {
            margin-top: 0;
        }
        .icon {
            color: #4285F4;
            font-size: 48px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <i class="fas fa-info-circle icon"></i>
        <h1>Message from UtilClass</h1>
        <div class="message">
            <p>The following message is retrieved from UtilClass:</p>
            <p>${msg}</p>
        </div>
        <p>For Object ID, check Tomcat console.</p>
    </div>
</body>
</html>
