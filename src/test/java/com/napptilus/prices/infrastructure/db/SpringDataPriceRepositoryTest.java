package com.napptilus.prices.infrastructure.db;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.napptilus.prices.infrastructure.db.dbo.PriceEntity;

/**
 * SpringDataPriceRepository Unit Test SpringDataPriceRepository performs an
 * interesting query so we'd like to check that it works fine.
 * 
 * @author jcagigal
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class SpringDataPriceRepositoryTest {

	@Autowired
	private SpringDataPriceRepository springDataPriceRepository;

	private final static DateTimeFormatter df = DateTimeFormatter.ofPattern("uuuu-MM-dd-HH.mm.ss");

	@Test
	@DisplayName("getPriceTest_findIt(): try to find a price... should find It")
	void getPriceTest_findIt() {
		PriceEntity actualResult = springDataPriceRepository.findByBrandIdAndByProductIdAndByDate(1, 35455L,
				LocalDateTime.parse("2020-06-14-10.00.00", df));
		assertNotNull(actualResult);
	}

	@Test
	@DisplayName("getPriceTest_cantFindIt(): try to find a price that doesn't exist... should not find It")
	void getPriceTest_cantFindIt() {
		PriceEntity actualResult = springDataPriceRepository.findByBrandIdAndByProductIdAndByDate(1, 35455L,
				LocalDateTime.parse("1492-10-12-00.00.00", df));
		assertNull(actualResult);
	}

}
