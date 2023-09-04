package com.inditex.business.repository;

import com.inditex.business.data.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Integer> {

    List<Price> findByBrandIdAndProductId(Integer brandId, Integer productId);
}
