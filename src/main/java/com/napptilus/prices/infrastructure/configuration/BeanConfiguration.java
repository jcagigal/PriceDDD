package com.napptilus.prices.infrastructure.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.napptilus.prices.ProductPricesApplication;

@Configuration
@ComponentScan(basePackageClasses = ProductPricesApplication.class)
public class BeanConfiguration {

}
