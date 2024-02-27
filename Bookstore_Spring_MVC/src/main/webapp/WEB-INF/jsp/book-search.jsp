<%-- 
    Document   : book-search
    Created on : Feb 17, 2024, 12:22:04 AM
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
        <h1>Search page</h1>
        <form method='get' action = 'book.htm'>
            Enter ISBN, Title or Author : <input type='text' name ='searchkey' />
            <input type = 'hidden' name ='action' value = 'results'/> 
            <input type="submit" value="Search Books" />
        </form>
    </body>
</html>
