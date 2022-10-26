package com.anuta26.rent_center.api.exceptions;

public class NoEntityFoundException extends RuntimeException {
    public NoEntityFoundException(String message) {
        super(message);
    }

    public NoEntityFoundException() {
        super("No entity found.");
    }
}
