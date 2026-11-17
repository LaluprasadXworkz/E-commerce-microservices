package com.mypro.ecomproductservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EcomProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomProductServiceApplication.class, args);
	}

}
