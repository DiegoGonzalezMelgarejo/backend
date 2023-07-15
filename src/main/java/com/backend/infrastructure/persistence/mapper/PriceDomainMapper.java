package com.backend.infrastructure.persistence.mapper;

import com.backend.domain.model.Price;
import com.backend.infrastructure.persistence.entity.Prices;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceDomainMapper {

    PriceDomainMapper PRICE_DOMAIN_MAPPER= Mappers.getMapper(PriceDomainMapper.class);
    @Mapping(source = "brand.brandId",target = "brandId")
    Price convertPriceEntityToPriceDomain(Prices prices);
}
