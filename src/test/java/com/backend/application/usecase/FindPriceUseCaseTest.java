package com.backend.application.usecase;

import com.backend.domain.exception.PricesNotAvailableException;
import com.backend.domain.model.PriceDomain;
import com.backend.domain.port.PricePort;
import com.backend.infrastructure.adapter.in.dto.GetPriceByDateRequest;
import com.backend.infrastructure.persistence.entity.Prices;
import com.backend.util.Utilities;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.backend.infrastructure.util.constants.Constants.PRICES_AVAILABLE_ON_THAT_DATE;
import static com.backend.util.Utilities.buildPriceDomain;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class FindPriceUseCaseTest {
    private PricePort pricePort;

    private FindPriceByBrandProductAndDateUseCaseImpl findPriceUseCase;

    @BeforeEach
    public void initEach() {
        pricePort = mock(PricePort.class);
        findPriceUseCase = new FindPriceByBrandProductAndDateUseCaseImpl(pricePort);
    }

    @Test
    void shouldBeOk() throws ParseException {
        when(pricePort.findByBrandProductAndDate(any(), any(), any())).thenReturn(Collections.singletonList(buildPriceDomain()));
        PriceDomain price = findPriceUseCase.execute(any(), any(), any());
        Assert.assertNotNull(price);
        Assert.assertEquals(new BigDecimal("35.50"), price.getPrice());
    }

    @Test
    void shouldBeThrowsPricesNotAvailableException() {
        when(pricePort.findByBrandProductAndDate(any(), any(), any())).thenReturn(new ArrayList<>());

        try {
            findPriceUseCase.execute(any(), any(), any());
        } catch (PricesNotAvailableException exception) {
            assertEquals(PRICES_AVAILABLE_ON_THAT_DATE, exception.getMessage());
            verify(pricePort, times(1)).findByBrandProductAndDate(any(), any(), any());
        }
    }
}
