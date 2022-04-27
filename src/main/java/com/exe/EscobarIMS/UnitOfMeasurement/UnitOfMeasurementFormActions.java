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

import static com.exe.EscobarIMS.Utilities.Constants.TableColumnNumbers.MENU_CATEGORY_NAME_COLUMN_NUMBER;

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

    private JTextField menuCategoryNameTextField;
    private JTable menuCategoryTable;

    public void setMenuCategoryNameTextField(JTextField menuCategoryNameTextField) {
        this.menuCategoryNameTextField = menuCategoryNameTextField;
    }

    public void setMenuCategoryTable(JTable menuCategoryTable) {
        this.menuCategoryTable = menuCategoryTable;
    }

    private void clearTextField(){
        menuCategoryNameTextField.setText("");
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
                unitOfMeasurement.getUnitOfMeasurementName()};
        tableModel.addRow(itemsOfRow);
    }

    private void deleteExistingTableContents(){
        DefaultTableModel tableModel = (DefaultTableModel) menuCategoryTable.getModel();
        tableModel.setRowCount(0);
    }

    @Override
    public Sort getSortingComboBoxValue(){
        String sortingMethodName = sortingMethodComboBox.getSelectedItem().toString();
        enableSortRadioButtons();

        switch(sortingMethodName){
            case "Menu Category Name":
                return Sort.by("menu_category_name");

            default:
                disableSortRadioButtons();
                return Sort.unsorted();
        }
    }

    public void generateTableContents(){
        DefaultTableModel tableModel = (DefaultTableModel) menuCategoryTable.getModel();
        int currentPageNumber = getCurrentPageNumber();
        int currentSelectedPageLimit = getCurrentSelectedPageLimit();
        Sort sort = getSortingMethod();

        List<UnitOfMeasurement> menuCategories =  viewEditDeleteUnitOfMeasurementController
                .getAllPagedMenuCategories(currentPageNumber, currentSelectedPageLimit, sort);

        for (UnitOfMeasurement unitOfMeasurement :menuCategories){
            addTableRow(unitOfMeasurement, tableModel);
        }
    }

    private List<String> generateToBeDeletedList(JTable menuCategoryTable){
        List<String> menuCategoryNames = new ArrayList<String>();
        int[] selectedTableRows = menuCategoryTable.getSelectedRows();
        for (int selectedTableRow:selectedTableRows){

            String selectedMenuCategoryName =  menuCategoryTable
                    .getValueAt(selectedTableRow,
                            MENU_CATEGORY_NAME_COLUMN_NUMBER).toString();

            menuCategoryNames.add(selectedMenuCategoryName);
        }
        return menuCategoryNames;
    }

    @Override
    public void updateTableContents(){

        if(validations.hasExistingTableContents(menuCategoryTable)){
            deleteExistingTableContents();
        }
        generateTableContents();
    }

    private String getSelectedRowMenuCategoryName(){
        int selectedTableRow = menuCategoryTable.getSelectedRow();
        String selectedMenuCategoryName = menuCategoryTable
                .getValueAt(selectedTableRow,
                        MENU_CATEGORY_NAME_COLUMN_NUMBER)
                .toString();

        return selectedMenuCategoryName;
    }

    private boolean isValidToEditMenuCategory(){
        return unitOfMeasurementValidations.isValidToEditMenuCategory(menuCategoryNameTextField, menuCategoryTable);
    }

    private boolean isValidToDeleteMenuCategory(){
        return unitOfMeasurementValidations.isValidToDeleteMenuCategory(menuCategoryTable);
    }

    private boolean isValidToAddMenuCategory(){
        return unitOfMeasurementValidations.isValidToAddMenuCategory(menuCategoryNameTextField);
    }

    public boolean isAddMenuCategorySuccessful(){
        if (isValidToAddMenuCategory()) {
            String newMenuCategoryName = menuCategoryNameTextField.getText();
            addUnitOfMeasurementController.addNewMenuCategory(newMenuCategoryName);
            return true;
        }
        return false;
    }

    public boolean isEditMenuCategorySuccessful(){
        String newMenuCategoryName = menuCategoryNameTextField.getText();
        if (isValidToEditMenuCategory()){
            String selectedMenuCategoryName = getSelectedRowMenuCategoryName();
            Long selectedMenuCategoryId = viewEditDeleteUnitOfMeasurementController
                    .findMenuCategoryIdByMenuCategoryName(selectedMenuCategoryName);

            viewEditDeleteUnitOfMeasurementController
                    .editMenuCategoryNameByMenuCategoryId(selectedMenuCategoryId,
                            newMenuCategoryName);
            return true;
        }
        return false;
    }

    public boolean isDeleteMenuCategorySuccessful(){
        if (isValidToDeleteMenuCategory()){
            List<String> menuCategoryNames = generateToBeDeletedList(menuCategoryTable);

            viewEditDeleteUnitOfMeasurementController
                    .deleteAllMenuCategoriesByName(menuCategoryNames);

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
        String selectedMenuCategoryName = getSelectedRowMenuCategoryName();
        menuCategoryNameTextField.setText(selectedMenuCategoryName);
    }

    public void editMenuCategoryButtonActionPerformed() {
        if (isEditMenuCategorySuccessful()){
            messageDialogues.showSuccessfullyEditedMenuCategoryMessageDialogue();
            clearTextField();

        }
    }

    public void deleteMenuCategoryButtonActionPerformed() {
        if (isDeleteMenuCategorySuccessful()){
            messageDialogues.showSuccessfullyDeletedMenuCategoryMessageDialogue();
            clearTextField();
        }
    }

    public void addMenuCategoryButtonActionPerformed() {
        if (isAddMenuCategorySuccessful()){
            messageDialogues.showSuccessfullyAddedMenuCategoryMessageDialogue();
        }
        clearTextField();
    }



}
