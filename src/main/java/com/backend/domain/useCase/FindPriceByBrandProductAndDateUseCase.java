package com.backend.domain.useCase;

import com.backend.domain.model.Price;
import com.backend.domain.port.PricePort;
import com.backend.infrastructure.persistence.entity.Prices;
import com.backend.infrastructure.persistence.mapper.PriceDomainMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;

@AllArgsConstructor
@RequiredArgsConstructor
public class FindPriceByBrandProductAndDateUseCase {
    private PricePort pricePort;

    public Price execute(Long brandId, Long productId, Date productDate){
        return pricePort.findByBrandProductAndDate(brandId,productId,productDate).stream()
                .sorted(OrderByPriority())
                .findFirst()
                .map(PriceDomainMapper.PRICE_DOMAIN_MAPPER::convertPriceEntityToPriceDomain)
                .orElseThrow();
    }
    private Comparator<Prices> OrderByPriority(){
        return Comparator.comparing(Prices::getPriority).reversed();
    }

}
