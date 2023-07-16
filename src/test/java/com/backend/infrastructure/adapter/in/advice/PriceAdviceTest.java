package com.backend.infrastructure.adapter.in.advice;

import com.backend.domain.exception.PricesNotAvailableException;
import com.backend.infrastructure.adapter.in.rest.PriceController;
import com.backend.infrastructure.adapter.in.rest.advice.PriceAdvice;
import com.backend.infrastructure.adapter.in.rest.advice.dto.MessageAdviceDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

class PriceAdviceTest {

    @Mock
    private PriceController priceController;

    private PriceAdvice priceAdvice;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        priceAdvice = new PriceAdvice();
    }

    @Test
    void handlePricesNotAvailableException_ReturnsErrorResponse() throws ParseException {
        // Arrange
        PricesNotAvailableException exception = new PricesNotAvailableException("Prices not available.");

        when(priceController.findPriceByBrandProductAndDate(null)).thenThrow(exception);

        // Act
        ResponseEntity<MessageAdviceDto> response = priceAdvice.handlePricesNotAvailableException(exception);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Prices not available.", response.getBody().getMessage());
    }




}
