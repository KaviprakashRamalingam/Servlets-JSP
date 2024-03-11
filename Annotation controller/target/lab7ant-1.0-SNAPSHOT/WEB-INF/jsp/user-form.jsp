<%-- 
    Document   : user-form
    Created on : Feb 24, 2024, 10:06:54 AM
    Author     : kaviprakashramalingam
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>User-form</h1>
        <form:form modelAttribute="user">
           <form:errors path="*"></form:errors><br/> 
           First Name<form:input path="fname"></form:input><form:errors path="fname"></form:errors><br/>
           Last Name<form:input path="lname"></form:input><form:errors path="lname"></form:errors><br/>
           Email<form:input path="email"></form:input><form:errors path="email"></form:errors><br/>
           <input type="submit" value="REGISTER"/>
        </form:form>
    </body>
</html>
