package org.example.hellomongodbspringboot2026.controllers;

import org.example.hellomongodbspringboot2026.dto.ErrorResponseDTO;
import org.example.hellomongodbspringboot2026.exceptions.InvalidRequestException;
import org.example.hellomongodbspringboot2026.exceptions.TeamNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class NbaControllerAdvice {

    @ExceptionHandler(TeamNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleTeamNotFoundException(TeamNotFoundException e) {
        ErrorResponseDTO response = new ErrorResponseDTO("No hay equipo","El equipo que solictas no existe",404);

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<ErrorResponseDTO> handleInvalidRequestException(InvalidRequestException e) {
        ErrorResponseDTO response = new ErrorResponseDTO("Parámetro inválido",e.getMessage(),408);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

}
