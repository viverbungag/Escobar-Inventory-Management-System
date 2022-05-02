package com.exe.EscobarIMS.Supply;

import com.exe.EscobarIMS.Supplier.Supplier;
import com.exe.EscobarIMS.Supplier.ViewEditDeleteSupplier.ViewEditDeleteSupplierController;
import com.exe.EscobarIMS.Supply.AddSupply.AddSupplyController;
import com.exe.EscobarIMS.Supply.ViewEditDeleteSupply.ViewEditDeleteSupplyController;
import com.exe.EscobarIMS.SupplyCategory.SupplyCategory;
import com.exe.EscobarIMS.SupplyCategory.ViewEditDeleteSupplyCategory.ViewEditDeleteSupplyCategoryController;
import com.exe.EscobarIMS.UnitOfMeasurement.UnitOfMeasurement;
import com.exe.EscobarIMS.UnitOfMeasurement.ViewEditDeleteUnitOfMeasurement.ViewEditDeleteUnitOfMeasurementController;
import com.exe.EscobarIMS.Utilities.MessageDialogues;
import com.exe.EscobarIMS.Utilities.SortAndPaginationMethods;
import com.exe.EscobarIMS.Utilities.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.List;

@Component
public class SupplyFormActions extends SortAndPaginationMethods {

    @Autowired
    AddSupplyController addSupplyController;

    @Autowired
    ViewEditDeleteSupplyController viewEditDeleteSupplyController;

    @Autowired
    ViewEditDeleteSupplierController viewEditDeleteSupplierController;

    @Autowired
    ViewEditDeleteUnitOfMeasurementController viewEditDeleteUnitOfMeasurementController;

    @Autowired
    ViewEditDeleteSupplyCategoryController viewEditDeleteSupplyCategoryController;

    @Autowired
    MessageDialogues messageDialogues;

    @Autowired
    Validations validations;

    @Autowired
    SupplyValidations supplyValidations;

    private JTextField supplyNameTextField;
    private JTextField minimumQuantityTextField;
    private JComboBox<String> supplierNameComboBox;
    private JComboBox<String> unitOfMeasurementNameComboBox;
    private JComboBox<String> supplyCategoryNameComboBox;
    private JTable supplyTable;
    private Boolean shouldUpdateTableContents = true;

    public void setSupplyNameTextField(JTextField supplyNameTextField) {
        this.supplyNameTextField = supplyNameTextField;
    }

    public void setMinimumQuantityTextField(JTextField minimumQuantityTextField) {
        this.minimumQuantityTextField = minimumQuantityTextField;
    }

    public void setSupplierNameComboBox(JComboBox<String> supplierNameComboBox) {
        this.supplierNameComboBox = supplierNameComboBox;
    }

    public void setUnitOfMeasurementNameComboBox(JComboBox<String> unitOfMeasurementNameComboBox) {
        this.unitOfMeasurementNameComboBox = unitOfMeasurementNameComboBox;
    }

    public void setSupplyCategoryNameComboBox(JComboBox<String> supplyCategoryNameComboBox) {
        this.supplyCategoryNameComboBox = supplyCategoryNameComboBox;
    }

    public void setSupplyTable(JTable supplyTable) {
        this.supplyTable = supplyTable;
    }

    private void resetShouldUpdateTableContentsVariableToDefault(){
        shouldUpdateTableContents = true;
    }

    private void resetComponentsValuesToDefault(){
        supplyNameTextField.setText("");
        minimumQuantityTextField.setText("");
        supplierNameComboBox.setSelectedItem("");
        unitOfMeasurementNameComboBox.setSelectedItem("");
        supplyCategoryNameComboBox.setSelectedItem("");
    }

    public void generateSupplierNameComboBoxItems(){
        List<Supplier> suppliers = viewEditDeleteSupplierController.getAllSupplier();
        for (Supplier supplier: suppliers){
            supplierNameComboBox.addItem(supplier.getSupplierName());
        }
    }

    public void generateUnitOfMeasurementNameComboBoxItems(){
        List<UnitOfMeasurement> unitOfMeasurements = viewEditDeleteUnitOfMeasurementController.getAllUnitOfMeasurement();
        for(UnitOfMeasurement unitOfMeasurement: unitOfMeasurements){
            unitOfMeasurementNameComboBox.addItem(unitOfMeasurement.getUnitOfMeasurementName());
        }
    }

    public void generateSupplyCategoryComboBoxItems(){
        List<SupplyCategory> supplyCategories = viewEditDeleteSupplyCategoryController.getAllSupplyCategories();
        for(SupplyCategory supplyCategory: supplyCategories){
            supplyCategoryNameComboBox.addItem(supplyCategory.getSupplyCategoryName());
        }
    }

    public void generateComboBoxContents(){
        generateSupplierNameComboBoxItems();
        generateUnitOfMeasurementNameComboBoxItems();
        generateSupplyCategoryComboBoxItems();
    }

    private void validateIfAddingIsAllowed(){
        supplyValidations.validateIfAddingIsAllowed(supplyNameTextField, minimumQuantityTextField);
    }

    private void validateIfEditingIsAllowed(){
        supplyValidations.validateIfEditingIsAllowed(supplyNameTextField, minimumQuantityTextField);
    }

    public void isAddSupplySuccessful(){
        validateIfAddingIsAllowed();
        String supplyName = supplyNameTextField.getText();
        Double minimumQuantity = Double.valueOf(minimumQuantityTextField.getText());
        String supplierName = supplierNameComboBox.getSelectedItem().toString();
        String unitOfMeasurementName = unitOfMeasurementNameComboBox.getSelectedItem().toString();
        String supplyCategoryName = supplyCategoryNameComboBox.getSelectedItem().toString();

        addSupplyController.addNewSupply(supplyName, supplierName, unitOfMeasurementName, supplyCategoryName, minimumQuantity);
    }

    public void isEditSupplySuccessful(){
        validateIfEditingIsAllowed();
        String supplyName = supplyNameTextField.getText();
        Double minimumQuantity = Double.valueOf(minimumQuantityTextField.getText());
        String supplierName = supplierNameComboBox.getSelectedItem().toString();
        String unitOfMeasurementName = unitOfMeasurementNameComboBox.getSelectedItem().toString();
        String supplyCategoryName = supplyCategoryNameComboBox.getSelectedItem().toString();


    }
}
