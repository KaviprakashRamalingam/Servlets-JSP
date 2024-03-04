/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hw4_8.controller;

import com.mycompany.hw4_8.util.UtilClass;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author kaviprakashramalingam
 */
@Controller
public class UserController{

    @Autowired
    private UtilClass util;
    
    @GetMapping("/user")
    public ModelAndView handleRequest() {
        String data = util.getData();
        System.out.println("Object ID: " + System.identityHashCode(util));
        return new ModelAndView("use-view", "msg", data);
    }
}
