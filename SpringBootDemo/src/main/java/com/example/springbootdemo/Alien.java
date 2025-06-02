package com.example.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Alien {

    @Value("21")
    private int age;
    private Computer computer;


    public Alien() {
        System.out.println("Alien created");
    }

    public void code() {
        System.out.println("Coding...");
        computer.compile();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("setAge called");
        this.age = age;
    }

    public Computer getComputer() {
        return computer;
    }

    @Autowired
    @Qualifier("desktop")
    public void setComputer(Computer computer) {
        this.computer = computer;
    }
}
