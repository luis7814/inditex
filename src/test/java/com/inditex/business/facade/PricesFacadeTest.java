package com.inditex.business.facade;

import com.inditex.business.data.dto.PricesDto;
import com.inditex.business.data.model.Price;
import com.inditex.business.data.model.PriceList;
import com.inditex.business.service.PriceListService;
import com.inditex.business.service.PriceService;
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

class PricesFacadeTest {
    @Mock
    PriceService priceService;
    @Mock
    PriceListService priceListService;
    @InjectMocks
    PricesFacade pricesFacade;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByPrices() {
        when(priceService.listByParameters(any(), anyInt(), anyInt())).thenReturn(returnDataPrices());
        when(priceListService.findById(anyInt())).thenReturn(returnPriceList());

        List<PricesDto> result = pricesFacade.findByPrices(LocalDateTime.of(2023, Month.SEPTEMBER, 3, 17, 41, 0), Integer.valueOf(0), Integer.valueOf(0));
        Assertions.assertEquals(BigDecimal.valueOf(1), result.get(0).getPriceList());
    }

    private List<Price> returnDataPrices() {

        List<Price> prices = new ArrayList<>();
        Price price = new Price();
        price.setPriceList(1);
        price.setId(1);
        price.setBrandId(1);
        price.setProductId(1);

        prices.add(price);
        return prices;

    }

    private PriceList returnPriceList() {

        PriceList priceList = new PriceList();
        priceList.setId(1);
        priceList.setPriceList(BigDecimal.valueOf(1));

        return priceList;

    }
}
