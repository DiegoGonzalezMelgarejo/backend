package com.backend.application.dto;


import lombok.Data;

import java.math.BigDecimal;
@Data
public class PriceDto {

    private Long productId;
    private Long brandId;
    private Long fee;
    private String dateApp;
    private BigDecimal price;
}
