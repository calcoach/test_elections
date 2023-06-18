package com.example.backendprueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.backendprueba.config.Config;
import com.example.backendprueba.data.ConnectionDatabase;

@SpringBootApplication
public class BackendPruebaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendPruebaApplication.class, args);
		Config.config();
	}

}
