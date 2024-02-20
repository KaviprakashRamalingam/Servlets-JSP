/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hw3_4.controller;

import com.mycompany.hw3_4.pojo.Movie;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author kaviprakashramalingam
 */
@WebServlet(name = "MovieController", urlPatterns = {"/movies.htm"})
public class MovieController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ArrayList<Movie> movies;

    public void init() {
        movies = new ArrayList<>();
        loadMoviesFromDatabase();
        ServletContext ctx = this.getServletContext();
        ctx.setAttribute("movieList", movies);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        RequestDispatcher dispatcher;
        if (action == null) {
            dispatcher = request.getRequestDispatcher("index.html");
        } else if (action.equals("view")) {
            dispatcher = request.getRequestDispatcher("WEB-INF/movie-view.jsp");
        } else if (action.equals("search")) {
            dispatcher = request.getRequestDispatcher("WEB-INF/movie-search.jsp");
        } else if (action.equals("results")) {
            String searchKey = request.getParameter("searchkey");
            String searchBy = request.getParameter("searchBy");
            ArrayList<Movie> results = new ArrayList<>();
            for (Movie m : movies) {
                switch (searchBy) {
                    case "title":
                        if (m.getTitle().contains(searchKey)) {
                            results.add(m);
                        }
                        break;
                    case "actor":
                        if (m.getActor().contains(searchKey)) {
                            results.add(m);
                        }
                        break;
                    case "actress":
                        if (m.getActress().contains(searchKey)) {
                            results.add(m);
                        }
                        break;
                    case "genre":
                        if (m.getGenre().contains(searchKey)) {
                            results.add(m);
                        }
                        break;
                }
            }
            request.setAttribute("resultList", results);
            dispatcher = request.getRequestDispatcher("WEB-INF/movie-result.jsp");
        } else if (action.equals("add")) {
            dispatcher = request.getRequestDispatcher("WEB-INF/add-movie.jsp");
        } else if (action.equals("add1")) {
            addMovie(request);
            dispatcher = request.getRequestDispatcher("WEB-INF/movie-added.jsp");
        } else if (action.equals("refresh")) {
            loadMoviesFromDatabase(); // Reload data from the database
            dispatcher = request.getRequestDispatcher("WEB-INF/movie-view.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("WEB-INF/error.jsp");
        }

        dispatcher.forward(request, response);
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

    private void loadMoviesFromDatabase() {
        movies.clear();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/test";
            String username = "root";
            String password = "Password";
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM movies";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setTitle(resultSet.getString("title"));
                movie.setActor(resultSet.getString("actor"));
                movie.setActress(resultSet.getString("actress"));
                movie.setGenre(resultSet.getString("genre"));
                movies.add(movie);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void addMovie(HttpServletRequest request) {
        String title = request.getParameter("title");
        String actor = request.getParameter("actor");
        String actress = request.getParameter("actress");
        String genre = request.getParameter("genre");

        // To avoid null entries being added to DB
        if (title == null || title.isEmpty() || actor == null || actor.isEmpty()
                || actress == null || actress.isEmpty() || genre == null || genre.isEmpty()) {
            return;
        }
        // To avoid duplicates
        for (Movie movie : movies) {
            if (movie.getTitle().equals(title)) {
                return;
            }
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/test";
            String username = "root";
            String password = "Password";
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO movies (title, actor, actress, genre) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, actor);
            preparedStatement.setString(3, actress);
            preparedStatement.setString(4, genre);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            // Reload movies from the database after adding a new movie
            loadMoviesFromDatabase();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
