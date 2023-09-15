package com.backend.util;

import com.backend.domain.model.PriceDomain;
import com.backend.infrastructure.adapter.in.dto.GetPriceByDateRequest;
import com.backend.infrastructure.persistence.entity.Brand;
import com.backend.infrastructure.persistence.entity.Prices;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.backend.infrastructure.util.Currency.EUR;

public class Utilities {

    public static List<Prices> simulatedDatabaseQuery(LocalDateTime appDate, Long productId, Long brandId) throws ParseException {
    return  List.of(getPrice1(),getPrice2(),getPrice3(),getPrice4()).stream()
            .filter(price -> price.getProductId().equals(productId))
            .filter(price -> price.getBrand().getBrandId().equals(brandId))
            .filter(price->appDate.isAfter(price.getStartDate()) && appDate.isBefore(price.getEndDate()))
            .sorted(OrderByPriority())
            .collect(Collectors.toList());
    }

    public static Prices getPrice1() throws ParseException {
        return Prices.builder().id(1l)
                .curr(EUR)
                .priceList(1l)
                .price(new BigDecimal("35.50"))
                .priority(0)
                .startDate(coverterDate("2020-06-14-00.00.00"))
                .productId(35455l)
                .endDate(coverterDate("2020-12-31-23.59.59"))
                .brand(Brand.builder().brandId(1l).name("ZARA").build())
                .build();
    }
    public static Prices getPrice2() throws ParseException {
        return Prices.builder().id(2l)
                .curr(EUR)
                .priceList(2l)
                .price(new BigDecimal("25.45"))
                .priority(1)
                .endDate(coverterDate("2020-06-14-18.30.00"))
                .productId(35455l)
                .startDate(coverterDate("2020-06-14-15.00.00"))
                .brand(Brand.builder().brandId(1l).name("ZARA").build())
                .build();
    }
    public static Prices getPrice3() throws ParseException {
        return Prices.builder().id(3l)
                .curr(EUR)
                .priceList(3l)
                .price(new BigDecimal("30.50"))
                .priority(1)
                .endDate(coverterDate("2020-06-15-11.00.00"))
                .productId(35455l)
                .startDate(coverterDate("2020-06-15-00.00.00"))
                .brand(Brand.builder().brandId(1l).name("ZARA").build())
                .build();
    }
    public static Prices getPrice4() throws ParseException {
        return Prices.builder().id(4l)
                .curr(EUR)
                .priceList(4l)
                .price(new BigDecimal("38.95"))
                .priority(1)
                .endDate(coverterDate("2020-12-31-23.59.59"))
                .productId(35455l)
                .startDate(coverterDate("2020-06-15-16.00.00"))
                .brand(Brand.builder().brandId(1l).name("ZARA").build())
                .build();
    }

    public static GetPriceByDateRequest getPriceByDateRequest1(){
    return GetPriceByDateRequest.builder()
            .idBrand(1l)
            .idProduct(35455l)
            .date(LocalDateTime.parse("2020-06-14-10.00.00",DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss")))
            .build();
    }
    public static GetPriceByDateRequest getPriceByDateRequest2(){
        return GetPriceByDateRequest.builder()
                .idBrand(1l)
                .idProduct(35455l)
                .date(LocalDateTime.parse("2020-06-14-16.00.00",DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss")))
                .build();
    }
    public static GetPriceByDateRequest getPriceByDateRequest3(){
        return GetPriceByDateRequest.builder()
                .idBrand(1l)
                .idProduct(35455l)
                .date(LocalDateTime.parse("2020-06-14-21.00.00",DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss")))
                .build();
    }
    public static GetPriceByDateRequest getPriceByDateRequest4(){
        return GetPriceByDateRequest.builder()
                .idBrand(1l)
                .idProduct(35455l)
                .date(LocalDateTime.parse("2020-06-15-10.00.00",DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss")))
                .build();
    }
    public static GetPriceByDateRequest getPriceByDateRequest5(){
        return GetPriceByDateRequest.builder()
                .idBrand(1l)
                .idProduct(35455l)
                .date(LocalDateTime.parse("2020-06-16-21.00.00",DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss")))
                .build();
    }
    public  static LocalDateTime coverterDate(String date) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);

        return dateTime;
    }
    private static Comparator<Prices> OrderByPriority(){
        return Comparator.comparing(Prices::getPriority).reversed();
    }


}
