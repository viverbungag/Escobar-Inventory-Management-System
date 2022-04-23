package com.exe.EscobarIMS.MenuCategory;

import com.exe.EscobarIMS.MenuCategory.AddMenuCategory.AddMenuCategoryController;
import com.exe.EscobarIMS.MenuCategory.ViewEditDeleteMenuCategory.ViewEditDeleteMenuCategoryController;
import com.exe.EscobarIMS.Utilities.MessageDialogues;
import com.exe.EscobarIMS.Utilities.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import static com.exe.EscobarIMS.Utilities.Constants.TableColumnNumbers.MENU_CATEGORY_NAME_COLUMN_NUMBER;

@Component
public class MenuCategoryFormActions {

    @Autowired
    AddMenuCategoryController menuCategoryController;

    @Autowired
    ViewEditDeleteMenuCategoryController viewEditDeleteMenuCategoryController;

    @Autowired
    MessageDialogues messageDialogues;

    @Autowired
    Validations validations;

    @Autowired
    MenuCategoryValidations menuCategoryValidations;

    private JComboBox contentLimitComboBox;
    private JTextField currentPageNumberTextField;
    private JTextField menuCategoryNameTextField;
    private JButton previousButton;
    private JButton nextButton;
    private JTable menuCategoryTable;
    private JRadioButton ascendingRadioButton;
    private JRadioButton descendingRadioButton;
    private JComboBox sortingMethodComboBox;

    public void setContentLimitComboBox(JComboBox contentLimitComboBox) {
        this.contentLimitComboBox = contentLimitComboBox;
    }

    public void setCurrentPageNumberTextField(JTextField currentPageNumberTextField) {
        this.currentPageNumberTextField = currentPageNumberTextField;
    }

    public void setMenuCategoryNameTextField(JTextField menuCategoryNameTextField) {
        this.menuCategoryNameTextField = menuCategoryNameTextField;
    }

    public void setPreviousButton(JButton previousButton) {
        this.previousButton = previousButton;
    }

    public void setNextButton(JButton nextButton) {
        this.nextButton = nextButton;
    }

    public void setMenuCategoryTable(JTable menuCategoryTable) {
        this.menuCategoryTable = menuCategoryTable;
    }

    public void setAscendingRadioButton(JRadioButton ascendingRadioButton) {
        this.ascendingRadioButton = ascendingRadioButton;
    }

    public void setDescendingRadioButton(JRadioButton descendingRadioButton) {
        this.descendingRadioButton = descendingRadioButton;
    }

    public void setSortingMethodComboBox(JComboBox sortingMethodComboBox) {
        this.sortingMethodComboBox = sortingMethodComboBox;
    }

    private int getCurrentSelectedPageLimit(){
        return Integer.parseInt(contentLimitComboBox.getSelectedItem().toString());
    }

    private int getCurrentPageNumber(){
        return Integer.parseInt(currentPageNumberTextField.getText());
    }

    private void clearTextField(){
        menuCategoryNameTextField.setText("");
    }

    private void updateCurrentPageNumberTextField(int pageNumber){
        currentPageNumberTextField.setText(String.valueOf(pageNumber));
    }

    private void resetCurrentPageToDefault(){
        updateCurrentPageNumberTextField(1);
    }

    private int getNumberOfPages(){
        int selectedContentLimit = getCurrentSelectedPageLimit();
        int numberOfPages = viewEditDeleteMenuCategoryController.getTotalNumberOfPages(selectedContentLimit);
        return numberOfPages;
    }

    private void enableButtons(){
        previousButton.setEnabled(true);
        nextButton.setEnabled(true);
    }

    private void handleCurrentPageNumberTextFieldWrongInputs(){
        int currentPageNumber = getCurrentPageNumber();
        int lastPage = getNumberOfPages();

        if (currentPageNumber > lastPage){
            updateCurrentPageNumberTextField(lastPage);
        }

        if (currentPageNumber < 1){
            updateCurrentPageNumberTextField(1);
        }
    }

    private void updateStateOfButtons(){
        int numberOfPages = getNumberOfPages();
        int currentPageNumber = getCurrentPageNumber();
        enableButtons();

        if (currentPageNumber == 1){
            previousButton.setEnabled(false);
        }

        if (currentPageNumber == numberOfPages){
            nextButton.setEnabled(false);
        }
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

    private void disableSortRadioButtons(){
        ascendingRadioButton.setEnabled(false);
        descendingRadioButton.setEnabled(false);
    }

    private void enableSortRadioButtons(){
        ascendingRadioButton.setEnabled(true);
        descendingRadioButton.setEnabled(true);
    }

    private Sort getSortingComboBoxValue(){
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

    private Sort getSortingMethod(){
        Sort sortingComboBoxValue = getSortingComboBoxValue();
        if (ascendingRadioButton.isSelected()){
            return sortingComboBoxValue.ascending();
        }

        return sortingComboBoxValue.descending();
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

    private void updateTableContents(){

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

    public void currentPageNumberTextFieldKeyReleased(KeyEvent evt, JPanel paginationAndSortPanel) {
        if (validations.isEnterKeyPressed(evt)){
            paginationAndSortPanel.requestFocusInWindow();

        }
    }

    public void formWindowActivated(){
        updateTableContents();
        updateStateOfButtons();
    }

    public void formWindowOpened(JTable menuCategoryTable){
        menuCategoryTable.setDefaultEditor(Object.class, null);
    }

    public void contentLimitComboBoxActionPerformed(){
        updateCurrentPageNumberTextField(1);
        updateTableContents();
        updateStateOfButtons();
    }

    public void sortingMethodComboBoxActionPerformed(){
        updateTableContents();
        updateStateOfButtons();
    }

    public void ascendingRadioButtonItemStateChanged(){
        updateTableContents();
        updateStateOfButtons();
    }

    public void currentPageNumberTextFieldFocusLost() {

        if (validations.isTextFieldContainingOnlyNumericalValues(currentPageNumberTextField)){
            handleCurrentPageNumberTextFieldWrongInputs();
            updateTableContents();
            updateStateOfButtons();
        }else{
            resetCurrentPageToDefault();
            messageDialogues.showNumericValuesOnlyMessageDialogue();
        }
    }

    public void previousButtonActionPerformed() {

        int currentPageNumber = getCurrentPageNumber();
        updateCurrentPageNumberTextField(currentPageNumber - 1);
        updateTableContents();
        updateStateOfButtons();
    }

    public void nextButtonActionPerformed() {

        int currentPageNumber = getCurrentPageNumber();
        updateCurrentPageNumberTextField(currentPageNumber + 1);
        updateTableContents();
        updateStateOfButtons();
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
            menuCategoryController.addNewMenuCategory(newMenuCategoryName);
            messageDialogues.showSuccessfullyAddedMenuCategoryMessageDialogue();
        }
        clearTextField();
    }



}
