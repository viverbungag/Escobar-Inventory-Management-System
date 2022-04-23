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

    private int getCurrentSelectedPageLimit(JComboBox contentLimitComboBox){
        return Integer.parseInt(contentLimitComboBox.getSelectedItem().toString());
    }

    private int getCurrentPageNumber(JTextField currentPageNumberTextField){
        return Integer.parseInt(currentPageNumberTextField.getText());
    }

    private void clearTextField(JTextField menuCategoryNameTextField){
        menuCategoryNameTextField.setText("");
    }

    private void updateCurrentPageNumberTextField(int pageNumber,
                                                 JTextField currentPageNumberTextField){
        currentPageNumberTextField.setText(String.valueOf(pageNumber));
    }

    private void resetCurrentPageToDefault(JTextField currentPageNumberTextField){
        updateCurrentPageNumberTextField(1, currentPageNumberTextField);
    }

    private int getNumberOfPages(JComboBox contentLimitComboBox){
        int selectedContentLimit = getCurrentSelectedPageLimit(contentLimitComboBox);
        int numberOfPages = viewEditDeleteMenuCategoryController.getTotalNumberOfPages(selectedContentLimit);
        return numberOfPages;
    }

    private void enableButtons(JButton previousButton,
                              JButton nextButton){
        previousButton.setEnabled(true);
        nextButton.setEnabled(true);
    }

    private void handleCurrentPageNumberTextFieldWrongInputs(JTextField currentPageNumberTextField,
                                                             JComboBox contentLimitComboBox){
        int currentPageNumber = getCurrentPageNumber(currentPageNumberTextField);
        int lastPage = getNumberOfPages(contentLimitComboBox);

        if (currentPageNumber > lastPage){
            updateCurrentPageNumberTextField(lastPage, currentPageNumberTextField);
        }

        if (currentPageNumber < 1){
            updateCurrentPageNumberTextField(1, currentPageNumberTextField);
        }
    }

    private void updateStateOfButtons(JButton previousButton,
                                     JButton nextButton,
                                     JTextField currentPageNumberTextField,
                                     JComboBox contentLimitComboBox){

        int numberOfPages = getNumberOfPages(contentLimitComboBox);
        int currentPageNumber = getCurrentPageNumber(currentPageNumberTextField);
        enableButtons(previousButton, nextButton);

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

    private void deleteExistingTableContents(JTable menuCategoryTable){
        DefaultTableModel tableModel = (DefaultTableModel) menuCategoryTable.getModel();
        tableModel.setRowCount(0);
    }

    private void disableSortRadioButtons(JRadioButton ascendingRadioButton,
                                        JRadioButton descendingRadioButton){

        ascendingRadioButton.setEnabled(false);
        descendingRadioButton.setEnabled(false);
    }

    private void enableSortRadioButtons(JRadioButton ascendingRadioButton,
                                       JRadioButton descendingRadioButton){

        ascendingRadioButton.setEnabled(true);
        descendingRadioButton.setEnabled(true);
    }

    private Sort getSortingComboBoxValue(JComboBox sortingMethodComboBox,
                                        JRadioButton ascendingRadioButton,
                                        JRadioButton descendingRadioButton){

        String sortingMethodName = sortingMethodComboBox.getSelectedItem().toString();
        enableSortRadioButtons(ascendingRadioButton, descendingRadioButton);

        switch(sortingMethodName){
            case "Menu Category Name":
                return Sort.by("menu_category_name");

            default:
                disableSortRadioButtons(ascendingRadioButton, descendingRadioButton);
                return Sort.unsorted();
        }
    }

    private Sort getSortingMethod(JComboBox sortingMethodComboBox,
                                 JRadioButton ascendingRadioButton,
                                 JRadioButton descendingRadioButton){

        Sort sortingComboBoxValue = getSortingComboBoxValue(sortingMethodComboBox, ascendingRadioButton, descendingRadioButton);

        if (ascendingRadioButton.isSelected()){
            return sortingComboBoxValue.ascending();
        }

        return sortingComboBoxValue.descending();
    }

    private void generateTableContents(JTable menuCategoryTable,
                                       JTextField currentPageNumberTextField,
                                       JComboBox contentLimitComboBox,
                                       JComboBox sortingMethodComboBox,
                                       JRadioButton ascendingRadioButton,
                                       JRadioButton descendingRadioButton){

        DefaultTableModel tableModel = (DefaultTableModel) menuCategoryTable.getModel();
        int currentPageNumber = getCurrentPageNumber(currentPageNumberTextField);
        int currentSelectedPageLimit = getCurrentSelectedPageLimit(contentLimitComboBox);
        Sort sort = getSortingMethod(sortingMethodComboBox, ascendingRadioButton, descendingRadioButton);

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

    private void updateTableContents(JTable menuCategoryTable,
                                     JTextField currentPageNumberTextField,
                                     JComboBox contentLimitComboBox,
                                     JComboBox sortingMethodComboBox,
                                     JRadioButton ascendingRadioButton,
                                     JRadioButton descendingRadioButton){

        if(validations.hasExistingTableContents(menuCategoryTable)){
            deleteExistingTableContents(menuCategoryTable);
        }

        generateTableContents(menuCategoryTable, currentPageNumberTextField,
                contentLimitComboBox, sortingMethodComboBox,
                ascendingRadioButton, descendingRadioButton);
    }

    private String getSelectedRowMenuCategoryName(JTable menuCategoryTable){
        int selectedTableRow = menuCategoryTable.getSelectedRow();
        String selectedMenuCategoryName = menuCategoryTable
                .getValueAt(selectedTableRow,
                        MENU_CATEGORY_NAME_COLUMN_NUMBER)
                .toString();

        return selectedMenuCategoryName;
    }

    private boolean isValidToEditMenuCategory(JTextField menuCategoryNameTextField, JTable menuCategoryTable){
        return menuCategoryValidations.isValidToEditMenuCategory(menuCategoryNameTextField, menuCategoryTable);
    }

    private boolean isValidToDeleteMenuCategory(JTable menuCategoryTable){
        return menuCategoryValidations.isValidToDeleteMenuCategory(menuCategoryTable);
    }

    private boolean isValidToAddMenuCategory(JTextField menuCategoryNameTextField){
        return menuCategoryValidations.isValidToAddMenuCategory(menuCategoryNameTextField);
    }

    public void currentPageNumberTextFieldKeyReleased(KeyEvent evt, JPanel paginationAndSortPanel) {
        if (validations.isEnterKeyPressed(evt)){
            paginationAndSortPanel.requestFocusInWindow();

        }
    }


    public void formWindowActivated(JTable menuCategoryTable,
                                    JTextField currentPageNumberTextField,
                                    JComboBox contentLimitComboBox,
                                    JComboBox sortingMethodComboBox,
                                    JRadioButton ascendingRadioButton,
                                    JRadioButton descendingRadioButton,
                                    JButton previousButton,
                                    JButton nextButton){


        updateTableContents(menuCategoryTable, currentPageNumberTextField,
                contentLimitComboBox, sortingMethodComboBox,
                ascendingRadioButton, descendingRadioButton);

        updateStateOfButtons(previousButton, nextButton, currentPageNumberTextField, contentLimitComboBox);
    }

    public void formWindowOpened(JTable menuCategoryTable){
        menuCategoryTable.setDefaultEditor(Object.class, null);
    }

    public void contentLimitComboBoxActionPerformed(JTable menuCategoryTable,
                                                    JTextField currentPageNumberTextField,
                                                    JComboBox contentLimitComboBox,
                                                    JComboBox sortingMethodComboBox,
                                                    JRadioButton ascendingRadioButton,
                                                    JRadioButton descendingRadioButton,
                                                    JButton previousButton,
                                                    JButton nextButton){

        updateCurrentPageNumberTextField(1, currentPageNumberTextField);

        updateTableContents(menuCategoryTable, currentPageNumberTextField,
                contentLimitComboBox, sortingMethodComboBox,
                ascendingRadioButton, descendingRadioButton);

        updateStateOfButtons(previousButton, nextButton, currentPageNumberTextField, contentLimitComboBox);
    }

    public void sortingMethodComboBoxActionPerformed(JTable menuCategoryTable,
                                                     JTextField currentPageNumberTextField,
                                                     JComboBox contentLimitComboBox,
                                                     JComboBox sortingMethodComboBox,
                                                     JRadioButton ascendingRadioButton,
                                                     JRadioButton descendingRadioButton,
                                                     JButton previousButton,
                                                     JButton nextButton){


        updateTableContents(menuCategoryTable, currentPageNumberTextField,
                contentLimitComboBox, sortingMethodComboBox,
                ascendingRadioButton, descendingRadioButton);

        updateStateOfButtons(previousButton, nextButton, currentPageNumberTextField, contentLimitComboBox);
    }

    public void ascendingRadioButtonItemStateChanged(JTable menuCategoryTable,
                                    JTextField currentPageNumberTextField,
                                    JComboBox contentLimitComboBox,
                                    JComboBox sortingMethodComboBox,
                                    JRadioButton ascendingRadioButton,
                                    JRadioButton descendingRadioButton,
                                    JButton previousButton,
                                    JButton nextButton){


        updateTableContents(menuCategoryTable, currentPageNumberTextField,
                contentLimitComboBox, sortingMethodComboBox,
                ascendingRadioButton, descendingRadioButton);

        updateStateOfButtons(previousButton, nextButton, currentPageNumberTextField, contentLimitComboBox);
    }

    public void currentPageNumberTextFieldFocusLost(JTable menuCategoryTable,
                                                    JTextField currentPageNumberTextField,
                                                    JComboBox contentLimitComboBox,
                                                    JComboBox sortingMethodComboBox,
                                                    JRadioButton ascendingRadioButton,
                                                    JRadioButton descendingRadioButton,
                                                    JButton previousButton,
                                                    JButton nextButton) {

        if (validations.isTextFieldContainingOnlyNumericalValues(currentPageNumberTextField)){
            handleCurrentPageNumberTextFieldWrongInputs(currentPageNumberTextField, contentLimitComboBox);

            updateTableContents(menuCategoryTable, currentPageNumberTextField,
                    contentLimitComboBox, sortingMethodComboBox,
                    ascendingRadioButton, descendingRadioButton);

            updateStateOfButtons(previousButton, nextButton, currentPageNumberTextField, contentLimitComboBox);

        }else{
            resetCurrentPageToDefault(currentPageNumberTextField);
            messageDialogues.showNumericValuesOnlyMessageDialogue();
        }
    }

    public void previousButtonActionPerformed(JTable menuCategoryTable,
                                               JTextField currentPageNumberTextField,
                                               JComboBox contentLimitComboBox,
                                               JComboBox sortingMethodComboBox,
                                               JRadioButton ascendingRadioButton,
                                               JRadioButton descendingRadioButton,
                                               JButton previousButton,
                                               JButton nextButton) {

        int currentPageNumber = getCurrentPageNumber(currentPageNumberTextField);
        updateCurrentPageNumberTextField(currentPageNumber - 1, currentPageNumberTextField);

        updateTableContents(menuCategoryTable, currentPageNumberTextField,
                contentLimitComboBox, sortingMethodComboBox,
                ascendingRadioButton, descendingRadioButton);

        updateStateOfButtons(previousButton, nextButton, currentPageNumberTextField, contentLimitComboBox);
    }

    public void nextButtonActionPerformed(JTable menuCategoryTable,
                                              JTextField currentPageNumberTextField,
                                              JComboBox contentLimitComboBox,
                                              JComboBox sortingMethodComboBox,
                                              JRadioButton ascendingRadioButton,
                                              JRadioButton descendingRadioButton,
                                              JButton previousButton,
                                              JButton nextButton) {

        int currentPageNumber = getCurrentPageNumber(currentPageNumberTextField);
        updateCurrentPageNumberTextField(currentPageNumber + 1, currentPageNumberTextField);

        updateTableContents(menuCategoryTable, currentPageNumberTextField,
                contentLimitComboBox, sortingMethodComboBox,
                ascendingRadioButton, descendingRadioButton);

        updateStateOfButtons(previousButton, nextButton, currentPageNumberTextField, contentLimitComboBox);
    }

    public void menuCategoryTableMousePressed(JTable menuCategoryTable,
                                              JTextField menuCategoryNameTextField){

        String selectedMenuCategoryName = getSelectedRowMenuCategoryName(menuCategoryTable);
        menuCategoryNameTextField.setText(selectedMenuCategoryName);
    }

    public void editMenuCategoryButtonActionPerformed(JTextField menuCategoryNameTextField,
                                                      JTable menuCategoryTable) {

        String newMenuCategoryName = menuCategoryNameTextField.getText();
        if (isValidToEditMenuCategory(menuCategoryNameTextField, menuCategoryTable)){
            String selectedMenuCategoryName = getSelectedRowMenuCategoryName(menuCategoryTable);
            Long selectedMenuCategoryId = viewEditDeleteMenuCategoryController
                    .findMenuCategoryIdByMenuCategoryName(selectedMenuCategoryName);


            viewEditDeleteMenuCategoryController
                    .editMenuCategoryNameByMenuCategoryId(selectedMenuCategoryId,
                            newMenuCategoryName);

            messageDialogues.showSuccessfullyEditedMenuCategoryMessageDialogue();
            clearTextField(menuCategoryNameTextField);

        }
    }

    public void deleteMenuCategoryButtonActionPerformed(JTextField menuCategoryNameTextField,
                                                        JTable menuCategoryTable) {

        if (isValidToDeleteMenuCategory(menuCategoryTable)){
            List<String> menuCategoryNames = generateToBeDeletedList(menuCategoryTable);

            viewEditDeleteMenuCategoryController
                    .deleteAllMenuCategoriesByName(menuCategoryNames);

            messageDialogues.showSuccessfullyDeletedMenuCategoryMessageDialogue();
            clearTextField(menuCategoryNameTextField);
        }
    }

    public void addMenuCategoryButtonActionPerformed(JTextField menuCategoryNameTextField) {
        if (isValidToAddMenuCategory(menuCategoryNameTextField)){
            String newMenuCategoryName = menuCategoryNameTextField.getText();
            menuCategoryController.addNewMenuCategory(newMenuCategoryName);
            messageDialogues.showSuccessfullyAddedMenuCategoryMessageDialogue();
        }
        clearTextField(menuCategoryNameTextField);
    }



}
