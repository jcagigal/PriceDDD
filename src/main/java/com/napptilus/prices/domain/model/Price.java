package com.napptilus.prices.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Price {
	int brandId;
	LocalDateTime startDate;
	LocalDateTime endDate;
	int priceList;
	long productId;
	int priority;
	double price;
	String curr;
}
