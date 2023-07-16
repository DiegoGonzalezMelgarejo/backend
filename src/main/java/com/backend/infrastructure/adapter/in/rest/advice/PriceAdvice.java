package com.backend.infrastructure.adapter.in.rest.advice;
import com.backend.domain.exception.PricesNotAvailableException;
import com.backend.infrastructure.adapter.in.rest.advice.dto.MessageAdviceDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
        RESPONSE_HTTP.put(MethodArgumentNotValidException.class, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(PricesNotAvailableException.class)
    @ResponseBody
    public ResponseEntity<MessageAdviceDto> handlePricesNotAvailableException(PricesNotAvailableException exception) {
        return ResponseEntity.status(RESPONSE_HTTP.get(PricesNotAvailableException.class))
                .body(MessageAdviceDto.builder().message(exception.getMessage()).build());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) ->{

            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
    }




}