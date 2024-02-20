/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package com.mycompany.csvreader;

import jakarta.servlet.ServletContext;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.PageContext;
import jakarta.servlet.jsp.tagext.JspFragment;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author kaviprakashramalingam
 */
public class CSVFileHandler extends SimpleTagSupport {
    private String filename;
    
    public void setFilename(String filename) {
        this.filename = filename;
    }
    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException, IOException {
        try {
            Class.forName("org.relique.jdbc.csv.CsvDriver");
//            ServletContext context = ((PageContext)getJspContext()).getServletContext();
//            String path = "/WEB-INF";
//            String absoluteDiskPath = context.getRealPath(path);        
            String directory = "/Users/kaviprakashramalingam/Downloads";
            try (Connection conn = DriverManager.getConnection("jdbc:relique:csv:" + directory)) {
                PrintWriter out = new PrintWriter(getJspContext().getOut());
                
                try (Statement stmt = conn.createStatement()) {
                    ResultSet rs = stmt.executeQuery("SELECT * FROM " + filename);
                    out.println("<table border=\"1\">");
                    while (rs.next()) {
                        out.println("<tr>");
                        for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                            out.println("<td>" + rs.getString(i) + "</td>");
                        }
                        out.println("</tr>");
                    }
                    out.println("</table>");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new JspException("Error: " + e.getMessage());
        }
    }
    
}
