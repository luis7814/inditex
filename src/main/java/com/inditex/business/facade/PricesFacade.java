package com.inditex.business.facade;

import com.inditex.business.data.dto.PricesDto;
import com.inditex.business.data.model.Price;
import com.inditex.business.service.PriceListService;
import com.inditex.business.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PricesFacade {

    @Autowired
    private PriceService priceService;

    @Autowired
    private PriceListService priceListService;

    public List<PricesDto> findByPrices(LocalDateTime applicationDate,
                                        Integer productId,
                                        Integer brandId) {

        return priceService.listByParameters(applicationDate, productId, brandId)
                .stream()
                .map(a -> PricesDto.builder()
                        .endDate(a.getEndDate())
                        .startDate(a.getStartDate())
                        .brandId(a.getBrandId())
                        .productId(a.getProductId())
                        .price(a.getPrice())
                        .priceList(
                                priceListService.findById(a.getPriceList()).getPriceList()
                        )
                        .build())
                .collect(Collectors.toList());

    }
}
