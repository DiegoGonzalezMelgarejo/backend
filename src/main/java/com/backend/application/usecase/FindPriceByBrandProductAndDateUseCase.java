package com.backend.application.usecase;

import com.backend.domain.model.PriceDomain;

import java.time.LocalDateTime;

public interface FindPriceByBrandProductAndDateUseCase {
    PriceDomain execute(Long brandId, Long productId, LocalDateTime productDate) ;
}
