package com.backend.application.handler;

import com.backend.domain.useCase.FindPriceByBrandProductAndDateUseCase;
import com.backend.infrastructure.adapter.in.dto.GetPriceRequest;
import com.backend.infrastructure.persistence.entity.Prices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.ParseException;


import java.util.List;

import static com.backend.infrastructure.util.Utilities.coverterDate;

@Component
@AllArgsConstructor
public class FindPriceByBrandProductAndDateHandler {
    private final FindPriceByBrandProductAndDateUseCase  findPriceByBrandProductAndDateUseCase;

    public List<Object> execute(GetPriceRequest request) throws ParseException {


        Prices prueba=findPriceByBrandProductAndDateUseCase.execute(request.getIdBrand(), request.getIdProduct(),
                coverterDate(request.getDate()));
        return null;
    }


}
