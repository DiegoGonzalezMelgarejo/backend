package com.backend.infrastructure.configuration;

import com.backend.domain.port.PricePort;
import com.backend.domain.useCase.FindPriceByBrandProductAndDateUseCase;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {
    public FindPriceByBrandProductAndDateUseCase buildFindPriceByBrandProductAndDateUseCase(PricePort pricePort){
        return new FindPriceByBrandProductAndDateUseCase(pricePort);
    }
}