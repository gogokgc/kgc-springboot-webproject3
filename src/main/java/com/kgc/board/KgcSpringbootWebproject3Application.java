package com.kgc.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class KgcSpringbootWebproject3Application {

	public static void main(String[] args) {
		SpringApplication.run(KgcSpringbootWebproject3Application.class, args);
	}

}
