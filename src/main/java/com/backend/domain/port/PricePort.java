package com.backend.domain.port;

import com.backend.infrastructure.persistence.entity.Prices;
import java.time.LocalDateTime;
import java.util.List;

public interface PricePort {
    public List<Prices> findByBrandProductAndDate(Long brandId, Long productId, LocalDateTime productDate);
}
