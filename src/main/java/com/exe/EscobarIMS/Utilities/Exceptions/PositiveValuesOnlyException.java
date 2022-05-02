package com.exe.EscobarIMS.Utilities.Exceptions;

public class PositiveValuesOnlyException extends RuntimeException{

    public PositiveValuesOnlyException() {
    }

    public PositiveValuesOnlyException(String message) {
        super(message);
    }
}
