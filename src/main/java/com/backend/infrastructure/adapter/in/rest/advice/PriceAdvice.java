package com.backend.infrastructure.adapter.in.rest.advice;
import com.backend.application.exception.PricesException;
import com.backend.domain.exception.PricesNotAvailableException;
import com.backend.infrastructure.adapter.in.rest.advice.dto.MessageAdviceDto;
import com.backend.infrastructure.util.constants.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class PriceAdvice {
    private static final Map<Class<? extends Exception>, HttpStatus> RESPONSE_HTTP = new HashMap<>();

    public PriceAdvice() {
        RESPONSE_HTTP.put(PricesNotAvailableException.class, HttpStatus.NOT_FOUND);
        RESPONSE_HTTP.put(PricesException.class, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(PricesNotAvailableException.class)
    @ResponseBody
    public ResponseEntity<MessageAdviceDto> handlePricesNotAvailableException(PricesNotAvailableException exception) {
        return ResponseEntity.status(RESPONSE_HTTP.get(PricesNotAvailableException.class))
                .body(MessageAdviceDto.builder().message(exception.getMessage()).build());
    }

    @ExceptionHandler(PricesException.class)
    @ResponseBody
    public ResponseEntity<MessageAdviceDto> handlePricesException(PricesException exception) {
        return ResponseEntity.status(RESPONSE_HTTP.get(PricesException.class))
                .body(MessageAdviceDto.builder().message(exception.getMessage()).build());
    }

}