/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment2;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;

/**
 *
 * @author kaviprakashramalingam
 */
@WebServlet(name = "getHeader", urlPatterns = "/")
public class GetHeaderNamesServlet extends HttpServlet{
    
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Enumeration<String> headerNames = request.getHeaderNames();
    Iterator<String> headerNamesIterator = headerNames.asIterator();
    StringBuilder txt = new StringBuilder();
    txt.append("<html>");
    txt.append("<h1>Part2</h1>");
    txt.append("<body>");
    txt.append("<p>");
    while (headerNamesIterator.hasNext()) {
      String header = headerNamesIterator.next();
      txt.append(header);
      txt.append(": ");
      Enumeration<String> headers = request.getHeaders(header);
      Iterator<String> headersIterator = headers.asIterator();
      while (headersIterator.hasNext()) {
      String headerNext = headersIterator.next();
      txt.append(headerNext + (headersIterator.hasNext()?", ":""));
      }
      txt.append("<br>");
    }
         txt.append("</p>");
        txt.append("</body>");
        txt.append("</html>");
      PrintWriter out = response.getWriter();
      out.println(txt);
  }
}
