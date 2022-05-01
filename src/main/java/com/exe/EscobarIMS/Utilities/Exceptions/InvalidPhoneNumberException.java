package com.exe.EscobarIMS.Utilities.Exceptions;

public class InvalidPhoneNumberException extends RuntimeException{

    public InvalidPhoneNumberException() {
    }

    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}
