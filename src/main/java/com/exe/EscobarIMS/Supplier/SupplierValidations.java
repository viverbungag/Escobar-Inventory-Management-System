package com.exe.EscobarIMS.Supplier;

import com.exe.EscobarIMS.Utilities.Exceptions.*;
import com.exe.EscobarIMS.Utilities.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

import static com.exe.EscobarIMS.Utilities.Constants.TableColumnNumbers.SUPPLIER_NAME_COLUMN_NUMBER;

@Component
public class SupplierValidations {

    @Autowired
    Validations validations;

    public void validateIfEditingIsAllowed(JTextField supplierNameTextField,
                                           JTextField supplierAddressTextField,
                                           JTextField supplierContactNumberTextField,
                                           JTextField supplierContactPersonTextField,
                                           JTable unitOfMeasurementTable){
        String newSupplierName = supplierNameTextField.getText();

        if (validations.isNotSelectingOneTableRow(unitOfMeasurementTable)){
            throw new SelectJustOneRowException("Number of selected rows: " + unitOfMeasurementTable.getSelectedRowCount() + ", Should be always 1");
        }

        if(validations.isTextFieldEmpty(supplierNameTextField)) {
            throw new FillOutAllTextFieldsException("The Supplier Name Text Field is empty");
        }

        if(validations.isTextFieldEmpty(supplierAddressTextField)) {
            throw new FillOutAllTextFieldsException("The Supplier Address Text Field is empty");
        }

        if (validations.isTextFieldEmpty(supplierContactNumberTextField)){
            throw new FillOutAllTextFieldsException("The Supplier Contact Number Text Field is empty");
        }

        if (validations.isTextFieldEmpty(supplierContactPersonTextField)){
            throw new FillOutAllTextFieldsException("The Supplier Contact Person Text Field is empty");
        }

        if (validations.isTextFieldEqualsToSelectedTableValue(supplierNameTextField,
                unitOfMeasurementTable, SUPPLIER_NAME_COLUMN_NUMBER)){
            return;
        }

        if (validations.isSupplierExisting(newSupplierName)){
            throw new NameAlreadyExistsException("The Supplier: " + newSupplierName + " - is already existing");
        }

        if (!validations.isTextFieldContainingOnlyPositiveIntegerValues(supplierContactNumberTextField)){
            throw new InvalidPhoneNumberException("The String: " + supplierContactNumberTextField.getText() + " - is not a valid phone number");
        }
    }

    public void validateIfDeletingIsAllowed(JTable supplierTable){
        if (validations.isNotSelectingATableRow(supplierTable)){
            throw new SelectOneOrMoreRowException("Number of rows: " + supplierTable.getSelectedRowCount() + ", Should be greater than 0");
        }
    }

    public void validateIfAddingIsAllowed(JTextField supplierNameTextField,
                                          JTextField supplierAddressTextField,
                                          JTextField supplierContactNumberTextField,
                                          JTextField supplierContactPersonTextField){
        String newSupplierName = supplierNameTextField.getText();

        if (validations.isTextFieldEmpty(supplierNameTextField)){
            throw new FillOutAllTextFieldsException("The Supplier Name Text Field is empty");
        }

        if (validations.isTextFieldEmpty(supplierAddressTextField)){
            throw new FillOutAllTextFieldsException("The Supplier Address Text Field is empty");
        }

        if (validations.isTextFieldEmpty(supplierContactNumberTextField)){
            throw new FillOutAllTextFieldsException("The Supplier Contact Number Text Field is empty");
        }

        if (validations.isTextFieldEmpty(supplierContactPersonTextField)){
            throw new FillOutAllTextFieldsException("The Supplier Contact Person Text Field is empty");
        }

        if (validations.isSupplierExisting(newSupplierName)){
            throw new NameAlreadyExistsException("The Supplier: " + newSupplierName + " - is already existing");
        }

        if (!validations.isTextFieldContainingOnlyPositiveIntegerValues(supplierContactNumberTextField)){
            throw new InvalidPhoneNumberException("The String: " + supplierContactNumberTextField.getText() + " - is not a valid phone number");
        }


    }
}
