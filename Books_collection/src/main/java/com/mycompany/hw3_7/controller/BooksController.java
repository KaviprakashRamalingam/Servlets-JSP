/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.hw3_7.controller;

import com.mycompany.hw3_7.model.Book;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author kaviprakashramalingam
 */
@WebServlet(name = "BooksController", urlPatterns = {"/book.htm"})
public class BooksController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (request.getParameter("file") == null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/index.jsp");
                dispatcher.forward(request, response);
            }
            if (request.getParameter("file").equals("home")) {

                int book_count = Integer.parseInt(request.getParameter("book_count"));

                request.setAttribute("book_count", book_count);

                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/addBook.jsp");
                dispatcher.forward(request, response);
            }
            if (request.getParameter("file").equals("addbook")) {
                int numberofbooks = Integer.parseInt(request.getParameter("numberofbooks"));

                ArrayList<Book> books = new ArrayList<>();

                for (int i = 1; i <= numberofbooks; i++) {
                    String isbn = request.getParameter("isbn" + i);
                    String title = request.getParameter("title" + i);
                    String authors = request.getParameter("authors" + i);
                    float price = Float.parseFloat(request.getParameter("price" + i));

                    Book book = new Book(isbn, title, authors, price);
                    books.add(book);
                }

                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/test";
                String username = "root";
                String password = "Password";
                Connection connection = DriverManager.getConnection(url, username, password);
                String query = "INSERT INTO books (isbn, title, authors, price) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                for (Book book : books) {
                    statement.setString(1, book.getIsbn());
                    statement.setString(2, book.getTitle());
                    statement.setString(3, book.getAuthors());
                    statement.setFloat(4, book.getPrice());
                    statement.addBatch();
                }
                statement.executeBatch();

                request.setAttribute("message", numberofbooks + " books added successfully");

                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/success.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
