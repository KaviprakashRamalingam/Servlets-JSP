/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hw4_7.controller;

import com.mycompany.hw4_7.util.UtilClass;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author kaviprakashramalingam
 */
public class UserController extends AbstractController{
    
    public UserController(){
        
    }
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ApplicationContext ctx = this.getApplicationContext();
        UtilClass util = (UtilClass) ctx.getBean("util");
        String data = util.getData();
        System.out.println("Object ID: " + System.identityHashCode(util));
        return new ModelAndView("use-view", "msg", data);
    }
    
}
