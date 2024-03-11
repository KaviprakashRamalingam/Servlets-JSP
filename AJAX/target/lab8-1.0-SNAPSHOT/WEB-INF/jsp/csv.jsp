<%-- 
    Document   : csv
    Created on : Mar 2, 2024, 9:56:51 AM
    Author     : kaviprakashramalingam
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>CSV page</h1>
        <%
            ResultSet result = (ResultSet) request.getAttribute("resultset");
            int current = 0;
            while (result.next()) {
                current++;
                StringBuffer line = new StringBuffer();
                for (int i = 1; i < result.getMetaData().getColumnCount(); i++) {
                    line.append(result.getString(i));
                    line.append(",");
                }
                line.append("current row" + current);
        %>
        <%= line.toString()%><br><hr>
        <%
            }
        %>
    </body>
    <label id="loadcontent" style="color:red"></label>
    <button id="load10more">Load 10 More</button>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            var current = <%= current%>;
            $('#load10more').click(function () {
                $.ajax({
                    url: 'load.htm',
                    type: 'GET',
                    data: {
                        index: current
                    },
                    success: function (response) {
                        $('#loadcontent').append(response);
                    },
                    error: function (xhr, status, error) {
                        console.error("Error when executinf Ajax", error);
                    }
                });
                current += 10;
            });
        });
    </script>
    <script>
        $(document).ready(function () {
            var current = <%= current%>;
            $(window).scroll(function () {
                var scrollBottom = $(document).height() - $(window).scrollTop() - $(window).height();
                var threshold = 20;
                if (scrollBottom < threshold) {
                    $.ajax({
                        url: 'load.htm',
                        type: 'GET',
                        data: {
                            index: current
                        },
                        success: function (response) {
                            $('#loadcontent').append(response);
                        },
                        error: function (xhr, status, error) {
                            console.error("Error when executinf Ajax", error);
                        }
                    });
                    current += 10;
                }
            });
        });
    </script>
</html>
