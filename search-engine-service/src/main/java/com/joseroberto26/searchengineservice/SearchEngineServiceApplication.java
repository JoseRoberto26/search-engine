package com.joseroberto26.searchengineservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

public class SearchEngineServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchEngineServiceApplication.class, args);
	}

}
