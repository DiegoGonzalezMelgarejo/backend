package com.backend.infrastructure.adapter.in.rest;

import com.backend.application.dto.PriceDto;
import com.backend.application.handler.FindPriceByBrandProductAndDateHandler;
import com.backend.infrastructure.adapter.in.dto.GetPriceByDateRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.ParseException;

@RestController
@RequestMapping("/price")
public class PriceController {
    private final FindPriceByBrandProductAndDateHandler findPriceByBrandProductAndDateHandler;

    public PriceController(FindPriceByBrandProductAndDateHandler findPriceByBrandProductAndDateHandler) {
        this.findPriceByBrandProductAndDateHandler = findPriceByBrandProductAndDateHandler;
    }

    @PostMapping(
            path = "",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PriceDto> findPriceByBrandProductAndDate(@Valid @RequestBody GetPriceByDateRequest request) throws ParseException {
        return ResponseEntity.ok(findPriceByBrandProductAndDateHandler.execute(request));
    }
}
