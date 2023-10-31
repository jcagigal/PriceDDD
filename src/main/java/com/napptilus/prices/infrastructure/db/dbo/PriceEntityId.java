package com.napptilus.prices.infrastructure.db.dbo;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class PriceEntityId implements Serializable {

	private static final long serialVersionUID = 1L;

	BrandEntity brandId;

	LocalDateTime startDate;

	LocalDateTime endDate;

	int priceList;

	long productId;

	int priority;

}
