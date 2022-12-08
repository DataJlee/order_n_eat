package com.orderneat.orderneat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OrderneatApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderneatApplication.class, args);
	}

}
