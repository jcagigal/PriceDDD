package com.napptilus.prices.application.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.napptilus.prices.domain.model.Price;
import com.napptilus.prices.domain.services.PriceService;
import com.napptilus.prices.domain.services.PriceServiceImpl;
import com.napptilus.prices.infrastructure.db.SpringDataJpaConfig;

/**
 * PriceController Unit Test We mock up the service because we are just
 * interested on the controller itself
 * 
 * @author jcagigal
 *
 */
@ContextConfiguration(classes = { SpringDataJpaConfig.class })
class PriceControllerUnitTest {

	@Autowired
	private PriceController priceController;

	@InjectMocks
	private PriceService priceService;

	private final static DateTimeFormatter df = DateTimeFormatter.ofPattern("uuuu-MM-dd-HH.mm.ss");

	@BeforeEach
	void setUp() {
		priceService = mock(PriceServiceImpl.class);
		priceController = new PriceController(priceService);
	}

	@Test
	void getPriceTest() {
		when(priceService.getProductPriceForBrandOnDate(1, 35455, LocalDateTime.parse("2020-06-14-00.00.01", df)))
				.thenReturn(new Price(1, LocalDateTime.parse("2020-06-14-00.00.01", df),
						LocalDateTime.parse("2020-12-31-23.59.59", df), 1, 35455, 0, 35.50, "EUR"));
		Price expectedResult = new Price(1, LocalDateTime.parse("2020-06-14-00.00.01", df),
				LocalDateTime.parse("2020-12-31-23.59.59", df), 1, 35455, 0, 35.50, "EUR");
		Price actualResult = priceController.getPrice(1, 35455, "2020-06-14-00.00.01");

		assertEquals(expectedResult, actualResult);
	}

}
