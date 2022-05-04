package com.exe.EscobarIMS.Utilities;

import com.exe.EscobarIMS.MenuCategory.MenuCategoryRepository;
import com.exe.EscobarIMS.Supplier.SupplierRepository;
import com.exe.EscobarIMS.Supply.SupplyRepository;
import com.exe.EscobarIMS.SupplyCategory.SupplyCategoryRepository;
import com.exe.EscobarIMS.UnitOfMeasurement.UnitOfMeasurementRepository;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.KeyEvent;

@Component
public class Validations {

    @Autowired
    private MenuCategoryRepository menuCategoryRepository;

    @Autowired
    private SupplyCategoryRepository supplyCategoryRepository;

    @Autowired
    private UnitOfMeasurementRepository unitOfMeasurementRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplyRepository supplyRepository;

    @Autowired
    private MessageDialogues messageDialogues;


    public boolean isMenuCategoryExisting(String menuCategoryName){
        return menuCategoryRepository.findByMenuCategoryName(menuCategoryName) != null;
    }

    public boolean isSupplyCategoryExisting(String supplyCategoryName){
        return supplyCategoryRepository.findBySupplyCategoryName(supplyCategoryName) != null;
    }

    public boolean isUnitOfMeasurementExisting(String unitOfMeasurementName){
        return unitOfMeasurementRepository.findByUnitOfMeasurementName(unitOfMeasurementName) != null;
    }

    public boolean isSupplierExisting(String supplierName){
        return supplierRepository.findBySupplierName(supplierName) != null;
    }

    public boolean isSupplyExisting(String supplyName, String supplierName){
        Long supplierId = supplierRepository.findBySupplierName(supplierName).getSupplierId();
        return supplyRepository.findBySupplyNameAndCategory(supplyName, supplierId) != null;
    }

    public boolean hasExistingTableContents(JTable table){
        return table.getRowCount() > 0;
    }

    public boolean hasExistingComboBoxContents(JComboBox comboBox){
        return comboBox.getItemCount() > 0;
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

    public boolean isTextFieldContainingOnlyIntegerValues(JTextField textField) {
        if (NumberUtils.isParsable(textField.getText())){
            double num = Double.parseDouble(textField.getText());
            if (num == (int)num){
                return true;
            }
        }
        return false;
    }

    public boolean isTextFieldContainingOnlyPositiveIntegerValues(JTextField textField){
        return StringUtils.isNumeric(textField.getText());
    }

    public boolean isTextFieldContainingOnlyDecimalValues(JTextField textField){
        return NumberUtils.isParsable(textField.getText());
    }

    public boolean isTextFieldNegativeValue(JTextField textField){
        if (NumberUtils.isParsable(textField.getText())){
            double num = Double.parseDouble(textField.getText());
            if (num < 0){
                return true;
            }
        }
        return false;
    }

    public boolean isTextFieldEqualsToSelectedTableValue(JTextField textField, JTable table, int columnNumber){
        return textField.getText().equals(table.getValueAt(table.getSelectedRow(), columnNumber).toString());
    }

    public boolean isComboBoxEqualsToSelectedTableValue(JComboBox comboBox, JTable table, int columnNumber){
        return comboBox.getSelectedItem().toString().equals(table.getValueAt(table.getSelectedRow(), columnNumber).toString());
    }
}
