/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hw4_9.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author kaviprakashramalingam
 */
@Component
@Scope("request")
public class UtilClass {

    private String message;

    public UtilClass() {
        this.message = "This uses Request scope and the object changes for each request. Check the console for Object Id";
    }

    public String getData() {
        return message;
    }

}
