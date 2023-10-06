package com.backend.infrastructure.persistence.repository;

import com.backend.infrastructure.persistence.entity.Prices;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceJPARepository extends CrudRepository<Prices,Long>   {


    @Query("SELECT p FROM Prices p " +
            "WHERE  p.brand.brandId = ?1 " +
            "AND p.productId = ?2 " +
            "AND (?3 BETWEEN p.startDate AND p.endDate)" +
            "ORDER BY p.priority DESC")
    List<Prices> findByBrandProductAndDate(Long brandId, Long productId, LocalDateTime appDate);
}
