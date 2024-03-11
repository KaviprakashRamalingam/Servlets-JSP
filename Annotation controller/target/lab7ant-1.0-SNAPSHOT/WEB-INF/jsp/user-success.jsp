<%-- 
    Document   : user-success
    Created on : Feb 24, 2024, 10:06:46 AM
    Author     : kaviprakashramalingam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Success!</h1>
        ${requestScope.user.fname}<br/>
        ${requestScope.user.lname}<br/>
        ${requestScope.user.email}<br/>
    </body>
</html>
