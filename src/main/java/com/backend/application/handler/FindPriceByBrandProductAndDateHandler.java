package com.backend.application.handler;

import com.backend.application.dto.PriceDto;
import com.backend.application.mapper.PriceDtoMapper;
import com.backend.application.usecase.FindPriceByBrandProductAndDateUseCase;

import com.backend.infrastructure.adapter.in.dto.GetPriceByDateRequest;
import org.springframework.stereotype.Component;


import java.util.Optional;

@Component
public class FindPriceByBrandProductAndDateHandler {


    private final FindPriceByBrandProductAndDateUseCase findPriceByBrandProductAndDateUseCase;

    public FindPriceByBrandProductAndDateHandler(FindPriceByBrandProductAndDateUseCase findPriceByBrandProductAndDateUseCase) {
        this.findPriceByBrandProductAndDateUseCase = findPriceByBrandProductAndDateUseCase;
    }


    public PriceDto execute(GetPriceByDateRequest request) {


        return Optional.of(findPriceByBrandProductAndDateUseCase.execute(request.getIdBrand(), request.getIdProduct(),
                        request.getDate()))
                .map(price ->
                        PriceDtoMapper.PRICE_DOMAIN_MAPPER.converterPriceModelToPriceMapper(price, request.getDate().toString()))
                .orElseThrow();
    }


}
