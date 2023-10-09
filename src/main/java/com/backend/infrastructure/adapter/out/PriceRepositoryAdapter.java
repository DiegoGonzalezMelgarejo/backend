package com.backend.infrastructure.adapter.out;

import com.backend.domain.model.PriceDomain;
import com.backend.domain.port.PricePort;
import com.backend.infrastructure.persistence.entity.Prices;
import com.backend.infrastructure.persistence.repository.PriceJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PriceRepositoryAdapter  implements PricePort {
    private final PriceJPARepository priceJPARepository;
    @Override
    public List<PriceDomain> findByBrandProductAndDate(Long brandId, Long productId, LocalDateTime productDate) {
        return priceJPARepository.findByBrandProductAndDate(brandId,productId,productDate)
                .stream()
                .map(this::buildPriceDomain)
                .collect(Collectors.toList());
    }
    private  PriceDomain buildPriceDomain(Prices prices){
        return PriceDomain.builder()
                .curr(prices.getCurr())
                .priceList(prices.getPriceList())
                .price(prices.getPrice())
                .id(prices.getId())
                .endDate(prices.getEndDate())
                .brandId(prices.getBrand().getBrandId())
                .priority(prices.getPriority())
                .startDate(prices.getStartDate())
                .productId(prices.getProductId())
                .build();
    }
}
