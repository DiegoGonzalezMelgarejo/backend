package com.backend.application.usecase;

import com.backend.domain.exception.PricesNotAvailableException;
import com.backend.domain.model.PriceDomain;
import com.backend.domain.port.PricePort;
import com.backend.infrastructure.persistence.entity.Prices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static com.backend.infrastructure.util.constants.Constants.PRICES_AVAILABLE_ON_THAT_DATE;

@AllArgsConstructor
@Component
public class FindPriceByBrandProductAndDateUseCaseImpl implements  FindPriceByBrandProductAndDateUseCase {
    private PricePort pricePort;

    @Override
    public PriceDomain execute(Long brandId, Long productId, LocalDateTime productDate) {
        return pricePort.findByBrandProductAndDate(brandId, productId, productDate).stream()
                .findFirst()
                .map(this::buildPriceDomain)
                .orElseThrow(() ->  new PricesNotAvailableException(PRICES_AVAILABLE_ON_THAT_DATE));
    }

    private PriceDomain buildPriceDomain(Prices prices){
        return PriceDomain.builder()
                .brandId(prices.getBrand().getBrandId())
                .price(prices.getPrice())
                .priceList(prices.getPriceList())
                .priority(prices.getPriority())
                .curr(prices.getCurr())
                .productId(prices.getProductId())
                .id(prices.getId())
                .startDate(prices.getStartDate())
                .endDate(prices.getEndDate())
                .build();
    }

}
