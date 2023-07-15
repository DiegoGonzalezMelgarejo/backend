package com.backend.infrastructure.persistence.repository;

import com.backend.infrastructure.persistence.entity.Prices;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PriceJPARepository extends CrudRepository   {


    @Query("SELECT p FROM Prices p " +
            "WHERE  p.brand.id = ?1 AND p.productId = ?2 AND (?3 BETWEEN p.startDate AND p.endDate)" +
            "ORDER BY p.priority ASC")
    List<Prices> findByBrandProductAndDate(Long brandId, Long productId, LocalDate appDate);
}
