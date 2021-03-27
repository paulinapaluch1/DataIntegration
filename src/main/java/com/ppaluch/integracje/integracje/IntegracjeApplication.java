package com.ppaluch.integracje.integracje;

import com.ppaluch.integracje.integracje.csv.CSVReader;
import com.ppaluch.integracje.integracje.service.LaptopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IntegracjeApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegracjeApplication.class, args);
	}

	@Bean
	public LaptopService getLaptopService(){
		return new LaptopService();
	}

	@Bean
	public CSVReader getCSVReader(){
		return new CSVReader();
	}
}
