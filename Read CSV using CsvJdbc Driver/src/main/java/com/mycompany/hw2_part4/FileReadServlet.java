/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hw2_part4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 *
 * @author kaviprakashramalingam
 */
@WebServlet("/csvServlet.xls")
public class FileReadServlet extends HttpServlet{
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fileName = request.getParameter("fileName");

        // CSV-JDBC connection and data retrieval logic
        // Replace the connection URL and query with your CSV file details
        String csvJdbcUrl = "jdbc:relique:csv:/Users/kaviprakashramalingam/Desktop/Servlet CSV";  // Adjust the path accordingly
        String query = "SELECT * FROM " + fileName;

        try {
            Class.forName("org.relique.jdbc.csv.CsvDriver");
            Connection connection = DriverManager.getConnection(csvJdbcUrl);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Print data in an HTML table
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h3>Data from the CSV file are as below</h3>");
            out.println("<table border='1'>");

            // Print table header with column names
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            out.println("<tr>");
            for (int i = 1; i <= columnCount; i++) {
                out.println("<th>" + metaData.getColumnName(i) + "</th>");
            }
            out.println("</tr>");

            // Print data rows
            while (resultSet.next()) {
                out.println("<tr>");
                for (int i = 1; i <= columnCount; i++) {
                    out.println("<td>" + resultSet.getString(i) + "</td>");
                }
                out.println("</tr>");
            }


            out.println("</table></body></html>");

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
