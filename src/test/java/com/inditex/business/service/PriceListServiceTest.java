package com.inditex.business.service;

import com.inditex.business.data.model.PriceList;
import com.inditex.business.repository.PriceListRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class PriceListServiceTest {
    @Mock
    PriceListRepository priceListRepository;
    @InjectMocks
    PriceListService priceListService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        PriceList result = priceListService.findById(Integer.valueOf(0));
        Assertions.assertEquals(new PriceList(), result);
    }
}

