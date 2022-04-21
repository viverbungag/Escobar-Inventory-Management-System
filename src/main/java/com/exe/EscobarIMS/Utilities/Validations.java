package com.exe.EscobarIMS.Utilities;

import com.exe.EscobarIMS.MenuCategory.MenuCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class Validations {

    @Autowired
    private MenuCategoryRepository menuCategoryRepository;


    public boolean isMenuCategoryExisting(String menuCategoryName){
        return menuCategoryRepository.findByMenuCategoryName(menuCategoryName) != null;
    }

    public boolean hasExistingTableContents(JTable table){
        return table.getRowCount() > 0;
    }

    public boolean isNotSelectingATableRow(JTable table){
        return table.getSelectedRowCount() == 0;
    }

    public boolean isNotSelectingOneTableRow(JTable table){
        return table.getSelectedRowCount() != 1;
    }

    public boolean isTextFieldEmpty(JTextField textField){
        return textField.getText().isBlank();
    }
}
