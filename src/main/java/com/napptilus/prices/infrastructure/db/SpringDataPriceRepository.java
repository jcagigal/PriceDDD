package com.napptilus.prices.infrastructure.db;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.napptilus.prices.infrastructure.db.dbo.PriceEntity;
import com.napptilus.prices.infrastructure.db.dbo.PriceEntityId;

import jakarta.validation.constraints.NotNull;

@Repository
public interface SpringDataPriceRepository extends JpaRepository<PriceEntity, PriceEntityId> {
	@Query("SELECT p FROM Price p WHERE (p.brandId.brandId = :brandId and p.productId = :productId and :date between p.startDate and p.endDate) ORDER BY p.priority DESC limit 1")
	PriceEntity findByBrandIdAndByProductIdAndByDate(@NotNull @Param("brandId") int brandId,
			@NotNull @Param("productId") Long productId, @NotNull @Param("date") LocalDateTime date);
}
