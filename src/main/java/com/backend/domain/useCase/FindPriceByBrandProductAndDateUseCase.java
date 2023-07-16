package com.backend.domain.useCase;

import com.backend.domain.exception.PricesNotAvailableException;
import com.backend.domain.model.Price;
import com.backend.domain.port.PricePort;
import com.backend.infrastructure.persistence.mapper.PriceDomainMapper;
import lombok.AllArgsConstructor;

import java.util.Date;
import static com.backend.infrastructure.util.constants.Constants.PRICES_AVAILABLE_ON_THAT_DATE;

@AllArgsConstructor
public class FindPriceByBrandProductAndDateUseCase {
    private PricePort pricePort;


    public Price execute(Long brandId, Long productId, Date productDate){
        return pricePort.findByBrandProductAndDate(brandId,productId,productDate).stream()
                .findFirst()
                .map(PriceDomainMapper.PRICE_DOMAIN_MAPPER::convertPriceEntityToPriceDomain)
                .orElseThrow(()-> {
                    throw new PricesNotAvailableException(PRICES_AVAILABLE_ON_THAT_DATE);
                });
    }


}
