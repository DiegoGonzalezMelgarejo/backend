package com.backend.infrastructure.adapter.in.rest;

import com.backend.application.handler.FindPriceByBrandProductAndDateHandler;
import com.backend.infrastructure.adapter.in.dto.GetPriceRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/price")
public class PriceController {
    private final FindPriceByBrandProductAndDateHandler findPriceByBrandProductAndDateHandler;

    public PriceController(FindPriceByBrandProductAndDateHandler findPriceByBrandProductAndDateHandler) {
        this.findPriceByBrandProductAndDateHandler = findPriceByBrandProductAndDateHandler;
    }

    @PostMapping(
            path = "/pricerange",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public void OBTAINpRICE( @RequestBody  GetPriceRequest request) throws ParseException {
        findPriceByBrandProductAndDateHandler.execute(request);
    }
}
