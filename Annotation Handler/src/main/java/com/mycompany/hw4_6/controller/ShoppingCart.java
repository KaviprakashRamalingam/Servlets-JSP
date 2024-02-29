/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hw4_6.controller;

import com.mycompany.hw4_6.model.ShoppingCartModel;
import com.mycompany.hw4_6.validator.ShoppingCartValidator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author kaviprakashramalingam
 */
@Controller
public class ShoppingCart {

    private final ShoppingCartModel shoppingCartModel;
    private final ShoppingCartValidator shoppingCartValidator;

    @Autowired
    public ShoppingCart(ShoppingCartModel shoppingCartModel, ShoppingCartValidator shoppingCartValidator) {
        this.shoppingCartModel = shoppingCartModel;
        this.shoppingCartValidator = shoppingCartValidator;
    }

    @GetMapping(value = "/shoppingCart")
    public String shoppingCart() {
        return "shopping-cart";
    }

    @PostMapping(value = "/addCartItem")
    public String addCartItem(@RequestParam(value = "selectedItems", required = false) String[] selectedItems) {
//        shoppingCartValidator.validate(shoppingCartModel, result);
//        if (result.hasErrors()) {
//            return "shopping-cart";
//        }
        if (selectedItems == null || selectedItems.length == 0) {
            return "shopping-cart";
        }
        for (String item : selectedItems) {
            shoppingCartModel.addItem(item);
        }
        return "shopping-cart";
    }
    
    @PostMapping(value = "/removeItems")
    public String removeCartItem(@RequestParam("item") String[] item) {
        for (String items : item) {
            shoppingCartModel.removeItem(items);
        }
        return "view-cart";
    }

    @GetMapping("/books")
    public String booksCart() {
        return "books-cart";
    }

    @GetMapping("/music")
    public String musicCart() {
        return "music-cart";
    }

    @GetMapping("/computers")
    public String computersCart() {
        return "computers-cart";
    }

    @GetMapping(value = "/viewcart")
    public String viewCart() {
        return "view-cart";
    }

    @ModelAttribute("cartItems")
    public List<String> getCartItems() {
        return shoppingCartModel.getCartItems();
    }
}
