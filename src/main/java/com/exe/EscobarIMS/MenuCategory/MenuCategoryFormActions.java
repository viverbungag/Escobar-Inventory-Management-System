package com.exe.EscobarIMS.MenuCategory;

import com.exe.EscobarIMS.MenuCategory.AddMenuCategory.AddMenuCategoryController;
import com.exe.EscobarIMS.MenuCategory.ViewEditDeleteMenuCategory.ViewEditDeleteMenuCategoryController;
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

import static com.exe.EscobarIMS.Utilities.Constants.TableColumnNumbers.MENU_CATEGORY_NAME_COLUMN_NUMBER;

@Component
public class MenuCategoryFormActions extends SortAndPaginationMethods {

    @Autowired
    AddMenuCategoryController addMenuCategoryController;

    @Autowired
    ViewEditDeleteMenuCategoryController viewEditDeleteMenuCategoryController;

    @Autowired
    MessageDialogues messageDialogues;

    @Autowired
    Validations validations;

    @Autowired
    MenuCategoryValidations menuCategoryValidations;

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
        int numberOfPages = viewEditDeleteMenuCategoryController.getTotalNumberOfPages(selectedContentLimit);
        return numberOfPages;
    }

    private void addTableRow(MenuCategory menuCategory,
                             DefaultTableModel tableModel){
        String[] itemsOfRow = new String[]{
                menuCategory.getMenuCategoryName()};
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

        List<MenuCategory> menuCategories =  viewEditDeleteMenuCategoryController
                .getAllPagedMenuCategories(currentPageNumber, currentSelectedPageLimit, sort);

        for (MenuCategory menuCategory:menuCategories){
            addTableRow(menuCategory, tableModel);
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

    private void validateIfEditingIsAllowed(){
        menuCategoryValidations.validateIfEditingIsAllowed(menuCategoryNameTextField, menuCategoryTable);
    }

    private void validateIfDeletingIsAllowed(){
        menuCategoryValidations.validateIfDeletingIsAllowed(menuCategoryTable);
    }

    private void validateIfAddingIsAllowed(){
        menuCategoryValidations.validateIfAddingIsAllowed(menuCategoryNameTextField);
    }

    public void validateIfAddingOfMenuCategoryIsSuccessful(){
        validateIfAddingIsAllowed();
        String newMenuCategoryName = menuCategoryNameTextField.getText();
        addMenuCategoryController.addNewMenuCategory(newMenuCategoryName);
    }

    public void validateIfEditingOfMenuCategoryIsSuccessful(){
        validateIfEditingIsAllowed();
        String newMenuCategoryName = menuCategoryNameTextField.getText();
        String selectedMenuCategoryName = getSelectedRowMenuCategoryName();
        Long selectedMenuCategoryId = viewEditDeleteMenuCategoryController
                .findMenuCategoryIdByMenuCategoryName(selectedMenuCategoryName);

        viewEditDeleteMenuCategoryController
                .editMenuCategoryNameByMenuCategoryId(selectedMenuCategoryId,
                        newMenuCategoryName);
    }

    public void validateIfDeletingOfMenuCategoryIsSuccessful(){
        validateIfDeletingIsAllowed();
        List<String> menuCategoryNames = generateToBeDeletedList(menuCategoryTable);

        viewEditDeleteMenuCategoryController
                .deleteAllMenuCategoriesByName(menuCategoryNames);
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
        try{
            validateIfEditingOfMenuCategoryIsSuccessful();
            messageDialogues.showSuccessfullyEditedMenuCategoryMessageDialogue();
            clearTextField();
        }catch(FillOutAllTextFieldsException e){
            messageDialogues.showFillOutAllTextFieldsMessageDialogue();
        }catch(NameAlreadyExistsException e){
            messageDialogues.showNameAlreadyExistsMessageDialogue();
        }catch(SelectJustOneRowException e){
            messageDialogues.showSelectJustOneRowMessageDialogue();
        }
    }

    public void deleteMenuCategoryButtonActionPerformed() {
        try{
            validateIfDeletingOfMenuCategoryIsSuccessful();
            messageDialogues.showSuccessfullyDeletedMenuCategoryMessageDialogue();
            clearTextField();
        }catch(SelectOneOrMoreRowException e){
            messageDialogues.showSelectOneOrMoreRowMessageDialogue();
        }
    }

    public void addMenuCategoryButtonActionPerformed() {
        try{
            validateIfAddingOfMenuCategoryIsSuccessful();
            messageDialogues.showSuccessfullyAddedMenuCategoryMessageDialogue();
        }catch(NameAlreadyExistsException e){
            messageDialogues.showNameAlreadyExistsMessageDialogue();
        }catch(FillOutAllTextFieldsException e){
            messageDialogues.showFillOutAllTextFieldsMessageDialogue();
        }finally{
            clearTextField();
        }
    }



}
