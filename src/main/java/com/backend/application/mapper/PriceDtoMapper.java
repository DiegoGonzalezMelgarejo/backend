package com.backend.application.mapper;

import com.backend.application.dto.PriceDto;

import com.backend.domain.model.PriceDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceDtoMapper {
    PriceDtoMapper PRICE_DOMAIN_MAPPER= Mappers.getMapper(PriceDtoMapper.class);
    @Mapping(source = "price.priceList",target = "fee")
    @Mapping(source = "dateAString",target = "dateApp")
    PriceDto converterPriceModelToPriceMapper(PriceDomain price, String dateAString);
}
