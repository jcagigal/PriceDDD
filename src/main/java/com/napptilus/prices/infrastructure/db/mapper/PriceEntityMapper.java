package com.napptilus.prices.infrastructure.db.mapper;

import com.napptilus.prices.domain.model.Price;
import com.napptilus.prices.infrastructure.db.dbo.PriceEntity;

//@Mapper(componentModel = "spring")
public interface PriceEntityMapper {
	Price toDomain(PriceEntity dbo);

	PriceEntity toDbo(Price domain);
}
