package com.napptilus.prices.infrastructure.db;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.napptilus.prices.domain.model.Price;
import com.napptilus.prices.domain.repository.PriceRepository;
import com.napptilus.prices.infrastructure.db.dbo.PriceEntity;
import com.napptilus.prices.infrastructure.db.mapper.PriceEntityMapper;
import com.napptilus.prices.infrastructure.db.mapper.PriceEntityMapperImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class PriceRepositoryImpl implements PriceRepository {

	@Autowired
	private SpringDataPriceRepository springDataPriceRepository;

	private final PriceEntityMapper priceMapper = new PriceEntityMapperImpl();

	@Override
	public Price findByBrandIdByProductIdAndByDate(int brandId, long productId, LocalDateTime date) {
		PriceEntity priceEntity = springDataPriceRepository.findByBrandIdAndByProductIdAndByDate(brandId, productId,
				date);
		return priceMapper.toDomain(priceEntity);
	}

}