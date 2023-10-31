package com.napptilus.prices.application.rest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.napptilus.prices.domain.model.Price;
import com.napptilus.prices.domain.services.PriceService;

@RestController
@RequestMapping("/price")
public class PriceController {

	private static final Logger LOG = LoggerFactory.getLogger(PriceController.class);

	private final PriceService priceService;

	@Autowired
	public PriceController(PriceService priceService) {
		super();
		this.priceService = priceService;
	}

	@GetMapping(value = "/{brandId}/{productId}/{date}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Price getPrice(@PathVariable final int brandId, @PathVariable final long productId,
			@PathVariable final String date) {
		try {
			return priceService.getProductPriceForBrandOnDate(brandId, productId,
					LocalDateTime.parse(date, DateTimeFormatter.ofPattern("uuuu-MM-dd-HH.mm.ss")));
		} catch (Exception e) {
			LOG.debug("Received Wrong Parameters! Or not found");
			return null;
		}
	}

}
