package com.inditex.business.data.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class PricesDto implements Serializable {

    private Integer productId;
    private Integer brandId;
    private BigDecimal priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal price;


}
