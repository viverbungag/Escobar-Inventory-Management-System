package com.exe.EscobarIMS.UnitOfMeasurement;

import com.exe.EscobarIMS.Utilities.MessageDialogues;
import com.exe.EscobarIMS.Utilities.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class UnitOfMeasurementValidations {

    @Autowired
    MessageDialogues messageDialogues;

    @Autowired
    Validations validations;

    public boolean isValidToEditMenuCategory(JTextField menuCategoryNameTextField, JTable menuCategoryTable){
        String newMenuCategoryName = menuCategoryNameTextField.getText();

        if (validations.isNotSelectingOneTableRow(menuCategoryTable)){
            messageDialogues.showSelectJustOneRowMessageDialogue();
            return false;
        }

        if(validations.isTextFieldEmpty(menuCategoryNameTextField)) {
            messageDialogues.showFillOutAllTextFieldsMessageDialogue();
            return false;
        }

        if (validations.isMenuCategoryExisting(newMenuCategoryName)){
            messageDialogues.showNameAlreadyExistsMessageDialogue();
            return false;
        }

        return true;
    }

    public boolean isValidToDeleteMenuCategory(JTable menuCategoryTable){
        if (validations.isNotSelectingATableRow(menuCategoryTable)){
            messageDialogues.showSelectOneOrMoreRowMessageDialogue();
            return false;
        }

        return true;
    }

    public boolean isValidToAddMenuCategory(JTextField menuCategoryNameTextField){
        String newMenuCategoryName = menuCategoryNameTextField.getText();

        if (validations.isMenuCategoryExisting(newMenuCategoryName)){
            messageDialogues.showNameAlreadyExistsMessageDialogue();
            return false;
        }

        if (validations.isTextFieldEmpty(menuCategoryNameTextField)){
            messageDialogues.showFillOutAllTextFieldsMessageDialogue();
            return false;
        }

        return true;
    }
}
