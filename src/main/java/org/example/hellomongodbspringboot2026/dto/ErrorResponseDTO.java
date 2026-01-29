package org.example.hellomongodbspringboot2026.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorResponseDTO {
    private String error;
    private String message;
    Integer errorCode;
}
