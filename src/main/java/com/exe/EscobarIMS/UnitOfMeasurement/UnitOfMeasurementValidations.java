package com.exe.EscobarIMS.UnitOfMeasurement;

import com.exe.EscobarIMS.Utilities.Exceptions.FillOutAllTextFieldsException;
import com.exe.EscobarIMS.Utilities.Exceptions.NameAlreadyExistsException;
import com.exe.EscobarIMS.Utilities.Exceptions.SelectJustOneRowException;
import com.exe.EscobarIMS.Utilities.Exceptions.SelectOneOrMoreRowException;
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

    public void validateIfEditingIsAllowed(JTextField unitOfMeasurementNameTextField, JTextField unitOfMeasurementAbbreviationTextField, JTable unitOfMeasurementTable){
        String newUnitOfMeasurementName = unitOfMeasurementNameTextField.getText();

        if (validations.isNotSelectingOneTableRow(unitOfMeasurementTable)){
            throw new SelectJustOneRowException("Number of rows: " + unitOfMeasurementTable.getSelectedRowCount() + ", Should be not equals to 1");

        }

        if(validations.isTextFieldEmpty(unitOfMeasurementNameTextField)) {
            throw new FillOutAllTextFieldsException("The Unit of Measurement Name Text Field is empty");
        }

        if(validations.isTextFieldEmpty(unitOfMeasurementAbbreviationTextField)) {
            throw new FillOutAllTextFieldsException("The Unit of Measurement Abbreviation Text Field is empty");
        }

        if (validations.isTextFieldEqualsToSelectedTableValue(unitOfMeasurementNameTextField,
                unitOfMeasurementTable, UNIT_OF_MEASUREMENT_NAME_COLUMN_NUMBER)){
            return;
        }

        if (validations.isUnitOfMeasurementExisting(newUnitOfMeasurementName)){
            throw new NameAlreadyExistsException("The Unit of Measurement: " + newUnitOfMeasurementName + " - is already existing");
        }
    }

    public void validateIfDeletingIsAllowed(JTable unitOfMeasurementTable){
        if (validations.isNotSelectingATableRow(unitOfMeasurementTable)){
            throw new SelectOneOrMoreRowException("Number of rows: " + unitOfMeasurementTable.getSelectedRowCount() + ", Should be greater than 0");
        }
    }

    public void validateIfAddingIsAllowed(JTextField menuCategoryNameTextField, JTextField unitOfMeasurementAbbreviationTextField){
        String newUnitOfMeasurementName = menuCategoryNameTextField.getText();

        if (validations.isUnitOfMeasurementExisting(newUnitOfMeasurementName)){
            throw new NameAlreadyExistsException("The Unit of Measurement: " + newUnitOfMeasurementName + " - is already existing");
        }

        if (validations.isTextFieldEmpty(menuCategoryNameTextField)){
            throw new FillOutAllTextFieldsException("The Unit of Measurement Name Text Field is empty");
        }

        if (validations.isTextFieldEmpty(unitOfMeasurementAbbreviationTextField)){
            throw new FillOutAllTextFieldsException("The Unit of Measurement Abbreviation Text Field is empty");
        }


    }
}
