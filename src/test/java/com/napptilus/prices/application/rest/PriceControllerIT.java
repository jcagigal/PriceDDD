package com.napptilus.prices.application.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;

/**
 * PriceController Integration Test Please note that It requires having the
 * application running. It includes a single test and also multiple
 * parameterized tests
 * 
 * @author jcagigal
 *
 */
class PriceControllerIT {

	private static final Logger LOG = LoggerFactory.getLogger(PriceControllerIT.class);

	private static int PORT = 8080;

	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();

	/**
	 * Individual test
	 */
	@Test
	void isInsidePriceRange() {
		headers.add("Content-Type", "application/json");
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		String expected = "{\"brandId\":1,\"startDate\":\"2020-06-14T00:00:00\",\"endDate\":\"2020-12-31T23:59:59\",\"priceList\":1,\"productId\":35455,\"priority\":0,\"price\":35.5,\"curr\":\"EUR\"}";
		String fullUriPath = "http://localhost:" + PORT + "/price/1/35455/2020-06-14-00.00.01";
		String responseStr = null;
		try {
			LOG.info("Sending GET request to [" + fullUriPath + "]");
			ResponseEntity<String> response = restTemplate.exchange(fullUriPath, HttpMethod.GET, entity, String.class);
			responseStr = response.getBody();
		} catch (ResourceAccessException e) {
			LOG.error("TEST FAILED: Couldn't connect to the server... is It up and running? is port " + PORT
					+ " opened?");
		}
		assertEquals(expected, responseStr, "GET request to [" + fullUriPath + "] FAILED!");
	}

	/**
	 * Parameterized test: Validation of get requests ○ Test 1: petición a las 10:00
	 * del día 14 del producto 35455 para la brand 1 ○ Test 2: petición a las 16:00
	 * del día 14 del producto 35455 para la brand 1 ○ Test 3: petición a las 21:00
	 * del día 14 del producto 35455 para la brand 1 ○ Test 4: petición a las 10:00
	 * del día 15 del producto 35455 para la brand 1 ○ Test 5: petición a las 21:00
	 * del día 16 del producto 35455 para la brand 1
	 * 
	 * @param input          GET requests "price/" is already included so use as
	 *                       parameter for this first part something like:
	 *                       "1/35455/2020-06-14-10.00.00"
	 * @param expectedResult expected json, e.g.:
	 *                       "\"startDate\":\"2020-06-14T00:00:00\",\"endDate\":\"2020-12-31T23:59:59\",\"priceList\":1,\"productId\":35455,\"priority\":0,\"price\":35.5,\"curr\":\"EUR\"}"
	 */
	@ParameterizedTest
	@CsvSource(value = {
			"1/35455/2020-06-14-10.00.00;{\"brandId\":1,\"startDate\":\"2020-06-14T00:00:00\",\"endDate\":\"2020-12-31T23:59:59\",\"priceList\":1,\"productId\":35455,\"priority\":0,\"price\":35.5,\"curr\":\"EUR\"}",
			"1/35455/2020-06-14-16.00.00;{\"brandId\":1,\"startDate\":\"2020-06-14T15:00:00\",\"endDate\":\"2020-06-14T18:30:00\",\"priceList\":2,\"productId\":35455,\"priority\":1,\"price\":25.45,\"curr\":\"EUR\"}",
			"1/35455/2020-06-14-21.00.00;{\"brandId\":1,\"startDate\":\"2020-06-14T00:00:00\",\"endDate\":\"2020-12-31T23:59:59\",\"priceList\":1,\"productId\":35455,\"priority\":0,\"price\":35.5,\"curr\":\"EUR\"}",
			"1/35455/2020-06-15-10.00.00;{\"brandId\":1,\"startDate\":\"2020-06-15T00:00:00\",\"endDate\":\"2020-06-15T11:00:00\",\"priceList\":3,\"productId\":35455,\"priority\":1,\"price\":30.5,\"curr\":\"EUR\"}",
			"1/35455/2020-06-16-21.00.00;{\"brandId\":1,\"startDate\":\"2020-06-15T16:00:00\",\"endDate\":\"2020-12-31T23:59:59\",\"priceList\":4,\"productId\":35455,\"priority\":1,\"price\":38.95,\"curr\":\"EUR\"}" }, delimiter = ';')
	void isInsidePriceRangeMultiple(String input, String expectedResult) {
		headers.add("Content-Type", "application/json");
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		String fullUriPath = "http://localhost:" + PORT + "/price/" + input;
		String responseStr = null;
		try {
			LOG.info("Sending GET request to [" + fullUriPath + "]");
			ResponseEntity<String> response = restTemplate.exchange(fullUriPath, HttpMethod.GET, entity, String.class);
			responseStr = response.getBody();
		} catch (ResourceAccessException e) {
			LOG.error("TEST FAILED: Couldn't connect to the server... is It up and running? is port " + PORT
					+ " opened?");
		}
		assertEquals(expectedResult, responseStr, "GET request to [" + fullUriPath + "] FAILED!");
	}

}
