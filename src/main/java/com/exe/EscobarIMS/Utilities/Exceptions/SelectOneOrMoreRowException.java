package com.exe.EscobarIMS.Utilities.Exceptions;

public class SelectOneOrMoreRowException extends RuntimeException{
    public SelectOneOrMoreRowException() {
    }

    public SelectOneOrMoreRowException(String message) {
        super(message);
    }
}
