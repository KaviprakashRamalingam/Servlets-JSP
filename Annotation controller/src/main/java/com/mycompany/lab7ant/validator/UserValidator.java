/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab7ant.validator;

import com.mycompany.lab7ant.pojo.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author kaviprakashramalingam
 */
public class UserValidator implements Validator {
    
    @Override
    public boolean supports(Class<?> type) {
        return(User.class.equals(type));
//        return User.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fname", "fname is empty", "fname cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lname", "lname is empty", "lname cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email is empty", "email cannot be empty");
    }
    
}
