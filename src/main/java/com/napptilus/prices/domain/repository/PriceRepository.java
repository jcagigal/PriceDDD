package com.napptilus.prices.domain.repository;

import java.time.LocalDateTime;

import com.napptilus.prices.domain.model.Price;

public interface PriceRepository {
	Price findByBrandIdByProductIdAndByDate(int brandId, long productId, LocalDateTime date);
}
