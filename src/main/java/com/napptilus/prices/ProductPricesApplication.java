package com.napptilus.prices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com.napptilus.prices")
@EntityScan(basePackages = { "com.napptilus.prices.domain", "com.napptilus.prices.infrastructure.db.dbo" })
public class ProductPricesApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ProductPricesApplication.class).properties(
                "com.napptilus.prices.mode:servlet-container");
	}
	
	public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder(ProductPricesApplication.class).properties(
                "com.napptilus.prices.mode:standalone").run(args);
	}

}
