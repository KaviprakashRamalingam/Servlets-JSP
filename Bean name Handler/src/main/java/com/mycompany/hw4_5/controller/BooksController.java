/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hw4_5.controller;

import com.mycompany.hw4_5.model.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author kaviprakashramalingam
 */
@Controller
public class BooksController extends AbstractController{
    
//    @RequestMapping("/book.htm")
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            if (request.getParameter("file") == null) {
                modelAndView.setViewName("index");
            }
            if ("home".equals(request.getParameter("file"))) {
                int book_count = Integer.parseInt(request.getParameter("book_count"));
                modelAndView.addObject("book_count", book_count);
                modelAndView.setViewName("addBook");
            }
            if ("addbook".equals(request.getParameter("file"))) {
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
                // Database connection parameters
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/test";
                String username = "root";
                String password = "Password";
                
                // Create connection
                Connection connection = DriverManager.getConnection(url, username, password);
                
                // Prepare statement
                String query = "INSERT INTO books (isbn, title, authors, price) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                
                // Insert books
                for (Book book : books) {
                    statement.setString(1, book.getIsbn());
                    statement.setString(2, book.getTitle());
                    statement.setString(3, book.getAuthors());
                    statement.setFloat(4, book.getPrice());
                    statement.addBatch();
                }
                
                // Execute batch insert
                statement.executeBatch();
                
                // Close resources
                statement.close();
                connection.close();
                
                modelAndView.addObject("message", numberofbooks + " books added successfully");
                modelAndView.setViewName("success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
}
