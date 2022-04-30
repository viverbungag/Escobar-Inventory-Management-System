package com.exe.EscobarIMS.UnitOfMeasurement;

import com.exe.EscobarIMS.UnitOfMeasurement.AddUnitOfMeasurement.AddUnitOfMeasurementController;
import com.exe.EscobarIMS.UnitOfMeasurement.ViewEditDeleteUnitOfMeasurement.ViewEditDeleteUnitOfMeasurementController;
import com.exe.EscobarIMS.Utilities.Exceptions.FillOutAllTextFieldsException;
import com.exe.EscobarIMS.Utilities.Exceptions.NameAlreadyExistsException;
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

import static com.exe.EscobarIMS.Utilities.Constants.TableColumnNumbers.UNIT_OF_MEASUREMENT_ABBREVIATION_COLUMN_NUMBER;
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
        unitOfMeasurementAbbreviationTextField.setText("");
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
    private String getSelectedRowUnitOfMeasurementAbbreviation(){
        int selectedTableRow = unitOfMeasurementTable.getSelectedRow();
        String selectedUnitOfMeasurementAbbreviation = unitOfMeasurementTable
                .getValueAt(selectedTableRow,
                        UNIT_OF_MEASUREMENT_ABBREVIATION_COLUMN_NUMBER)
                .toString();

        return selectedUnitOfMeasurementAbbreviation;
    }


    private void validateIfEditingIsAllowed(){
        unitOfMeasurementValidations.validateIfEditingIsAllowed(unitOfMeasurementNameTextField, unitOfMeasurementAbbreviationTextField, unitOfMeasurementTable);
    }

    private void validateIfDeletingIsAllowed(){
        unitOfMeasurementValidations.validateIfDeletingIsAllowed(unitOfMeasurementTable);
    }

    private void validateIfAddingIsAllowed(){
        unitOfMeasurementValidations.validateIfAddingIsAllowed(unitOfMeasurementNameTextField, unitOfMeasurementAbbreviationTextField);
    }

    public void isAddUnitOfMeasurementSuccessful(){
        validateIfAddingIsAllowed();
        String newMenuCategoryName = unitOfMeasurementNameTextField.getText();
        String newUAbbreviation = unitOfMeasurementAbbreviationTextField.getText();
        addUnitOfMeasurementController.addNewMenuCategory(newMenuCategoryName, newUAbbreviation);


    }

    public void isEditUnitOfMeasurementSuccessful(){
        String newUnitOfMeasurementName = unitOfMeasurementNameTextField.getText();
        String newAbbreviation = unitOfMeasurementAbbreviationTextField.getText();
        validateIfEditingIsAllowed();
        String selectedUnitOfMeasurementName = getSelectedRowUnitOfMeasurementName();
        Long selectedUnitOfMeasurementId = viewEditDeleteUnitOfMeasurementController
                .findUnitOfMeasurementIdByName(selectedUnitOfMeasurementName);

        viewEditDeleteUnitOfMeasurementController
                .editUnitOfMeasurementNameById(selectedUnitOfMeasurementId,
                        newUnitOfMeasurementName, newAbbreviation);


    }

    public void isDeleteUnitOfMeasurementSuccessful(){
        validateIfDeletingIsAllowed();
        List<String> unitOfMeasurementNames = generateToBeDeletedList(unitOfMeasurementTable);

        viewEditDeleteUnitOfMeasurementController
                .deleteAllUnitOfMeasurementByName(unitOfMeasurementNames);
    }

    public void formWindowActivated(){
        updateTableContents();
        updateStateOfButtons();
    }

    public void formWindowOpened(JTable unitOfMeasurementTable){
        unitOfMeasurementTable.setDefaultEditor(Object.class, null);
    }

    public void unitOfMeasurementTableMousePressed(){
        String selectedMenuCategoryName = getSelectedRowUnitOfMeasurementName();
        String selectedMenuCategoryAbbreviation = getSelectedRowUnitOfMeasurementAbbreviation();

        unitOfMeasurementNameTextField.setText(selectedMenuCategoryName);
        unitOfMeasurementAbbreviationTextField.setText(selectedMenuCategoryAbbreviation);
    }

    public void editUnitOfMeasurementButtonActionPerformed() {
        try{
            isEditUnitOfMeasurementSuccessful();
            messageDialogues.showSuccessfullyEditedUnitOfMeasurementMessageDialogue();
            clearTextField();
        }catch(SelectJustOneRowException e){
            System.out.println(e.getMessage());
            messageDialogues.showSelectJustOneRowMessageDialogue();
        }catch(FillOutAllTextFieldsException e){
            System.out.println(e.getMessage());
            messageDialogues.showFillOutAllTextFieldsMessageDialogue();
        }catch(NameAlreadyExistsException e){
            System.out.println(e.getMessage());
            messageDialogues.showNameAlreadyExistsMessageDialogue();
        }
    }

    public void deleteUnitOfMeasurementButtonActionPerformed() {
        try{
            isDeleteUnitOfMeasurementSuccessful();
            messageDialogues.showSuccessfullyDeletedUnitOfMeasurementMessageDialogue();
            clearTextField();
        }catch(SelectOneOrMoreRowException e){
            System.out.println(e.getMessage());
            messageDialogues.showSelectOneOrMoreRowMessageDialogue();
        }
    }

    public void addUnitOfMeasurementButtonActionPerformed() {
        try{
            isAddUnitOfMeasurementSuccessful();
            messageDialogues.showSuccessfullyAddedUnitOfMeasurementMessageDialogue();
            clearTextField();
        }catch(NameAlreadyExistsException e){
            System.out.println(e.getMessage());
            messageDialogues.showNameAlreadyExistsMessageDialogue();
        }catch(FillOutAllTextFieldsException e){
            System.out.println(e.getMessage());
            messageDialogues.showFillOutAllTextFieldsMessageDialogue();
        }

    }



}
