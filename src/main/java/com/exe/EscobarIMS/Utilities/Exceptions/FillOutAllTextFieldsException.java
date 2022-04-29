package com.exe.EscobarIMS.Utilities.Exceptions;

import com.exe.EscobarIMS.Utilities.MessageDialogues;
import org.springframework.beans.factory.annotation.Autowired;

public class FillOutAllTextFieldsException extends RuntimeException{

    @Autowired
    MessageDialogues messageDialogues;

    public FillOutAllTextFieldsException() {
    }

    public FillOutAllTextFieldsException(String message) {
        super(message);
    }
}
