package com.napptilus.prices.domain.services;

import java.time.LocalDateTime;

import com.napptilus.prices.domain.model.Price;

public interface PriceService {
	public Price getProductPriceForBrandOnDate(int brandId, long productId, LocalDateTime date);
}
