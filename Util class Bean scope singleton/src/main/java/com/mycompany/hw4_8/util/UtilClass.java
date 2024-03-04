/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hw4_8.util;

/**
 *
 * @author kaviprakashramalingam
 */
public class UtilClass {

    private String message;

    public UtilClass() {
        this.message = "The @Autowired annotation is used to inject\n" +
" dependencies into Spring\n" +
" beans. It is used to replace the Application Context IOC (Inversion of Control\n" +
") container.";
    }

    public String getData() {
        return message;
    }
}
