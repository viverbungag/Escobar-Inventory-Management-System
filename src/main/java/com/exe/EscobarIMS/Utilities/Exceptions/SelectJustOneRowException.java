package com.exe.EscobarIMS.Utilities.Exceptions;

import com.exe.EscobarIMS.Utilities.MessageDialogues;
import org.springframework.beans.factory.annotation.Autowired;

public class SelectJustOneRowException extends RuntimeException{

    @Autowired
    MessageDialogues messageDialogues;

    public SelectJustOneRowException() {
    }

    public SelectJustOneRowException(String message) {
        super(message);
    }
}
