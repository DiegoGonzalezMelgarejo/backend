package com.backend.application.handler;

import com.backend.application.dto.PriceDto;
import com.backend.domain.model.PriceDomain;
import com.backend.domain.usecase.FindPriceByBrandProductAndDateUseCase;
import com.backend.infrastructure.util.Currency;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import static com.backend.util.Utilities.getPriceByDateRequest1;
import static com.backend.util.Utilities.getPriceDomain;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class FindPriceByBrandProductAndDateHandlerTest {
    private FindPriceByBrandProductAndDateHandler findPriceByBrandProductAndDateHandler;
    private FindPriceByBrandProductAndDateUseCase findPriceByBrandProductAndDateUseCase;

    @BeforeEach
    public void initEach() {
        findPriceByBrandProductAndDateUseCase = mock(FindPriceByBrandProductAndDateUseCase.class);
        findPriceByBrandProductAndDateHandler = new FindPriceByBrandProductAndDateHandler(findPriceByBrandProductAndDateUseCase);
    }

    @Test
    void shouldBeOkCase1() throws ParseException {
        PriceDomain price = getPriceDomain();
        price.setPrice(new BigDecimal(1));
        price.setBrandId(1l);
        price.setId(1l);
        price.setPriceList(1l);
        price.setEndDate(new Date());
        price.setStartDate(new Date());
        price.setPriority(1);
        price.setCurr(Currency.EUR);
        when(findPriceByBrandProductAndDateUseCase.execute(any(), any(), any())).thenReturn(price);
        PriceDto priceDto = findPriceByBrandProductAndDateHandler.execute(getPriceByDateRequest1());
        Assert.assertEquals(new BigDecimal(1), priceDto.getPrice());
    }


}
