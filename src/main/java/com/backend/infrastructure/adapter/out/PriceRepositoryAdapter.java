package com.backend.infrastructure.adapter.out;

import com.backend.domain.port.PricePort;
import com.backend.infrastructure.persistence.entity.Prices;
import com.backend.infrastructure.persistence.repository.PriceJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
@RequiredArgsConstructor
public class PriceRepositoryAdapter  implements PricePort {
    private final PriceJPARepository priceJPARepository;
    @Override
    public List<Prices> findByBrandProductAndDate(Long brandId, Long productId, LocalDate productDate) {
        return priceJPARepository.findByBrandProductAndDate(brandId,productId,productDate);
    }
}
