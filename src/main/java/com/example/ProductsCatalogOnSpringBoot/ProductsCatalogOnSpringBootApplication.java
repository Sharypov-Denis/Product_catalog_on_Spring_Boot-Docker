package com.example.ProductsCatalogOnSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ProductsCatalogOnSpringBootApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(ProductsCatalogOnSpringBootApplication.class, args);
		//для jersey
		// new ProductsCatalogOnSpringBootApplication().configure(new SpringApplicationBuilder(ProductsCatalogOnSpringBootApplication.class)).run(args);

	}

}
