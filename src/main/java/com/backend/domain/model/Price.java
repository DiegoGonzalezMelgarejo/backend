package com.backend.domain.model;

import com.backend.infrastructure.util.Currency;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class Price {


    private Long id;

    private Date startDate;

    private Date endDate;

    private Long brandId;


    private Long priceList;


    private Long productId;


    private Integer priority;

    private BigDecimal price;


    private Currency curr;
}
