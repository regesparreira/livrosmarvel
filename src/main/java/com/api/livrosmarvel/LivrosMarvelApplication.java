package com.api.livrosmarvel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LivrosMarvelApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivrosMarvelApplication.class, args);
	}

}
