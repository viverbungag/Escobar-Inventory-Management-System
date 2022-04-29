package com.exe.EscobarIMS.SupplyCategory;

import com.exe.EscobarIMS.Utilities.Exceptions.FillOutAllTextFieldsException;
import com.exe.EscobarIMS.Utilities.Exceptions.NameAlreadyExistsException;
import com.exe.EscobarIMS.Utilities.Exceptions.SelectJustOneRowException;
import com.exe.EscobarIMS.Utilities.Exceptions.SelectOneOrMoreRowException;
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

    public void validateIfEditingIsAllowed(JTextField supplyCategoryNameTextField, JTable supplyCategoryTable){
        String newSupplyCategoryName = supplyCategoryNameTextField.getText();

        if (validations.isNotSelectingOneTableRow(supplyCategoryTable)){
            throw new SelectJustOneRowException("Number of rows: " + supplyCategoryTable.getSelectedRowCount() + ", Should be not equals to 1");
        }

        if(validations.isTextFieldEmpty(supplyCategoryNameTextField)) {
            throw new FillOutAllTextFieldsException("The Supply Category Name Text Field is empty");
        }

        if (validations.isSupplyCategoryExisting(newSupplyCategoryName)){
            throw new NameAlreadyExistsException("The Supply Category: " + newSupplyCategoryName + " - is already existing");
        }
    }

    public void validateIfDeletingIsAllowed(JTable supplyCategoryTable){
        if (validations.isNotSelectingATableRow(supplyCategoryTable)){
            throw new SelectOneOrMoreRowException("Number of rows: " + supplyCategoryTable.getSelectedRowCount() + ", Should be greater than 0");
        }
    }

    public void validateIfAddingIsAllowed(JTextField supplyCategoryNameTextField){
        String newSupplyCategoryName = supplyCategoryNameTextField.getText();

        if (validations.isSupplyCategoryExisting(newSupplyCategoryName)){
            throw new NameAlreadyExistsException("The Supply Category: " + newSupplyCategoryName + " - is already existing");
        }

        if (validations.isTextFieldEmpty(supplyCategoryNameTextField)){
            throw new FillOutAllTextFieldsException("The Supply Category Name Text Field is empty");
        }
    }
}
