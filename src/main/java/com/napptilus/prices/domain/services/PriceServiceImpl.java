package com.napptilus.prices.domain.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.napptilus.prices.domain.model.Price;
import com.napptilus.prices.domain.repository.PriceRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	private final PriceRepository priceRepository;

	@Override
	public Price getProductPriceForBrandOnDate(int brandId, long productId, LocalDateTime date) {
		return priceRepository.findByBrandIdByProductIdAndByDate(brandId, productId, date);
	}
}
