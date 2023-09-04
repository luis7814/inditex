package com.inditex.business.controller;

import com.inditex.business.data.dto.PricesDto;
import com.inditex.business.facade.PricesFacade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class PriceControllerTest {
    @Mock
    PricesFacade pricesFacade;
    @InjectMocks
    PriceController priceController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByBrandIdAndProductId() {
        when(pricesFacade.findByPrices(any(), anyInt(), anyInt())).thenReturn(returnPricesData());

        List<PricesDto> result = priceController.findByBrandIdAndProductId(LocalDateTime.of(2023, Month.SEPTEMBER, 3, 17, 36, 34), Integer.valueOf(0), Integer.valueOf(0));
        Assertions.assertEquals(1, result.get(0).getBrandId());
    }

    private List<PricesDto> returnPricesData() {

        PricesDto pricesDto = PricesDto.builder()
                .price(BigDecimal.valueOf(123))
                .startDate(LocalDateTime.of(2023, Month.SEPTEMBER, 3, 17, 36, 34))
                .endDate(LocalDateTime.of(2023, Month.SEPTEMBER, 3, 17, 36, 34))
                .priceList(BigDecimal.valueOf(34))
                .productId(1)
                .brandId(1)
                .build();

        List<PricesDto> pricesDtos = new ArrayList<>();
        pricesDtos.add(pricesDto);

        return pricesDtos;

    }
}
