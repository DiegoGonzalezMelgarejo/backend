package com.backend.application.handler;

import com.backend.domain.useCase.FindPriceByBrandProductAndDateUseCase;
import com.backend.infrastructure.persistence.entity.Prices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
public class FindPriceByBrandProductAndDateHandler {
    private final FindPriceByBrandProductAndDateUseCase  findPriceByBrandProductAndDateUseCase;

    public List<Object> execute(){
        Prices prueba=findPriceByBrandProductAndDateUseCase.execute(1l,35455l, LocalDate.parse("2020-06-14 00:00:00"));
        return null;
    }


}
