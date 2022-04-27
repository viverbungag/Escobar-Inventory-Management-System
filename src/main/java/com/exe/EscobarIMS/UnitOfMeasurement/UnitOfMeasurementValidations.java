package com.exe.EscobarIMS.UnitOfMeasurement;

import com.exe.EscobarIMS.Utilities.MessageDialogues;
import com.exe.EscobarIMS.Utilities.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

import static com.exe.EscobarIMS.Utilities.Constants.TableColumnNumbers.UNIT_OF_MEASUREMENT_NAME_COLUMN_NUMBER;

@Component
public class UnitOfMeasurementValidations {

    @Autowired
    MessageDialogues messageDialogues;

    @Autowired
    Validations validations;

    public boolean isValidToEditUnitOfMeasurement(JTextField unitOfMeasurementNameTextField, JTextField unitOfMeasurementAbbreviationTextField, JTable unitOfMeasurementTable){
        String newUnitOfMeasurementName = unitOfMeasurementNameTextField.getText();

        if (validations.isNotSelectingOneTableRow(unitOfMeasurementTable)){
            messageDialogues.showSelectJustOneRowMessageDialogue();
            return false;
        }

        if(validations.isTextFieldEmpty(unitOfMeasurementNameTextField)) {
            messageDialogues.showFillOutAllTextFieldsMessageDialogue();
            return false;
        }

        if(validations.isTextFieldEmpty(unitOfMeasurementAbbreviationTextField)) {
            messageDialogues.showFillOutAllTextFieldsMessageDialogue();
            return false;
        }

        if (validations.isTextFieldEqualsToSelectedTableValue(unitOfMeasurementNameTextField,
                unitOfMeasurementTable, UNIT_OF_MEASUREMENT_NAME_COLUMN_NUMBER)){
            return true;
        }

        if (validations.isUnitOfMeasurementExisting(newUnitOfMeasurementName)){
            messageDialogues.showNameAlreadyExistsMessageDialogue();
            return false;
        }

        return true;
    }

    public boolean isValidToDeleteUnitOfMeasurement(JTable unitOfMeasurementTable){
        if (validations.isNotSelectingATableRow(unitOfMeasurementTable)){
            messageDialogues.showSelectOneOrMoreRowMessageDialogue();
            return false;
        }

        return true;
    }

    public boolean isValidToAddUnitOfMeasurement(JTextField menuCategoryNameTextField, JTextField unitOfMeasurementAbbreviationTextField){
        String newUnitOfMeasurementName = menuCategoryNameTextField.getText();

        if (validations.isUnitOfMeasurementExisting(newUnitOfMeasurementName)){
            messageDialogues.showNameAlreadyExistsMessageDialogue();
            return false;
        }

        if (validations.isTextFieldEmpty(menuCategoryNameTextField)){
            messageDialogues.showFillOutAllTextFieldsMessageDialogue();
            return false;
        }

        if (validations.isTextFieldEmpty(unitOfMeasurementAbbreviationTextField)){
            messageDialogues.showFillOutAllTextFieldsMessageDialogue();
            return false;
        }

        return true;
    }
}
