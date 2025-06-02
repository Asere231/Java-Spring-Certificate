package com.example.springbootdemo;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer {

    public Desktop() {
        System.out.println("Desktop created");
    }

    public void compile() {
        System.out.println("Desktop Compiling...");
    }
}