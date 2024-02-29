/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hw4_6.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kaviprakashramalingam
 */
public class ShoppingCartModel {
    private List<String> cartItems;

    public ShoppingCartModel() {
        this.cartItems = new ArrayList<>();
    }

    public List<String> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<String> cartItems) {
        this.cartItems = cartItems;
    }

    public void addItem(String item) {
        cartItems.add(item);
    }
    
    public void removeItem(String item) {
        cartItems.remove(item);
    }
}
