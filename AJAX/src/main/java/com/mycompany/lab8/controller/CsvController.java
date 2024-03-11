/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab8.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kaviprakashramalingam
 */
@Controller
public class CsvController {

    @GetMapping("/csv.htm")
    public ModelAndView displayCsv() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("org.relique.jdbc.csv.CsvDriver");
            Connection connection = DriverManager.getConnection("jdbc:relique:csv:/Users/kaviprakashramalingam/Downloads");
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from parking_facilities limit 10");

            ModelAndView mc = new ModelAndView("csv");
            mc.addObject("resultset", result);
            return mc;
        } catch (ClassNotFoundException ex) {

        }
        return new ModelAndView("error");
    }

    @GetMapping("/load.htm")
    @ResponseBody
    public String response(@RequestParam("index") int index) throws SQLException {
        try {
            Class.forName("org.relique.jdbc.csv.CsvDriver");
            Connection connection = DriverManager.getConnection("jdbc:relique:csv:/Users/kaviprakashramalingam/Downloads");
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from parking_facilities limit 10 offset "+index);
            StringBuffer line = new StringBuffer();
            while (result.next()) {
                for (int i = 1; i < result.getMetaData().getColumnCount(); i++) {
                    line.append(result.getString(i));
                    line.append(",");
                }
                index++;
                line.append(index);
                line.append("<br><hr>");
            }
            return line.toString();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CsvController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
