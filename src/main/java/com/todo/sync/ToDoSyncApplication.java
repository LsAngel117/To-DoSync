package com.todo.sync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoSyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoSyncApplication.class, args);
	}

}

//validar campos de las entidades (NotEmpty, NotNull, Password y fechas)