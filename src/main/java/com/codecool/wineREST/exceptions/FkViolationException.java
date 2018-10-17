package com.codecool.wineREST.exceptions;

public class FkViolationException extends Exception {
    public FkViolationException(String message) {
        super(message);
    }
}
