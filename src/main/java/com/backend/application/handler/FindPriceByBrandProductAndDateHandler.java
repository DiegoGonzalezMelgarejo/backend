package com.backend.application.handler;

import com.backend.application.dto.PriceDto;
import com.backend.application.mapper.PriceDtoMapper;
import com.backend.domain.usecase.FindPriceByBrandProductAndDateUseCase;
import com.backend.infrastructure.adapter.in.dto.GetPriceByDateRequest;
import org.springframework.stereotype.Component;

import java.text.ParseException;


import java.util.Optional;


import static com.backend.infrastructure.util.Utilities.coverterDate;

@Component
public class FindPriceByBrandProductAndDateHandler {


    private final FindPriceByBrandProductAndDateUseCase findPriceByBrandProductAndDateUseCase;

    public FindPriceByBrandProductAndDateHandler(FindPriceByBrandProductAndDateUseCase findPriceByBrandProductAndDateUseCase) {
        this.findPriceByBrandProductAndDateUseCase = findPriceByBrandProductAndDateUseCase;
    }


    public PriceDto execute(GetPriceByDateRequest request) throws ParseException {


        return Optional.of(findPriceByBrandProductAndDateUseCase.execute(request.getIdBrand(), request.getIdProduct(),
                        coverterDate(request.getDate())))
                .map(price ->
                        PriceDtoMapper.PRICE_DOMAIN_MAPPER.converterPriceModelToPriceMapper(price, request.getDate()))
                .orElseThrow();
    }


}
