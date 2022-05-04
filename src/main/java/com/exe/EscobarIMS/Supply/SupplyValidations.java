package com.exe.EscobarIMS.Supply;

import com.exe.EscobarIMS.Utilities.Exceptions.*;
import com.exe.EscobarIMS.Utilities.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

import static com.exe.EscobarIMS.Utilities.Constants.TableColumnNumbers.SUPPLY_NAME_COLUMN_NUMBER;
import static com.exe.EscobarIMS.Utilities.Constants.TableColumnNumbers.SUPPLY_SUPPLIER_COLUMN_NUMBER;

@Component
public class SupplyValidations {

    @Autowired
    Validations validations;

    public void validateIfAddingIsAllowed(JTextField supplyNameTextField,
                                          JTextField minimumQuantityTextField,
                                          JComboBox supplierComboBox){
        String supplyName = supplyNameTextField.getText();
        String supplierName = supplierComboBox.getSelectedItem().toString();

        if (validations.isTextFieldEmpty(supplyNameTextField)){
            throw new FillOutAllTextFieldsException("The Supply Name Text Field is empty");
        }

        if (validations.isTextFieldEmpty(minimumQuantityTextField)){
            throw new FillOutAllTextFieldsException("The minimum quantity Text Field is empty");
        }

        if (validations.isSupplyExisting(supplyName, supplierName)){
            throw new SupplyAlreadyExistException("The Supply name: " + supplyNameTextField.getText() + " and the supplier: " + supplierComboBox.getSelectedItem() + " is already an existing supply");
        }

        if(!validations.isTextFieldContainingOnlyDecimalValues(minimumQuantityTextField)){
            throw new InvalidMinimumQuantityException("The String: " + minimumQuantityTextField.getText() + " - should just contain a decimal value");
        }

        if(validations.isTextFieldNegativeValue(minimumQuantityTextField)){
            throw new InvalidMinimumQuantityException("The Value: " + minimumQuantityTextField.getText() + " - should not be negative");
        }
    }

    public void validateIfEditingIsAllowed(JTextField supplyNameTextField,
                                           JTextField minimumQuantityTextField,
                                           JComboBox supplierComboBox,
                                           JTable supplyTable){
        String supplyName = supplyNameTextField.getText();
        String supplierName = supplierComboBox.getSelectedItem().toString();

        if (validations.isNotSelectingOneTableRow(supplyTable)){
            throw new SelectJustOneRowException("Number of selected rows: " + supplyTable.getSelectedRowCount() + ", Should be always 1");
        }

        if (validations.isTextFieldEmpty(supplyNameTextField)){
            throw new FillOutAllTextFieldsException("The Supply Name Text Field is empty");
        }

        if (validations.isTextFieldEmpty(minimumQuantityTextField)){
            throw new FillOutAllTextFieldsException("The minimum quantity Text Field is empty");
        }

        if(validations.isTextFieldEqualsToSelectedTableValue(supplyNameTextField,
                supplyTable, SUPPLY_NAME_COLUMN_NUMBER) &&
        validations.isComboBoxEqualsToSelectedTableValue(supplierComboBox,
                supplyTable, SUPPLY_SUPPLIER_COLUMN_NUMBER)){
            return;
        }

        if (validations.isSupplyExisting(supplyName, supplierName)){
            throw new SupplyAlreadyExistException("The Supply name: " + supplyNameTextField.getText() + " and the supplier: " + supplierComboBox.getSelectedItem() + " is already an existing supply");
        }

        if(!validations.isTextFieldContainingOnlyDecimalValues(minimumQuantityTextField)){
            throw new InvalidMinimumQuantityException("The String: " + minimumQuantityTextField.getText() + " - should just contain a decimal value");
        }

        if(validations.isTextFieldNegativeValue(minimumQuantityTextField)){
            throw new InvalidMinimumQuantityException("The Value: " + minimumQuantityTextField.getText() + " - should not be negative");
        }
    }

    public void validateIfDeletingIsAllowed(JTable supplyTable){
        if (validations.isNotSelectingATableRow(supplyTable)){
            throw new SelectOneOrMoreRowException("Number of rows: " + supplyTable.getSelectedRowCount() + ", Should be greater than 0");
        }
    }

}
