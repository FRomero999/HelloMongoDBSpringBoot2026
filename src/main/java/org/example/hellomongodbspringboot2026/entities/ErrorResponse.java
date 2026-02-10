package org.example.hellomongodbspringboot2026.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private String error;
    private String info;
}
