package com.napptilus.prices.infrastructure.db.dbo;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Entity(name = "Price")
@Getter
@Setter
@NoArgsConstructor
@Table(name = "PRICE")
@Data
@IdClass(PriceEntityId.class)
public class PriceEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "BRAND_ID")
	BrandEntity brandId;

	@Id
	@Column(name = "START_DATE", nullable = false)
	LocalDateTime startDate;

	@Id
	@Column(name = "END_DATE", nullable = false)
	LocalDateTime endDate;

	@Id
	@Column(name = "PRICE_LIST", nullable = false)
	int priceList;

	@Id
	@Column(name = "PRODUCT_ID", nullable = false)
	long productId;

	@Id
	@Column(name = "PRIORITY", nullable = false)
	int priority;

	@Column
	double price;

	@Column
	String curr;
}
