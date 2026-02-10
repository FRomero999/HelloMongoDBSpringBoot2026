package org.example.hellomongodbspringboot2026.controllers;

import org.example.hellomongodbspringboot2026.dto.ErrorResponseDTO;
import org.example.hellomongodbspringboot2026.exceptions.TeamNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class NbaControllerAdvice {

    @ExceptionHandler(TeamNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleTeamNotFound(TeamNotFoundException ex) {
        ErrorResponseDTO err = new ErrorResponseDTO("Team not found","El equipo solicitado no existe",404);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(err);
    }

}
