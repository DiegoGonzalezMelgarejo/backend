package com.backend.application.handler;

import com.backend.application.dto.PriceDto;
import com.backend.domain.model.PriceDomain;
import com.backend.application.usecase.FindPriceByBrandProductAndDateUseCaseImpl;
import com.backend.infrastructure.util.Currency;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDateTime;
import static com.backend.util.Utilities.getPriceByDateRequest1;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindPriceByBrandProductAndDateHandlerTest {
    private FindPriceByBrandProductAndDateHandler findPriceByBrandProductAndDateHandler;
    private FindPriceByBrandProductAndDateUseCaseImpl findPriceByBrandProductAndDateUseCaseImpl;

    @BeforeEach
    public void initEach() {
        findPriceByBrandProductAndDateUseCaseImpl = mock(FindPriceByBrandProductAndDateUseCaseImpl.class);
        findPriceByBrandProductAndDateHandler = new FindPriceByBrandProductAndDateHandler(findPriceByBrandProductAndDateUseCaseImpl);
    }

    @Test
    void shouldBeOkCase1() throws ParseException {
        PriceDomain price =PriceDomain.builder()
                .price(new BigDecimal(1))
                .brandId(1l)
                .id(1l)
                .priceList(1l)
                .endDate(LocalDateTime.now())
                .startDate(LocalDateTime.now())
                .priority(1)
                .curr(Currency.EUR).build();
        when(findPriceByBrandProductAndDateUseCaseImpl.execute(any(), any(), any())).thenReturn(price);
        PriceDto priceDto = findPriceByBrandProductAndDateHandler.execute(getPriceByDateRequest1());
        Assert.assertEquals(new BigDecimal(1), priceDto.getPrice());
    }


}
