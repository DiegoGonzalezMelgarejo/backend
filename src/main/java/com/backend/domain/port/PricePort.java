package com.backend.domain.port;

import com.backend.domain.model.PriceDomain;
import java.time.LocalDateTime;
import java.util.List;

public interface PricePort {
    List<PriceDomain> findByBrandProductAndDate(Long brandId, Long productId, LocalDateTime productDate);
}
