package com.exe.EscobarIMS.MenuCategory;

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
public class MenuCategoryValidations {

    @Autowired
    MessageDialogues messageDialogues;

    @Autowired
    Validations validations;

    public void validateIfEditingIsAllowed(JTextField menuCategoryNameTextField, JTable menuCategoryTable){
        String newMenuCategoryName = menuCategoryNameTextField.getText();
        if (validations.isNotSelectingOneTableRow(menuCategoryTable)){
            throw new SelectJustOneRowException("Number of rows: " + menuCategoryTable.getSelectedRowCount() + ", Should be not equals to 1");
        }

        if(validations.isTextFieldEmpty(menuCategoryNameTextField)) {
            throw new FillOutAllTextFieldsException("The Menu Category Name Text Field is empty");
        }

        if (validations.isMenuCategoryExisting(newMenuCategoryName)){
            throw new NameAlreadyExistsException("The Menu Category: " + newMenuCategoryName + " - is already existing");
        }

    }

    public void validateIfDeletingIsAllowed(JTable menuCategoryTable){
        if (validations.isNotSelectingATableRow(menuCategoryTable)){
            throw new SelectOneOrMoreRowException("Number of rows: " + menuCategoryTable.getSelectedRowCount() + ", Should be greater than 0");
        }
    }

    public void validateIfAddingIsAllowed(JTextField menuCategoryNameTextField){
        String newMenuCategoryName = menuCategoryNameTextField.getText();

        if (validations.isMenuCategoryExisting(newMenuCategoryName)){
            throw new NameAlreadyExistsException("The Menu Category: " + newMenuCategoryName + " - is already existing");
        }

        if (validations.isTextFieldEmpty(menuCategoryNameTextField)){
            throw new FillOutAllTextFieldsException("The Menu Category Name Text Field is empty");
        }

    }
}
