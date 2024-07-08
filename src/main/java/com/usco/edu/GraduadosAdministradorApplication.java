package com.usco.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class GraduadosAdministradorApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraduadosAdministradorApplication.class, args);
	}
	


}
