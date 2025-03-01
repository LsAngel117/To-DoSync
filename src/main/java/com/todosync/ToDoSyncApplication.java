package com.todosync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ToDoSyncApplication {
    public static void main(String[] args) {
        SpringApplication.run(ToDoSyncApplication.class, args);
    }
}

//validar campos de las entidades (NotEmpty, NotNull, Password y fechas)