package org.example.hellomongodbspringboot2026.exceptions;

public class TeamNotFoundException extends RuntimeException {
    public TeamNotFoundException(String message) {
        super(message);
        System.out.println(message);
    }
}
