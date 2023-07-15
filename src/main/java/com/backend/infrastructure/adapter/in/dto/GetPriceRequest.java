package com.backend.infrastructure.adapter.in.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotNull;

@Data
public class GetPriceRequest {
    @NotNull(message = "Date cannot be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH.mm.ss")
    private String date;
    @NotNull(message = "Product id cannot be null")
    private Long idProduct;
    @NotNull(message = "Brand id cannot be null")
    private Long idBrand;
}
