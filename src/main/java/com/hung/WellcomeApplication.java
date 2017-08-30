package com.hung;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class WellcomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WellcomeApplication.class, args);
	}
}
