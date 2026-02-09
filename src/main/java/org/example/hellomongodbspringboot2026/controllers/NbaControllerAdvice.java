package org.example.hellomongodbspringboot2026.controllers;

import org.example.hellomongodbspringboot2026.entities.ErrorResponse;
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
    public ResponseEntity<ErrorResponse> handleTeamNotFound(TeamNotFoundException ex) {
        ErrorResponse err = new ErrorResponse("Team not found","404",ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(err);
    }

}
