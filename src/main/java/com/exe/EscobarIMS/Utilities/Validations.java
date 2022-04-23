package com.exe.EscobarIMS.Utilities;

import com.exe.EscobarIMS.MenuCategory.MenuCategoryRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.KeyEvent;

@Component
public class Validations {

    @Autowired
    private MenuCategoryRepository menuCategoryRepository;

    @Autowired
    private MessageDialogues messageDialogues;


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

    public boolean isEnterKeyPressed(KeyEvent evt){
        return evt.getKeyCode() == KeyEvent.VK_ENTER;
    }

    public boolean isTextFieldContainingOnlyNumericalValues(JTextField textField) {
        return StringUtils.isNumeric(textField.getText());
    }
}
