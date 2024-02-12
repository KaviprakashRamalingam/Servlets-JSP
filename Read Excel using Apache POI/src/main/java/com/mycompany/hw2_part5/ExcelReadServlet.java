/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hw2_part5;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *
 * @author kaviprakashramalingam
 */
@WebServlet("/xlsServlet.xls")
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"user"}))
public class ExcelReadServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("fileName");

        // Read Excel file and data retrieval logic
        // Replace the file path with your Excel file path
        String filePath = "/Users/kaviprakashramalingam/Desktop/Servlet CSV/store.xls";  // Adjust the path accordingly
        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
        Workbook workbook = new HSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        // Print data in an HTML table
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>Data from the Excel file are as below</h3>");
        out.println("<table border='1'>");

        // Print table header with column names
        int headerRow = sheet.getFirstRowNum();
        Row headerRowObj = sheet.getRow(headerRow);
        int headerCols = headerRowObj.getPhysicalNumberOfCells();
        out.println("<tr>");
        for (int i = 0; i < headerCols; i++) {
            out.println("<th>" + headerRowObj.getCell(i).toString() + "</th>");
        }
        out.println("</tr>");

        // Print data rows
        int totalRows = sheet.getPhysicalNumberOfRows();
        for (int i = 1; i < totalRows; i++) {
            out.println("<tr>");
            Row row = sheet.getRow(i);
            int totalCols = row.getPhysicalNumberOfCells();
            for (int j = 0; j < totalCols; j++) {
                out.println("<td>" + row.getCell(j).toString() + "</td>");
            }
            out.println("</tr>");
        }

        out.println("</table></body></html>");

        fileInputStream.close();
        workbook.close();
    }
}
