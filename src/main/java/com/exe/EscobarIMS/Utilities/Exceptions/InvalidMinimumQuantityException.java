package com.exe.EscobarIMS.Utilities.Exceptions;

public class InvalidMinimumQuantityException extends RuntimeException{

    public InvalidMinimumQuantityException() {
    }

    public InvalidMinimumQuantityException(String message) {
        super(message);
    }
}
