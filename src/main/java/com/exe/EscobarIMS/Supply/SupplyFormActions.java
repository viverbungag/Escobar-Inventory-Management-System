package com.exe.EscobarIMS.Supply;

import com.exe.EscobarIMS.Supplier.Supplier;
import com.exe.EscobarIMS.Supplier.ViewEditDeleteSupplier.ViewEditDeleteSupplierController;
import com.exe.EscobarIMS.Supply.AddSupply.AddSupplyController;
import com.exe.EscobarIMS.Supply.ViewEditDeleteSupply.ViewEditDeleteSupplyController;
import com.exe.EscobarIMS.SupplyCategory.SupplyCategory;
import com.exe.EscobarIMS.SupplyCategory.ViewEditDeleteSupplyCategory.ViewEditDeleteSupplyCategoryController;
import com.exe.EscobarIMS.UnitOfMeasurement.UnitOfMeasurement;
import com.exe.EscobarIMS.UnitOfMeasurement.ViewEditDeleteUnitOfMeasurement.ViewEditDeleteUnitOfMeasurementController;
import com.exe.EscobarIMS.Utilities.Exceptions.FillOutAllTextFieldsException;
import com.exe.EscobarIMS.Utilities.Exceptions.InvalidMinimumQuantityException;
import com.exe.EscobarIMS.Utilities.Exceptions.SelectJustOneRowException;
import com.exe.EscobarIMS.Utilities.Exceptions.SelectOneOrMoreRowException;
import com.exe.EscobarIMS.Utilities.MessageDialogues;
import com.exe.EscobarIMS.Utilities.SortAndPaginationMethods;
import com.exe.EscobarIMS.Utilities.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

import static com.exe.EscobarIMS.Utilities.Constants.TableColumnNumbers.*;

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
    SupplyRepository supplyRepository;

    @Autowired
    MessageDialogues messageDialogues;

    @Autowired
    Validations validations;

    @Autowired
    SupplyValidations supplyValidations;


    private JTextField supplyNameTextField;
    private JTextField minimumQuantityTextField;
    private JComboBox<String> supplierComboBox;
    private JComboBox<String> unitOfMeasurementComboBox;
    private JComboBox<String> supplyCategoryComboBox;
    private JTable supplyTable;
    private Boolean shouldUpdateTableContents = true;

    public void setSupplyNameTextField(JTextField supplyNameTextField) {
        this.supplyNameTextField = supplyNameTextField;
    }

    public void setMinimumQuantityTextField(JTextField minimumQuantityTextField) {
        this.minimumQuantityTextField = minimumQuantityTextField;
    }

    public void setSupplierComboBox(JComboBox<String> supplierComboBox) {
        this.supplierComboBox = supplierComboBox;
    }

    public void setUnitOfMeasurementComboBox(JComboBox<String> unitOfMeasurementComboBox) {
        this.unitOfMeasurementComboBox = unitOfMeasurementComboBox;
    }

    public void setSupplyCategoryComboBox(JComboBox<String> supplyCategoryComboBox) {
        this.supplyCategoryComboBox = supplyCategoryComboBox;
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
        supplierComboBox.setSelectedIndex(0);
        unitOfMeasurementComboBox.setSelectedIndex(0);
        supplyCategoryComboBox.setSelectedIndex(0);
    }

    @Override
    public int getNumberOfPages(){
        int selectedContentLimit = getCurrentSelectedPageLimit();
        int numberOfPages = viewEditDeleteSupplyController.getTotalNumberOfPages(selectedContentLimit);
        return numberOfPages;
    }

    public void generateSupplierNameComboBoxItems(){
        List<Supplier> suppliers = viewEditDeleteSupplierController.getAllSupplier();
        for (Supplier supplier: suppliers){
            supplierComboBox.addItem(supplier.getSupplierName());
        }
    }

    public void generateUnitOfMeasurementNameComboBoxItems(){
        List<UnitOfMeasurement> unitOfMeasurements = viewEditDeleteUnitOfMeasurementController.getAllUnitOfMeasurement();
        for(UnitOfMeasurement unitOfMeasurement: unitOfMeasurements){
            unitOfMeasurementComboBox.addItem(unitOfMeasurement.getUnitOfMeasurementName());
        }
    }

    public void generateSupplyCategoryNameComboBoxItems(){
        List<SupplyCategory> supplyCategories = viewEditDeleteSupplyCategoryController.getAllSupplyCategories();
        for(SupplyCategory supplyCategory: supplyCategories){
            supplyCategoryComboBox.addItem(supplyCategory.getSupplyCategoryName());
        }
    }

    public void generateComboBoxContents(){
        generateSupplierNameComboBoxItems();
        generateUnitOfMeasurementNameComboBoxItems();
        generateSupplyCategoryNameComboBoxItems();
    }

    public void updateComboBoxContents(){
        if (shouldUpdateTableContents){
            if (validations.hasExistingComboBoxContents(supplierComboBox)){
                supplierComboBox.removeAllItems();
            }

            if (validations.hasExistingComboBoxContents(unitOfMeasurementComboBox)){
                unitOfMeasurementComboBox.removeAllItems();
            }

            if (validations.hasExistingComboBoxContents(supplyCategoryComboBox)){
                supplyCategoryComboBox.removeAllItems();
            }

            generateComboBoxContents();
        }else{
            resetShouldUpdateTableContentsVariableToDefault();
        }
    }


    private void addTableRow(Supply supply,
                             DefaultTableModel tableModel){
        String[] itemsOfRow = new String[]{
                supply.getSupplyName(),
                supply.getSupplyCategoryName(),
                supply.getSupplierName(),
                String.valueOf(supply.getSupplyQuantity()),
                supply.getUnitOfMeasurementName(),
                String.valueOf(supply.getMinimumQuantity()),
                String.valueOf(supply.getInMinimumQuantity())};
        tableModel.addRow(itemsOfRow);
    }

    private void deleteExistingTableContents(){
        DefaultTableModel tableModel = (DefaultTableModel) supplyTable.getModel();
        tableModel.setRowCount(0);
    }

    @Override
    public Sort getSortingComboBoxValue(){
        String sortingMethodName = sortingMethodComboBox.getSelectedItem().toString();
        enableSortRadioButtons();

        switch(sortingMethodName){
            case "Supply Name":
                return Sort.by("supply.supply_name");
            case "Supply Category":
                return Sort.by("supply.supply_category");
            case "Supplier":
                return Sort.by("supplier.supplier_name");
            case "Quantity":
                return Sort.by("supply.supply_quantity");
            case "Unit of Measurement":
                return Sort.by("unit_of_measurement.unit_of_measurement_name");
            case "Minimum Quantity":
                return Sort.by("supply.minimum_quantity");
            case "Is below Minimum Quantity?":
                return Sort.by("supply.in_minimum_quantity");
            default:
                disableSortRadioButtons();
                return Sort.unsorted();
        }
    }

    public void generateTableContents(){
        DefaultTableModel tableModel = (DefaultTableModel) supplyTable.getModel();
        int currentPageNumber = getCurrentPageNumber();
        int currentSelectedPageLimit = getCurrentSelectedPageLimit();
        Sort sort = getSortingMethod();

        List<Supply> supplies =  viewEditDeleteSupplyController
                .getAllPagedSupplies(currentPageNumber, currentSelectedPageLimit, sort);

        for (Supply supply :supplies){
            addTableRow(supply, tableModel);
        }
    }

    private List<String> generateToBeDeletedList(){
        List<String> supplyNames = new ArrayList<>();
        int[] selectedTableRows = supplyTable.getSelectedRows();
        for (int selectedTableRow:selectedTableRows){

            String selectedSupplyName =  supplyTable
                    .getValueAt(selectedTableRow,
                            SUPPLY_NAME_COLUMN_NUMBER).toString();

            supplyNames.add(selectedSupplyName);
        }
        return supplyNames;
    }

    @Override
    public void updateTableContents(){
        if (shouldUpdateTableContents){
            if(validations.hasExistingTableContents(supplyTable)){
                deleteExistingTableContents();
            }
            generateTableContents();
        }else{
            resetShouldUpdateTableContentsVariableToDefault();
        }
    }

    private String getSelectedRowSupplyName(){
        int selectedTableRow = supplyTable.getSelectedRow();
        String selectedSupplyName = supplyTable
                .getValueAt(selectedTableRow,
                        SUPPLY_NAME_COLUMN_NUMBER)
                .toString();

        return selectedSupplyName;
    }

    private String getSelectedRowSupplyCategory(){
        int selectedTableRow = supplyTable.getSelectedRow();
        String selectedSupplyCategory = supplyTable
                .getValueAt(selectedTableRow,
                        SUPPLY_CATEGORY_COLUMN_NUMBER)
                .toString();

        return selectedSupplyCategory;
    }

    private String getSelectedRowSupplier(){
        int selectedTableRow = supplyTable.getSelectedRow();
        String selectedSupplier = supplyTable
                .getValueAt(selectedTableRow,
                        SUPPLY_SUPPLIER_COLUMN_NUMBER)
                .toString();

        return selectedSupplier;
    }

    private String getSelectedRowUnitOfMeasurement(){
        int selectedTableRow = supplyTable.getSelectedRow();
        String selectedUnitOfMeasurement = supplyTable
                .getValueAt(selectedTableRow,
                        SUPPLY_UNIT_OF_MEASUREMENT_COLUMN_NUMBER)
                .toString();

        return selectedUnitOfMeasurement;
    }

    private String getSelectedRowMinimumQuantity(){
        int selectedTableRow = supplyTable.getSelectedRow();
        String selectedMinimumQuantity = supplyTable
                .getValueAt(selectedTableRow,
                        SUPPLY_MINIMUM_QUANTITY_COLUMN_NUMBER)
                .toString();

        return selectedMinimumQuantity;
    }



    private void validateIfAddingIsAllowed(){
        supplyValidations.validateIfAddingIsAllowed(supplyNameTextField, minimumQuantityTextField);
    }

    private void validateIfEditingIsAllowed(){
        supplyValidations.validateIfEditingIsAllowed(supplyNameTextField, minimumQuantityTextField, supplyTable);
    }

    private void validateIfDeletingIsAllowed(){
        supplyValidations.validateIfDeletingIsAllowed(supplyTable);
    }

    public void validateIfAddingOfSupplyIsSuccessful(){
        validateIfAddingIsAllowed();
        String supplyName = supplyNameTextField.getText();
        Double minimumQuantity = Double.valueOf(minimumQuantityTextField.getText());
        String supplierName = supplierComboBox.getSelectedItem().toString();
        String unitOfMeasurementName = unitOfMeasurementComboBox.getSelectedItem().toString();
        String supplyCategoryName = supplyCategoryComboBox.getSelectedItem().toString();

        addSupplyController.addNewSupply(supplyName, supplierName, unitOfMeasurementName, supplyCategoryName, minimumQuantity);
    }

    public void validateIfEditingOfSupplyIsSuccessful(){
        validateIfEditingIsAllowed();
        String selectedSupplyName = getSelectedRowSupplyName();
        String newSupplyName = supplyNameTextField.getText();
        Double newMinimumQuantity = Double.valueOf(minimumQuantityTextField.getText());
        String newSupplierName = supplierComboBox.getSelectedItem().toString();
        String newUnitOfMeasurementName = unitOfMeasurementComboBox.getSelectedItem().toString();
        String newSupplyCategoryName = supplyCategoryComboBox.getSelectedItem().toString();

        viewEditDeleteSupplyController.editSupplyById(selectedSupplyName, newSupplyName, newMinimumQuantity, newSupplierName, newUnitOfMeasurementName, newSupplyCategoryName);
    }

    public void validateIfDeletingOfSupplyIsSuccessful(){
        validateIfDeletingIsAllowed();
        List<String> supplyNames = generateToBeDeletedList();

        viewEditDeleteSupplyController
                .deleteAllSupplyByName(supplyNames);
    }

    public void formWindowActivated(){
        updateTableContents();
        updateStateOfButtons();
        updateComboBoxContents();
    }
    public void formWindowOpened(JTable supplyTable){
        supplyTable.setDefaultEditor(Object.class, null);
    }

    public void supplyTableMousePressed(){
        String selectedSupplyName = getSelectedRowSupplyName();
        String selectedSupplyMinimumQuantity = getSelectedRowMinimumQuantity();
        String selectedSupplyCategory = getSelectedRowSupplyCategory();
        String selectedSupplier = getSelectedRowSupplier();
        String selectedUnitOfMeasurement = getSelectedRowUnitOfMeasurement();

        supplyNameTextField.setText(selectedSupplyName);
        minimumQuantityTextField.setText(selectedSupplyMinimumQuantity);
        supplyCategoryComboBox.setSelectedItem(selectedSupplyCategory);
        supplierComboBox.setSelectedItem(selectedSupplier);
        unitOfMeasurementComboBox.setSelectedItem(selectedUnitOfMeasurement);
    }

    public void editSupplyButtonActionPerformed(){
        try{
            validateIfEditingOfSupplyIsSuccessful();
            messageDialogues.showSuccessfullyEditedSupplyMessageDialogue();
            resetComponentsValuesToDefault();
        }catch(SelectJustOneRowException e){
            System.out.println(e.getMessage());
            messageDialogues.showSelectJustOneRowMessageDialogue();
        }catch(FillOutAllTextFieldsException e){
            System.out.println(e.getMessage());
            messageDialogues.showFillOutAllTextFieldsMessageDialogue();
        }catch(InvalidMinimumQuantityException e){
            System.out.println(e.getMessage());
            messageDialogues.showInvalidMinimumQuantityMessageDialogue();
        }
    }

    public void addSupplyButtonActionPerformed(){
        try{
            validateIfAddingOfSupplyIsSuccessful();
            messageDialogues.showSuccessfullyAddedSupplyMessageDialogue();
            resetComponentsValuesToDefault();
        }catch(FillOutAllTextFieldsException e){
            System.out.println(e.getMessage());
            messageDialogues.showFillOutAllTextFieldsMessageDialogue();
        }catch(InvalidMinimumQuantityException e){
            System.out.println(e.getMessage());
            messageDialogues.showInvalidMinimumQuantityMessageDialogue();
        }
    }

    public void deleteSupplyButtonActionPerformed(){
        try{
            validateIfDeletingOfSupplyIsSuccessful();
            messageDialogues.showSuccessfullyDeletedSupplyMessageDialogue();
            resetComponentsValuesToDefault();
        }catch(SelectOneOrMoreRowException e){
            System.out.println(e.getMessage());
            messageDialogues.showSelectOneOrMoreRowMessageDialogue();
        }
    }

}
