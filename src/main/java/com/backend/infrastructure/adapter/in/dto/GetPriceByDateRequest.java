package com.backend.infrastructure.adapter.in.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetPriceByDateRequest {
    @NotNull(message = "Date cannot be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}-\\d{2}\\.\\d{2}\\.\\d{2}", message = "Invalid date format. Required format: yyyy-MM-dd-HH.mm.ss")
    private String date;
    @NotNull(message = "Product id cannot be null")
    @Min(value = 1,message = "must be greater than or equal to 1")
    private Long idProduct;
    @NotNull(message = "Brand id cannot be null")
    @Min(value = 1,message = "must be greater than or equal to 1")
    private Long idBrand;
}
