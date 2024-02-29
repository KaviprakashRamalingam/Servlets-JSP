/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hw4_6.validator;

import com.mycompany.hw4_6.model.ShoppingCartModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author kaviprakashramalingam
 */
@Component
public class ShoppingCartValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ShoppingCartModel.class.isAssignableFrom(clazz);
    }
    
    @Override
    public void validate(Object target, Errors errors) {
        ShoppingCartModel shoppingCartModel = (ShoppingCartModel) target;

        // Check if at least one item is selected
//        if (shoppingCartModel.getCheckedItems().isEmpty()) {
//            errors.rejectValue("selectedItems", "error.selectedItems", "Please select at least one item.");
//        }
    }
    
}
