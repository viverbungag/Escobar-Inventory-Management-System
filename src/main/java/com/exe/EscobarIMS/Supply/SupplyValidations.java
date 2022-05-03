package com.exe.EscobarIMS.Supply;

import com.exe.EscobarIMS.Utilities.Exceptions.*;
import com.exe.EscobarIMS.Utilities.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class SupplyValidations {

    @Autowired
    Validations validations;

    public void validateIfAddingIsAllowed(JTextField supplyNameTextField,
                                          JTextField minimumQuantityTextField){

        if (validations.isTextFieldEmpty(supplyNameTextField)){
            throw new FillOutAllTextFieldsException("The Supply Name Text Field is empty");
        }

        if (validations.isTextFieldEmpty(minimumQuantityTextField)){
            throw new FillOutAllTextFieldsException("The minimum quantity Text Field is empty");
        }

        if(!validations.isTextFieldContainingOnlyDecimalValues(minimumQuantityTextField)){
            throw new InvalidMinimumQuantityException("The String: " + minimumQuantityTextField.getText() + " - should just contain a decimal value");
        }

        if(validations.isTextFieldNegativeValue(minimumQuantityTextField)){
            throw new InvalidMinimumQuantityException("The Value: " + minimumQuantityTextField.getText() + " - should not be negative");
        }
    }

    public void validateIfEditingIsAllowed(JTextField supplyNameTextField, JTextField minimumQuantityTextField, JTable supplyTable){
        if (validations.isNotSelectingOneTableRow(supplyTable)){
            throw new SelectJustOneRowException("Number of selected rows: " + supplyTable.getSelectedRowCount() + ", Should be always 1");
        }

        if (validations.isTextFieldEmpty(supplyNameTextField)){
            throw new FillOutAllTextFieldsException("The Supply Name Text Field is empty");
        }

        if (validations.isTextFieldEmpty(minimumQuantityTextField)){
            throw new FillOutAllTextFieldsException("The minimum quantity Text Field is empty");
        }

        if(!validations.isTextFieldContainingOnlyDecimalValues(minimumQuantityTextField)){
            throw new InvalidMinimumQuantityException("The String: " + minimumQuantityTextField.getText() + " - should just contain a decimal value");
        }

        if(validations.isTextFieldNegativeValue(minimumQuantityTextField)){
            throw new InvalidMinimumQuantityException("The Value: " + minimumQuantityTextField.getText() + " - should not be negative");
        }
    }

}
