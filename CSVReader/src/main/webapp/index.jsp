<%-- 
    Document   : index
    Created on : Feb 18, 2024, 11:25:39 PM
    Author     : kaviprakashramalingam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="csv" uri="/WEB-INF/custom.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CSV Data</title>
    </head>
    <body>
        <h1>CSV Data</h1>
        <csv:CSVFileHandler filename="parking_facilities" />
    </body>
</html>
