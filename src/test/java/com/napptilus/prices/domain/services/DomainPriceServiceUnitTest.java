package com.napptilus.prices.domain.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.napptilus.prices.domain.model.Price;
import com.napptilus.prices.domain.repository.PriceRepository;
import com.napptilus.prices.infrastructure.db.SpringDataJpaConfig;

/**
 * PriceService Unit Test We are just interested in the behaviour of the service
 * so we mock up the repository
 * 
 * @author jcagigal
 *
 */
@ContextConfiguration(classes = { SpringDataJpaConfig.class })
class DomainPriceServiceUnitTest {

	@InjectMocks
	private PriceRepository priceRepository;

	@Autowired
	private PriceService priceService;

	private final static DateTimeFormatter df = DateTimeFormatter.ofPattern("uuuu-MM-dd-HH.mm.ss");

	@BeforeEach
	void setUp() {
		priceRepository = mock(PriceRepository.class);
		priceService = new PriceServiceImpl(priceRepository);
	}

	@Test
	void shouldRecoverPrice() {
		when(priceRepository.findByBrandIdByProductIdAndByDate(1, 35455,
				LocalDateTime.parse("2020-06-14-00.00.01", df)))
				.thenReturn(new Price(1, LocalDateTime.parse("2020-06-14-00.00.01", df),
						LocalDateTime.parse("2020-12-31-23.59.59", df), 1, 35455, 0, 35.50, "EUR"));
		final Price foundPrice = priceService.getProductPriceForBrandOnDate(1, 35455,
				LocalDateTime.parse("2020-06-14-00.00.01", df));
		verify(priceRepository, times(1)).findByBrandIdByProductIdAndByDate(1, 35455,
				LocalDateTime.parse("2020-06-14-00.00.01", df));
		assertNotNull(foundPrice);
	}

}
