package com.exe.EscobarIMS.Utilities.Exceptions;

import com.exe.EscobarIMS.Utilities.MessageDialogues;
import org.springframework.beans.factory.annotation.Autowired;

public class NameAlreadyExistsException extends RuntimeException{

    @Autowired
    MessageDialogues messageDialogues;

    public NameAlreadyExistsException() {
    }

    public NameAlreadyExistsException(String message) {
        super(message);
    }
}
