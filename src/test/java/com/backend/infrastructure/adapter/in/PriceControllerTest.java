package com.backend.infrastructure.adapter.in;

import com.backend.application.dto.PriceDto;
import com.backend.application.handler.FindPriceByBrandProductAndDateHandler;
import com.backend.domain.exception.PricesNotAvailableException;
import com.backend.infrastructure.adapter.in.dto.GetPriceByDateRequest;
import com.backend.infrastructure.adapter.in.rest.PriceController;
import com.backend.infrastructure.adapter.in.rest.advice.dto.MessageAdviceDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;

import static com.backend.util.Utilities.getPriceByDateRequest1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PriceControllerTest {
    @Mock
    private FindPriceByBrandProductAndDateHandler findPriceByBrandProductAndDateHandler;

    private PriceController priceController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        priceController = new PriceController(findPriceByBrandProductAndDateHandler);
    }

    @Test
    void findPriceByBrandProductAndDate_ValidRequest_ReturnsPriceDto() throws ParseException {
        // Arrange
        GetPriceByDateRequest request = getPriceByDateRequest1();

        PriceDto expectedDto = new PriceDto();

        when(findPriceByBrandProductAndDateHandler.execute(any())).thenReturn(expectedDto);

        ResponseEntity<PriceDto> response = priceController.findPriceByBrandProductAndDate(request);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}
