package com.anuta26.rent_center.api.exceptions;

public class IncorrectRequestException extends RuntimeException {
    public IncorrectRequestException() {
        super("Bad request");
    }

    public IncorrectRequestException(String message) {
        super(message);
    }
}
