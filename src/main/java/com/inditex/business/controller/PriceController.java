package com.inditex.business.controller;

import com.inditex.business.data.dto.PricesDto;
import com.inditex.business.data.model.Price;
import com.inditex.business.facade.PricesFacade;
import com.inditex.business.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class PriceController {

    @Autowired
    private PricesFacade pricesFacade;

    @GetMapping("/price")
    public List<PricesDto> findByBrandIdAndProductId(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate,
                                                     @RequestParam Integer productId,
                                                     @RequestParam Integer brandId) {

        return pricesFacade.findByPrices(applicationDate, productId, brandId);

    }
}
