/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab6.controller;

import com.mycompany.lab6.pojo.Book;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author kaviprakashramalingam
 */
@Controller
public class AnnotationController {

    ArrayList<Book> books;

    public AnnotationController() {
        init();
    }

    public void init() {

        Book b1 = new Book();
        b1.setIsbn("123");
        b1.setTitle("JAVA BOOK");
        b1.setAuthor("Unkown");

        Book b2 = new Book();
        b2.setIsbn("1234");
        b2.setTitle("HTML BOOK");
        b2.setAuthor("abc");

        Book b3 = new Book();
        b3.setIsbn("234");
        b3.setTitle("OOP BOOK");
        b3.setAuthor("qwer");

        books = new ArrayList<>();
        books.add(b1);
        books.add(b2);
        books.add(b3);
    }

    @RequestMapping("/view")
    public String viewBooks(Model model) {
        model.addAttribute("books", books);
        return "book-view";
    }

    @RequestMapping("/search")
    public String searchBooks() {
        return "book-search";
    }

    @RequestMapping("/error")
    public String errorBooks() {
        return "error";
    }

    @RequestMapping("/book")
    public String resultBooks(HttpServletRequest request, Model model) {
        String q = request.getParameter("searchkey");
        ArrayList<Book> results = new ArrayList<>();
        for (Book b : books) {
            if (b.getAuthor().contains(q) || b.getIsbn().contains(q) || b.getTitle().contains(q)) {
                results.add(b);

            }
        }
        model.addAttribute("resultList", results);
        return "book-result";
    }

}
