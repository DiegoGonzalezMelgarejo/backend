package com.backend.domain.usecase;

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
import java.util.List;

import static com.backend.infrastructure.util.constants.Constants.PRICES_AVAILABLE_ON_THAT_DATE;
import static com.backend.util.Utilities.coverterDate;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class FindPriceUseCaseTest {
    private PricePort pricePort;

    private FindPriceByBrandProductAndDateUseCase findPriceUseCase;

    @BeforeEach
    public void initEach() {
        pricePort = mock(PricePort.class);
        findPriceUseCase = new FindPriceByBrandProductAndDateUseCase(pricePort);
    }

    @Test
    void shouldBeOk() throws ParseException {
        GetPriceByDateRequest getPriceByDateRequest = Utilities.getPriceByDateRequest1();
        List<Prices> prices = Utilities.simulatedDatabaseQuery(getPriceByDateRequest.getDate(),
                getPriceByDateRequest.getIdProduct(), getPriceByDateRequest.getIdBrand());
        when(pricePort.findByBrandProductAndDate(any(), any(), any())).thenReturn(prices);
        PriceDomain price = findPriceUseCase.execute(any(), any(), any());
        Assert.assertNotNull(price);
        Assert.assertEquals(new BigDecimal("35.50"), price.getPrice());
    }

    @Test
    void shouldBeThrowsPricesNotAvailableException() {
        when(pricePort.findByBrandProductAndDate(any(), any(), any())).thenReturn(new ArrayList<>());

        // Act and Assert
        try {
            findPriceUseCase.execute(any(), any(), any());
        } catch (PricesNotAvailableException exception) {
            assertEquals(PRICES_AVAILABLE_ON_THAT_DATE, exception.getMessage());
            verify(pricePort, times(1)).findByBrandProductAndDate(any(), any(), any());

        }


    }
}
