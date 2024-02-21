<%-- 
    Document   : User
    Created on : Feb 17, 2024, 7:35:25 PM
    Author     : kaviprakashramalingam
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL Example</title>
    </head>
    <body>
        <h1>JSTL Example Page</h1>

        <!-- Core Tag Library Group -->
        <c:set var="name" value="Kaviprakash Ramalingam" />
        <c:out value="${name}" />

        <c:if test="${1 < 2}">
            <p>Number 1 is less than number 2</p>
        </c:if>

        <c:forEach var="i" begin="1" end="3">
            <p>This is example of ${i}st Loop</p>
        </c:forEach>

        <!-- Set the variable 'now' to the current date and time -->
        <c:set var="now" value="<%= new java.util.Date() %>" />

        <fmt:formatDate value="${now}" pattern="dd-MM-yyyy HH:mm:ss" var="formattedDate" />
        <c:out value="${formattedDate}" /><br/><br/>

        <fmt:setLocale value="en_US" />
        <fmt:setTimeZone value="GMT" />

        <!-- Formatting Tag Library Group -->
        <fmt:formatNumber value="1234567.89" type="currency" /><br/>

        <!-- SQL Tag Library Group -->
        <sql:setDataSource
            var="dataSource"
            driver="com.mysql.jdbc.Driver"
            url="jdbc:mysql://localhost:3306/test"
            user="root"
            password="Password" />

        <sql:query dataSource="${dataSource}" var="result">
            SELECT * FROM users;
        </sql:query>

        <c:forEach var="row" items="${result.rows}">
            Name: <c:out value="${row.firstname}" /><br/>
            Email: <c:out value="${row.lastname}" /><br/>
        </c:forEach>

        <!-- JSTL Function Tags -->
        <br/>
        The length of variable "name" is: ${fn:length(name)}<br/>
        Substring of Current date using fn: ${fn:substringAfter(formattedDate, " ")}<br/>
        <fmt:formatDate value="${now}" pattern="dd-MM-yyyy HH:mm:ss" var="formattedDateTime" />
        <c:set var="dateTimeArray" value="${fn:split(formattedDateTime, ' ')}" />
        Date: ${dateTimeArray[0]}<br/>
        Time: ${dateTimeArray[1]}
        <!-- JSTL XML Tags -->
        <br/>
    <x:parse var="xmlData">
        <data>
            <person>
                <name>Kaviprakash</name>
                <age>25</age>
            </person>
            <person>
                <name>Vijay</name>
                <age>24</age>
            </person>
        </data>
    </x:parse>
    <x:forEach select="$xmlData/data/person">
        <x:out select="name"/> is <x:out select="age"/> years old.<br/>
    </x:forEach>

</body>
</html>