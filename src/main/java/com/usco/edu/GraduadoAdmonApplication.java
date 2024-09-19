package com.usco.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class GraduadoAdmonApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraduadoAdmonApplication.class, args);
	}
	


}
