package com.inditex.business.service;

import com.inditex.business.data.model.PriceList;
import com.inditex.business.repository.PriceListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceListService {

    @Autowired
    private PriceListRepository priceListRepository;

    public PriceList findById(Integer id) {
        return priceListRepository.findById(id).orElse(new PriceList());
    }
}
