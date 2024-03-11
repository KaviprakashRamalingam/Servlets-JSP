/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/SimpleFormController.java to edit this template
 */
package com.mycompany.lab7.controller;

import com.mycompany.lab7.pojo.User;
import com.mycompany.lab7.validator.UserValidator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author kaviprakashramalingam
 */
public class UserFormController extends SimpleFormController {
    
    public UserFormController() {
        //Initialize controller properties here or 
        //in the Web Application Context
        Validator userValidator = new UserValidator();
        setCommandClass(User.class);
        setCommandName("user");
        setSuccessView("user-success");
        setFormView("user-form");
        setValidator(userValidator);
    }
    
    @Override
    protected void doSubmitAction(Object command) throws Exception {
        User user = (User) command;
        System.out.println("===user fanme is==="+user.getFname());
        System.out.println("===user lanme is==="+user.getLname());
        System.out.println("===user email is==="+user.getEmail());
    }
    
    
    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
//    @Override
//    protected ModelAndView onSubmit(
//            HttpServletRequest request, 
//            HttpServletResponse response, 
//            Object command, 
//            BindException errors) throws Exception {
//        ModelAndView mv = new ModelAndView("onsubmit-success");
//        User user = (User) command;
//        String originalfname = user.getFname();
//        User newuser = new User();
//        newuser.setFname(originalfname+"this is modified");
//        
//        mv.addObject("onSubmit_user", newuser);
//        
//        return mv;
//    }
    
    
//   DataBinder
    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
       User user = new User();
       user.setFname("pre_set_fname");
       user.setLname("pre_set_lname");
       user.setEmail("pre_set_email");
       return user;
    }
}
