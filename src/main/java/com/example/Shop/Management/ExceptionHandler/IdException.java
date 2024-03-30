package com.example.Shop.Management.ExceptionHandler;

public class IdException extends Exception{
    private String errorMessage;

    public IdException() {
    }

    public IdException(String message, String errorMessage) {
        super(message);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
