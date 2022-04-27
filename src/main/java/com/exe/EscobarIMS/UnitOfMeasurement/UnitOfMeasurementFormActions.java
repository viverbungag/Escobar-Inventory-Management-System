package com.exe.EscobarIMS.UnitOfMeasurement;

import com.exe.EscobarIMS.UnitOfMeasurement.AddUnitOfMeasurement.AddUnitOfMeasurementController;
import com.exe.EscobarIMS.UnitOfMeasurement.ViewEditDeleteUnitOfMeasurement.ViewEditDeleteUnitOfMeasurementController;
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

import static com.exe.EscobarIMS.Utilities.Constants.TableColumnNumbers.UNIT_OF_MEASUREMENT_NAME_COLUMN_NUMBER;

@Component
public class UnitOfMeasurementFormActions extends SortAndPaginationMethods {

    @Autowired
    AddUnitOfMeasurementController addUnitOfMeasurementController;

    @Autowired
    ViewEditDeleteUnitOfMeasurementController viewEditDeleteUnitOfMeasurementController;

    @Autowired
    MessageDialogues messageDialogues;

    @Autowired
    Validations validations;

    @Autowired
    UnitOfMeasurementValidations unitOfMeasurementValidations;

    private JTextField unitOfMeasurementNameTextField;
    private JTable unitOfMeasurementTable;
    private JTextField unitOfMeasurementAbbreviationTextField;

    public void setUnitOfMeasurementNameTextField(JTextField unitOfMeasurementNameTextField) {
        this.unitOfMeasurementNameTextField = unitOfMeasurementNameTextField;
    }

    public void setUnitOfMeasurementTable(JTable unitOfMeasurementTable) {
        this.unitOfMeasurementTable = unitOfMeasurementTable;
    }

    public void setUnitOfMeasurementAbbreviationTextField(JTextField unitOfMeasurementAbbreviationTextField) {
        this.unitOfMeasurementAbbreviationTextField = unitOfMeasurementAbbreviationTextField;
    }

    private void clearTextField(){
        unitOfMeasurementNameTextField.setText("");
    }

    @Override
    public int getNumberOfPages(){
        int selectedContentLimit = getCurrentSelectedPageLimit();
        int numberOfPages = viewEditDeleteUnitOfMeasurementController.getTotalNumberOfPages(selectedContentLimit);
        return numberOfPages;
    }

    private void addTableRow(UnitOfMeasurement unitOfMeasurement,
                             DefaultTableModel tableModel){
        String[] itemsOfRow = new String[]{
                unitOfMeasurement.getUnitOfMeasurementName(),
                unitOfMeasurement.getUnitOfMeasurementAbbreviation()};
        tableModel.addRow(itemsOfRow);
    }

    private void deleteExistingTableContents(){
        DefaultTableModel tableModel = (DefaultTableModel) unitOfMeasurementTable.getModel();
        tableModel.setRowCount(0);
    }

    @Override
    public Sort getSortingComboBoxValue(){
        String sortingMethodName = sortingMethodComboBox.getSelectedItem().toString();
        enableSortRadioButtons();

        switch(sortingMethodName){
            case "Unit of Measurement Name":
                return Sort.by("unit_of_measurement_name");
            case "Abbreviation":
                return Sort.by("unit_of_measurement_abbreviation");
            default:
                disableSortRadioButtons();
                return Sort.unsorted();
        }
    }

    public void generateTableContents(){
        DefaultTableModel tableModel = (DefaultTableModel) unitOfMeasurementTable.getModel();
        int currentPageNumber = getCurrentPageNumber();
        int currentSelectedPageLimit = getCurrentSelectedPageLimit();
        Sort sort = getSortingMethod();

        List<UnitOfMeasurement> unitOfMeasurements =  viewEditDeleteUnitOfMeasurementController
                .getAllPagedUnitOfMeasurement(currentPageNumber, currentSelectedPageLimit, sort);

        for (UnitOfMeasurement unitOfMeasurement :unitOfMeasurements){
            addTableRow(unitOfMeasurement, tableModel);
        }
    }

    private List<String> generateToBeDeletedList(JTable unitOfMeasurementTable){
        List<String> unitOfMeasurementNames = new ArrayList<String>();
        int[] selectedTableRows = unitOfMeasurementTable.getSelectedRows();
        for (int selectedTableRow:selectedTableRows){

            String selectedUnitOfMeasurementName =  unitOfMeasurementTable
                    .getValueAt(selectedTableRow,
                            UNIT_OF_MEASUREMENT_NAME_COLUMN_NUMBER).toString();

            unitOfMeasurementNames.add(selectedUnitOfMeasurementName);
        }
        return unitOfMeasurementNames;
    }

    @Override
    public void updateTableContents(){

        if(validations.hasExistingTableContents(unitOfMeasurementTable)){
            deleteExistingTableContents();
        }
        generateTableContents();
    }

    private String getSelectedRowUnitOfMeasurementName(){
        int selectedTableRow = unitOfMeasurementTable.getSelectedRow();
        String selectedUnitOfMeasurementName = unitOfMeasurementTable
                .getValueAt(selectedTableRow,
                        UNIT_OF_MEASUREMENT_NAME_COLUMN_NUMBER)
                .toString();

        return selectedUnitOfMeasurementName;
    }

    private boolean isValidToEditUnitOfMeasurement(){
        return unitOfMeasurementValidations.isValidToEditMenuCategory(unitOfMeasurementNameTextField, unitOfMeasurementAbbreviationTextField, unitOfMeasurementTable);
    }

    private boolean isValidToDeleteUnitOfMeasurement(){
        return unitOfMeasurementValidations.isValidToDeleteUnitOfMeasurement(unitOfMeasurementTable);
    }

    private boolean isValidToAddUnitOfMeasurement(){
        return unitOfMeasurementValidations.isValidToAddUnitOfMeasurement(unitOfMeasurementNameTextField, unitOfMeasurementAbbreviationTextField);
    }

    public boolean isAddUnitOfMeasurementSuccessful(){
        if (isValidToAddUnitOfMeasurement()) {
            String newMenuCategoryName = unitOfMeasurementNameTextField.getText();
            String newUAbbreviation = unitOfMeasurementAbbreviationTextField.getText();
            addUnitOfMeasurementController.addNewMenuCategory(newMenuCategoryName, newUAbbreviation);
            return true;
        }
        return false;
    }

    public boolean isEditUnitOfMeasurementSuccessful(){
        String newUnitOfMeasurementName = unitOfMeasurementNameTextField.getText();
        String newAbbreviation = unitOfMeasurementAbbreviationTextField.getText();
        if (isValidToEditUnitOfMeasurement()){
            String selectedUnitOfMeasurementName = getSelectedRowUnitOfMeasurementName();
            Long selectedUnitOfMeasurementId = viewEditDeleteUnitOfMeasurementController
                    .findUnitOfMeasurementIdByName(selectedUnitOfMeasurementName);

            viewEditDeleteUnitOfMeasurementController
                    .editUnitOfMeasurementNameById(selectedUnitOfMeasurementId,
                            newUnitOfMeasurementName, newAbbreviation);
            return true;
        }
        return false;
    }

    public boolean isDeleteUnitOfMeasurementSuccessful(){
        if (isValidToDeleteUnitOfMeasurement()){
            List<String> unitOfMeasurementNames = generateToBeDeletedList(unitOfMeasurementTable);

            viewEditDeleteUnitOfMeasurementController
                    .deleteAllUnitOfMeasurementByName(unitOfMeasurementNames);

            return true;
        }

        return false;
    }

    public void formWindowActivated(){
        updateTableContents();
        updateStateOfButtons();
    }

    public void formWindowOpened(JTable menuCategoryTable){
        menuCategoryTable.setDefaultEditor(Object.class, null);
    }

    public void menuCategoryTableMousePressed(){
        String selectedMenuCategoryName = getSelectedRowUnitOfMeasurementName();
        unitOfMeasurementNameTextField.setText(selectedMenuCategoryName);
    }

    public void editUnitOfMeasurementButtonActionPerformed() {
        if (isEditUnitOfMeasurementSuccessful()){
            messageDialogues.showSuccessfullyEditedMenuCategoryMessageDialogue();
            clearTextField();

        }
    }

    public void deleteUnitOfMeasurementButtonActionPerformed() {
        if (isDeleteUnitOfMeasurementSuccessful()){
            messageDialogues.showSuccessfullyDeletedMenuCategoryMessageDialogue();
            clearTextField();
        }
    }

    public void addUnitOfMeasurementButtonActionPerformed() {
        if (isAddUnitOfMeasurementSuccessful()){
            messageDialogues.showSuccessfullyAddedMenuCategoryMessageDialogue();
        }
        clearTextField();
    }



}
