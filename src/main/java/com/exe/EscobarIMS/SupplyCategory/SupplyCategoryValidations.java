package com.exe.EscobarIMS.SupplyCategory;

import com.exe.EscobarIMS.Utilities.MessageDialogues;
import com.exe.EscobarIMS.Utilities.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class SupplyCategoryValidations {

    @Autowired
    MessageDialogues messageDialogues;

    @Autowired
    Validations validations;

    public boolean isValidToEditSupplyCategory(JTextField supplyCategoryNameTextField, JTable supplyCategoryTable){
        String newSupplyCategoryName = supplyCategoryNameTextField.getText();

        if (validations.isNotSelectingOneTableRow(supplyCategoryTable)){
            messageDialogues.showSelectJustOneRowMessageDialogue();
            return false;
        }

        if(validations.isTextFieldEmpty(supplyCategoryNameTextField)) {
            messageDialogues.showFillOutAllTextFieldsMessageDialogue();
            return false;
        }

        if (validations.isSupplyCategoryExisting(newSupplyCategoryName)){
            messageDialogues.showNameAlreadyExistsMessageDialogue();
            return false;
        }

        return true;
    }

    public boolean isValidToDeleteSupplyCategory(JTable supplyCategoryTable){
        if (validations.isNotSelectingATableRow(supplyCategoryTable)){
            messageDialogues.showSelectOneOrMoreRowMessageDialogue();
            return false;
        }

        return true;
    }

    public boolean isValidToAddSupplyCategory(JTextField supplyCategoryNameTextField){
        String newSupplyCategoryName = supplyCategoryNameTextField.getText();

        if (validations.isSupplyCategoryExisting(newSupplyCategoryName)){
            messageDialogues.showNameAlreadyExistsMessageDialogue();
            return false;
        }

        if (validations.isTextFieldEmpty(supplyCategoryNameTextField)){
            messageDialogues.showFillOutAllTextFieldsMessageDialogue();
            return false;
        }

        return true;
    }
}
