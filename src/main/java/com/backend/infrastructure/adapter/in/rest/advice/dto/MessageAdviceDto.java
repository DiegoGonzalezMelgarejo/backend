package com.backend.infrastructure.adapter.in.rest.advice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class MessageAdviceDto {
    private String message;
}
