package com.esprit.firstspringbootproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class FirstSpringBootProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstSpringBootProjectApplication.class, args);
    }

}
