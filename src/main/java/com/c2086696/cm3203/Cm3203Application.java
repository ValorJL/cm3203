package com.c2086696.cm3203;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
//@SpringBootApplication
public class Cm3203Application {

    public static void main(String[] args) {
        SpringApplication.run(Cm3203Application.class, args);
    }

}
