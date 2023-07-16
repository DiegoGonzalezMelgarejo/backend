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
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

class PriceAdviceTest {

    @Mock
    private PriceController priceController;

    private PriceAdvice priceAdvice;
    @Mock
    private BindingResult bindingResult;

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

    @Test
    void handleMethodArgumentNotValid_ReturnsBadRequestWithErrors() {
        MockitoAnnotations.openMocks(this);

        MethodArgumentNotValidException exception = new MethodArgumentNotValidException(null, bindingResult);

        FieldError fieldError1 = new FieldError("yourObject", "fieldName1", "Error message 1");
        FieldError fieldError2 = new FieldError("yourObject", "fieldName2", "Error message 2");

        when(bindingResult.getAllErrors()).thenReturn(List.of(fieldError1, fieldError2));

        // Act
        ResponseEntity<Object> responseEntity = priceAdvice.handleMethodArgumentNotValid(exception);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());

        Map<String, String> expectedErrors = new HashMap<>();
        expectedErrors.put("fieldName1", "Error message 1");
        expectedErrors.put("fieldName2", "Error message 2");

        assertEquals(expectedErrors, responseEntity.getBody());
    }


}
