package com.backend.domain.port;

import com.backend.infrastructure.persistence.entity.Prices;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface PricePort {
    public List<Prices> findByBrandProductAndDate(Long brandId, Long productId, Date productDate);
}
