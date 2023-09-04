package com.inditex.business.service;

import com.inditex.business.data.model.Price;
import com.inditex.business.exception.NotFoundException;
import com.inditex.business.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    public List<Price> listByParameters(LocalDateTime applicationDate,
                                        Integer productId,
                                        Integer brandId) {

        List<Price> prices = priceRepository.findByBrandIdAndProductId(brandId, productId)
                .stream()
                .filter(a -> applicationDate.isAfter(a.getStartDate()) &&
                        applicationDate.isBefore(a.getEndDate()))
                .collect(Collectors.toList());

        if (prices == null || prices.isEmpty()) {
            throw new NotFoundException("La consulta no arrojó datos.");
        }

        return prices;

    }


}
