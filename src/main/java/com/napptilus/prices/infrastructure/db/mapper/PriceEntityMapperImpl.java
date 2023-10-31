package com.napptilus.prices.infrastructure.db.mapper;

import org.springframework.stereotype.Component;

import com.napptilus.prices.domain.model.Price;
import com.napptilus.prices.infrastructure.db.dbo.BrandEntity;
import com.napptilus.prices.infrastructure.db.dbo.PriceEntity;

@Component
public class PriceEntityMapperImpl implements PriceEntityMapper {

	@Override
	public Price toDomain(PriceEntity priceEntity) {
		Price price = new Price();
		price.setBrandId(priceEntity.getBrandId().getBrandId());
		price.setCurr(priceEntity.getCurr());
		price.setEndDate(priceEntity.getEndDate());
		price.setPrice(priceEntity.getPrice());
		price.setPriceList(priceEntity.getPriceList());
		price.setPriority(priceEntity.getPriority());
		price.setProductId(priceEntity.getProductId());
		price.setStartDate(priceEntity.getStartDate());
		return price;
	}

	@Override
	public PriceEntity toDbo(Price price) {
		PriceEntity priceEntity = new PriceEntity();
		BrandEntity brandEntity = new BrandEntity();
		brandEntity.setBrandId(price.getBrandId());
		priceEntity.setBrandId(brandEntity);
		priceEntity.setCurr(price.getCurr());
		priceEntity.setEndDate(price.getEndDate());
		priceEntity.setPrice(price.getPrice());
		priceEntity.setPriceList(price.getPriceList());
		priceEntity.setPriority(price.getPriority());
		priceEntity.setProductId(price.getProductId());
		priceEntity.setStartDate(price.getStartDate());
		return priceEntity;
	}

}
