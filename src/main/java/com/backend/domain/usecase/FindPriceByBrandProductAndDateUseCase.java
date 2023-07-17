package com.backend.domain.usecase;

import com.backend.domain.exception.PricesNotAvailableException;
import com.backend.domain.model.PriceDomain;
import com.backend.domain.port.PricePort;
import com.backend.infrastructure.persistence.mapper.PriceDomainMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static com.backend.infrastructure.util.constants.Constants.PRICES_AVAILABLE_ON_THAT_DATE;

@AllArgsConstructor
@Component
public class FindPriceByBrandProductAndDateUseCase {
    private PricePort pricePort;


    public PriceDomain execute(Long brandId, Long productId, LocalDateTime productDate) {
        return pricePort.findByBrandProductAndDate(brandId, productId, productDate).stream()
                .findFirst()
                .map(PriceDomainMapper.PRICE_DOMAIN_MAPPER::convertPriceEntityToPriceDomain)
                .orElseThrow(() ->  new PricesNotAvailableException(PRICES_AVAILABLE_ON_THAT_DATE));
    }


}
