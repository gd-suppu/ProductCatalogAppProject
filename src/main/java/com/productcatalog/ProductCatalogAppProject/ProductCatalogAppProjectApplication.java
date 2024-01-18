package com.productcatalog.ProductCatalogAppProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductCatalogAppProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogAppProjectApplication.class, args);
	}

}
