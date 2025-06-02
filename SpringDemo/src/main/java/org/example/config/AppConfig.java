package org.example.config;

import org.example.Alien;
import org.example.Computer;
import org.example.Desktop;
import org.example.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("org.example")
public class AppConfig {

//    @Bean(name = {"lap", "l"})
//    @Scope("prototype")
//    @Bean
//    @Primary
//    public Laptop laptop() {
//        return new Laptop();
//    }
//
//    @Bean
//    public Alien alien(@Autowired Computer com) {
//        Alien alien = new Alien();
//        alien.setAge(25);
//        alien.setComputer(com);
//        return alien;
//    }
//
//    @Bean
//    public Desktop desktop() {
//        return new Desktop();
//    }
}
