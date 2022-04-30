package com.exe.EscobarIMS.SupplyCategory;

import com.exe.EscobarIMS.SupplyCategory.AddSupplyCategory.AddSupplyCategoryController;
import com.exe.EscobarIMS.SupplyCategory.ViewEditDeleteSupplyCategory.ViewEditDeleteSupplyCategoryController;
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

import static com.exe.EscobarIMS.Utilities.Constants.TableColumnNumbers.SUPPLY_CATEGORY_NAME_COLUMN_NUMBER;

@Component
public class SupplyCategoryFormActions extends SortAndPaginationMethods {

    @Autowired
    AddSupplyCategoryController addSupplyCategoryController;

    @Autowired
    ViewEditDeleteSupplyCategoryController viewEditDeleteSupplyCategoryController;

    @Autowired
    MessageDialogues messageDialogues;

    @Autowired
    Validations validations;

    @Autowired
    SupplyCategoryValidations supplyCategoryValidations;

    private JTextField supplyCategoryNameTextField;
    private JTable supplyCategoryTable;


    public void setSupplyCategoryNameTextField(JTextField supplyCategoryNameTextField) {
        this.supplyCategoryNameTextField = supplyCategoryNameTextField;
    }

    public void setSupplyCategoryTable(JTable supplyCategoryTable) {
        this.supplyCategoryTable = supplyCategoryTable;
    }

    private void clearTextField(){
        supplyCategoryNameTextField.setText("");
    }

    @Override
    public int getNumberOfPages(){
        int selectedContentLimit = getCurrentSelectedPageLimit();
        int numberOfPages = viewEditDeleteSupplyCategoryController.getTotalNumberOfPages(selectedContentLimit);
        return numberOfPages;
    }

    private void addTableRow(SupplyCategory supplyCategory,
                             DefaultTableModel tableModel){
        String[] itemsOfRow = new String[]{
                supplyCategory.getSupplyCategoryName()};
        tableModel.addRow(itemsOfRow);
    }

    private void deleteExistingTableContents(){
        DefaultTableModel tableModel = (DefaultTableModel) supplyCategoryTable.getModel();
        tableModel.setRowCount(0);
    }

    @Override
    public Sort getSortingComboBoxValue(){
        String sortingMethodName = sortingMethodComboBox.getSelectedItem().toString();
        enableSortRadioButtons();

        switch(sortingMethodName){
            case "Supply Category Name":
                return Sort.by("supply_category_name");

            default:
                disableSortRadioButtons();
                return Sort.unsorted();
        }
    }

    public void generateTableContents(){
        DefaultTableModel tableModel = (DefaultTableModel) supplyCategoryTable.getModel();
        int currentPageNumber = getCurrentPageNumber();
        int currentSelectedPageLimit = getCurrentSelectedPageLimit();
        Sort sort = getSortingMethod();

        List<SupplyCategory> supplyCategories =  viewEditDeleteSupplyCategoryController
                .getAllPagedSupplyCategories(currentPageNumber, currentSelectedPageLimit, sort);

        for (SupplyCategory supplyCategory:supplyCategories){
            addTableRow(supplyCategory, tableModel);
        }
    }

    private List<String> generateToBeDeletedList(JTable supplyCategoryTable){
        List<String> supplyCategoryNames = new ArrayList<String>();
        int[] selectedTableRows = supplyCategoryTable.getSelectedRows();
        for (int selectedTableRow:selectedTableRows){

            String selectedSupplyCategoryName =  supplyCategoryTable
                    .getValueAt(selectedTableRow,
                            SUPPLY_CATEGORY_NAME_COLUMN_NUMBER).toString();

            supplyCategoryNames.add(selectedSupplyCategoryName);
        }
        return supplyCategoryNames;
    }

    @Override
    public void updateTableContents(){

        if(validations.hasExistingTableContents(supplyCategoryTable)){
            deleteExistingTableContents();
        }
        generateTableContents();
    }

    private String getSelectedRowSupplyCategoryName(){
        int selectedTableRow = supplyCategoryTable.getSelectedRow();
        String selectedSupplyCategoryName = supplyCategoryTable
                .getValueAt(selectedTableRow,
                        SUPPLY_CATEGORY_NAME_COLUMN_NUMBER)
                .toString();

        return selectedSupplyCategoryName;
    }

    private void validateIfEditingIsAllowed(){
        supplyCategoryValidations.validateIfEditingIsAllowed(supplyCategoryNameTextField, supplyCategoryTable);
    }

    private void validateIfDeletingIsAllowed(){
        supplyCategoryValidations.validateIfDeletingIsAllowed(supplyCategoryTable);
    }

    private void validateIfAddingIsAllowed(){
        supplyCategoryValidations.validateIfAddingIsAllowed(supplyCategoryNameTextField);
    }

    public void validateIfAddingOfSupplyCategoryIsSuccessful(){
        validateIfAddingIsAllowed();
        String newSupplyCategoryName = supplyCategoryNameTextField.getText();
        addSupplyCategoryController.addNewSupplyCategory(newSupplyCategoryName);

    }

    public void validateIfEditingOfSupplyCategoryIsSuccessful(){
        validateIfEditingIsAllowed();
        String newSupplyCategoryName = supplyCategoryNameTextField.getText();
        String selectedSupplyCategoryName = getSelectedRowSupplyCategoryName();
        Long selectedSupplyCategoryId = viewEditDeleteSupplyCategoryController
                .findSupplyCategoryIdBySupplyCategoryName(selectedSupplyCategoryName);

        viewEditDeleteSupplyCategoryController
                .editSupplyCategoryNameBySupplyCategoryId(selectedSupplyCategoryId,
                        newSupplyCategoryName);

    }

    public void validateIfDeletingOfSupplyCategoryIsSuccessful(){
        validateIfDeletingIsAllowed();
        List<String> supplyCategoryNames = generateToBeDeletedList(supplyCategoryTable);

        viewEditDeleteSupplyCategoryController
                .deleteAllSupplyCategoriesByName(supplyCategoryNames);

    }

    public void formWindowActivated(){
        updateTableContents();
        updateStateOfButtons();
    }

    public void formWindowOpened(JTable supplyCategoryTable){
        supplyCategoryTable.setDefaultEditor(Object.class, null);
    }

    public void supplyCategoryTableMousePressed(){
        String selectedSupplyCategoryName = getSelectedRowSupplyCategoryName();
        supplyCategoryNameTextField.setText(selectedSupplyCategoryName);
    }

    public void editSupplyCategoryButtonActionPerformed() {
        try{
            validateIfEditingOfSupplyCategoryIsSuccessful();
            messageDialogues.showSuccessfullyEditedSupplyCategoryMessageDialogue();
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

    public void deleteSupplyCategoryButtonActionPerformed() {
        try{
            validateIfDeletingOfSupplyCategoryIsSuccessful();
            messageDialogues.showSuccessfullyDeletedSupplyCategoryMessageDialogue();
            clearTextField();
        }catch(SelectOneOrMoreRowException e){
            System.out.println(e.getMessage());
            messageDialogues.showSelectOneOrMoreRowMessageDialogue();
        }

    }

    public void addSupplyCategoryButtonActionPerformed() {
        try {
            validateIfAddingOfSupplyCategoryIsSuccessful();
            messageDialogues.showSuccessfullyAddedSupplyCategoryMessageDialogue();
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
