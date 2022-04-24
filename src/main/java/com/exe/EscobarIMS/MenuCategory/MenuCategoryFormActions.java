package com.exe.EscobarIMS.MenuCategory;

import com.exe.EscobarIMS.MenuCategory.AddMenuCategory.AddMenuCategoryController;
import com.exe.EscobarIMS.MenuCategory.ViewEditDeleteMenuCategory.ViewEditDeleteMenuCategoryController;
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

    private void generateTableContents(){
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

    private boolean isValidToEditMenuCategory(){
        return menuCategoryValidations.isValidToEditMenuCategory(menuCategoryNameTextField, menuCategoryTable);
    }

    private boolean isValidToDeleteMenuCategory(){
        return menuCategoryValidations.isValidToDeleteMenuCategory(menuCategoryTable);
    }

    private boolean isValidToAddMenuCategory(){
        return menuCategoryValidations.isValidToAddMenuCategory(menuCategoryNameTextField);
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
        String newMenuCategoryName = menuCategoryNameTextField.getText();
        if (isValidToEditMenuCategory()){
            String selectedMenuCategoryName = getSelectedRowMenuCategoryName();
            Long selectedMenuCategoryId = viewEditDeleteMenuCategoryController
                    .findMenuCategoryIdByMenuCategoryName(selectedMenuCategoryName);

            viewEditDeleteMenuCategoryController
                    .editMenuCategoryNameByMenuCategoryId(selectedMenuCategoryId,
                            newMenuCategoryName);

            messageDialogues.showSuccessfullyEditedMenuCategoryMessageDialogue();
            clearTextField();

        }
    }

    public void deleteMenuCategoryButtonActionPerformed() {

        if (isValidToDeleteMenuCategory()){
            List<String> menuCategoryNames = generateToBeDeletedList(menuCategoryTable);

            viewEditDeleteMenuCategoryController
                    .deleteAllMenuCategoriesByName(menuCategoryNames);

            messageDialogues.showSuccessfullyDeletedMenuCategoryMessageDialogue();
            clearTextField();
        }
    }

    public void addMenuCategoryButtonActionPerformed() {
        if (isValidToAddMenuCategory()){
            String newMenuCategoryName = menuCategoryNameTextField.getText();
            addMenuCategoryController.addNewMenuCategory(newMenuCategoryName);
            messageDialogues.showSuccessfullyAddedMenuCategoryMessageDialogue();
        }
        clearTextField();
    }



}
