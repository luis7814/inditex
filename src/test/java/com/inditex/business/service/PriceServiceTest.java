package com.inditex.business.service;

import com.inditex.business.data.model.Price;
import com.inditex.business.repository.PriceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class PriceServiceTest {
    @Mock
    PriceRepository priceRepository;
    @InjectMocks
    PriceService priceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListByParameters() {
        when(priceRepository.findByBrandIdAndProductId(anyInt(), anyInt())).thenReturn(returnPriceData());

        List<Price> result = priceService.listByParameters(LocalDateTime.of(2023, Month.JULY, 3, 17, 50, 6), Integer.valueOf(0), Integer.valueOf(0));
        Assertions.assertEquals(1, result.get(0).getId());
    }

    private List<Price> returnPriceData() {

        List<Price> prices = new ArrayList<>();
        Price price = new Price();
        price.setPriceList(1);
        price.setId(1);
        price.setBrandId(1);
        price.setProductId(1);
        price.setEndDate(LocalDateTime.of(2023, Month.SEPTEMBER, 3, 17, 50, 6));
        price.setStartDate(LocalDateTime.of(2023, Month.JUNE, 3, 17, 50, 6));

        prices.add(price);

        return prices;

    }
}

