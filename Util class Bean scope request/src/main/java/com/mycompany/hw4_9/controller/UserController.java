/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hw4_9.controller;

import com.mycompany.hw4_9.util.UtilClass;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kaviprakashramalingam
 */
//@Controller
//@RequestMapping("/user")
//public class UserController {
//    
//    private final UtilClass util;
//    
//    @Autowired
//    private WebApplicationContext applicationContext;
//    
//    @Autowired
//    public UserController(UtilClass util) {
//        this.util = util;
//    }
//
//    @GetMapping
//    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//        UtilClass util = (UtilClass) applicationContext.getBean("util");
//        String data = util.getData();
//        System.out.println("Object ID: " + System.identityHashCode(util));
//        return new ModelAndView("use-view", "msg", data);
//    }
//}
@Controller
public class UserController {

    @GetMapping("/user")
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response, UtilClass util) throws Exception {
        
        System.out.println("Object ID: " + System.identityHashCode(util));
        ModelAndView model = new ModelAndView("use-view");
        model.addObject("msg", util.getData());
        
        return model;
    }
}
