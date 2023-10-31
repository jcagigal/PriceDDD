package com.napptilus.prices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.napptilus.prices")
@EntityScan(basePackages = { "com.napptilus.prices.domain", "com.napptilus.prices.infrastructure.db.dbo" })
public class ProductPricesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductPricesApplication.class, args);
	}

}
