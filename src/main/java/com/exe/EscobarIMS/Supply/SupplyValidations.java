package com.exe.EscobarIMS.Supply;

import com.exe.EscobarIMS.Utilities.Exceptions.FillOutAllTextFieldsException;
import com.exe.EscobarIMS.Utilities.Exceptions.NumericalValuesOnlyException;
import com.exe.EscobarIMS.Utilities.Exceptions.PositiveValuesOnlyException;
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
            throw new NumericalValuesOnlyException("The String: " + minimumQuantityTextField.getText() + " - should just contain a decimal value");
        }

        if(validations.isTextFieldNegativeValue(minimumQuantityTextField)){
            throw new PositiveValuesOnlyException("The Value: " + minimumQuantityTextField.getText() + " - should not be negative");
        }
    }

    public void validateIfEditingIsAllowed(JTextField supplyNameTextField, JTextField minimumQuantityTextField){
        if (validations.isTextFieldEmpty(supplyNameTextField)){
            throw new FillOutAllTextFieldsException("The Supply Name Text Field is empty");
        }

        if (validations.isTextFieldEmpty(minimumQuantityTextField)){
            throw new FillOutAllTextFieldsException("The minimum quantity Text Field is empty");
        }

        if(!validations.isTextFieldContainingOnlyDecimalValues(minimumQuantityTextField)){
            throw new NumericalValuesOnlyException("The String: " + minimumQuantityTextField.getText() + " - should just contain a decimal value");
        }

        if(validations.isTextFieldNegativeValue(minimumQuantityTextField)){
            throw new PositiveValuesOnlyException("The Value: " + minimumQuantityTextField.getText() + " - should not be negative");
        }
    }

}
