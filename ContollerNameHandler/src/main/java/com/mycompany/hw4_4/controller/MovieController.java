/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hw4_4.controller;

import com.mycompany.hw4_4.pojo.Movie;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author kaviprakashramalingam
 */
//@WebServlet(name = "MovieController", urlPatterns = {"/movies.htm"})
//@Controller("/movie")
public class MovieController extends AbstractController {

    ArrayList<Movie> movies;

    public MovieController() {
        init();
    }

    public void init() {
        movies = new ArrayList<>();
        loadMoviesFromDatabase();
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "view.htm":
                    return viewMovies(request, response);
                case "search.htm":
                    return searchMovies(request, response);
                case "error.htm":
                    return errorMovies(request, response);
                case "result.htm":
                    return resultMovies(request, response);
                case "add.htm":
                    return addMovies(request, response);
                case "add1.htm":
                    return addedMovies(request, response);
                case "refresh":
                    return refreshMovies(request, response);
            }
        }
        return null;
    }

    private ModelAndView viewMovies(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView("movie-view");
        modelAndView.addObject("movies", movies);
        return modelAndView;
    }

    private ModelAndView searchMovies(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("movie-search");
    }

    private ModelAndView errorMovies(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("error");
    }

    private ModelAndView resultMovies(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        ModelAndView modelAndView = new ModelAndView("movie-result");
        modelAndView.addObject("resultList", results);
        return modelAndView;
    }

    private ModelAndView addMovies(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("add-movie");
    }

    private ModelAndView addedMovies(HttpServletRequest request, HttpServletResponse response) throws Exception {
        addMovie(request);
        return new ModelAndView("movie-added");
    }

    private ModelAndView refreshMovies(HttpServletRequest request, HttpServletResponse response) throws Exception {
        loadMoviesFromDatabase();
        ModelAndView modelAndView = new ModelAndView("movie-view");
        modelAndView.addObject("movies", movies);
        return modelAndView;
    }

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