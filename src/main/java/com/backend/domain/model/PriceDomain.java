package com.backend.domain.model;

import com.backend.infrastructure.util.Currency;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PriceDomain {


    private Long id;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Long brandId;


    private Long priceList;


    private Long productId;


    private Integer priority;

    private BigDecimal price;


    private Currency curr;
}
