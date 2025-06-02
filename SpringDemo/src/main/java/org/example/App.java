package org.example;


import org.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args ) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Alien alien = context.getBean(Alien.class);
        System.out.println(alien.getAge());
        alien.code();

        Laptop laptop = context.getBean(Laptop.class);
//        laptop.compile();

        Desktop desktop = context.getBean(Desktop.class);
//        desktop.compile();


//        ======= Config using XML =============
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        Alien alien = (Alien) context.getBean("alien");
//        System.out.println(alien.getAge());
//        alien.code();

//        Alien alien2 = (Alien) context.getBean("alien");
//        alien2.code();
    }
}
