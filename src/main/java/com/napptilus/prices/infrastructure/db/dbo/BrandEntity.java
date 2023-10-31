package com.napptilus.prices.infrastructure.db.dbo;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Entity(name = "Brand")
@Getter
@Setter
@NoArgsConstructor
@Table(name = "BRAND")
@Data
public class BrandEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "BRAND_ID")
	private int brandId;

	@Access(AccessType.PROPERTY)
	@OneToMany(mappedBy = "brandId", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PriceEntity> prices;
}
