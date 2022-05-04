package com.exe.EscobarIMS.Utilities.Exceptions;

public class SupplyAlreadyExistException extends RuntimeException{

    public SupplyAlreadyExistException() {
    }

    public SupplyAlreadyExistException(String message) {
        super(message);
    }
}
