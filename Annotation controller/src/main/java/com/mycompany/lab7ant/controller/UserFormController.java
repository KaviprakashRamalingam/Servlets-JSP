/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab7ant.controller;

import com.mycompany.lab7ant.pojo.User;
import com.mycompany.lab7ant.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kaviprakashramalingam
 */
@Controller
public class UserFormController {
//    @RequestMapping(value = "/user.htm",method = RequestMethod.GET)
//    public ModelAndView showform(){
//        User formbackingUser = new User();
//        ModelAndView mv = new ModelAndView();
//        formbackingUser.setFname("preset-fname");
//        formbackingUser.setLname("preset-lname");
//        formbackingUser.setEmail("preset-email");
//        mv.addObject("formbacking_user", formbackingUser);
//        return mv;
//    }
    @Autowired
    UserValidator validator;
    
    @RequestMapping(value = "/user.htm",method = RequestMethod.GET)
//    @GetMapping(value = "/user.htm")
    public String showForm(Model model, User user){
        user.setEmail("pre email");
        model.addAttribute("user",user);
        return "user-form";
    }
    
    @RequestMapping(value = "/user.htm",method = RequestMethod.POST)
//    @PostMapping(value = "/user.htm")
    public String submitForm(@ModelAttribute("user") User user, BindingResult results, Model model, SessionStatus status){
        validator.validate(user, results);
        
        if (results.hasErrors())
            return "user-form";
        
        status.setComplete();
        
        model.addAttribute("user", user);
        return "user-success";
    }
}
