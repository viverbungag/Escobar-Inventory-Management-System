package com.exe.EscobarIMS.Utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class SortAndPaginationMethods {

    @Autowired
    MessageDialogues messageDialogues;

    @Autowired
    Validations validations;

    public JComboBox contentLimitComboBox;
    public JTextField currentPageNumberTextField;
    public JButton previousButton;
    public JButton nextButton;
    public JRadioButton ascendingRadioButton;
    public JRadioButton descendingRadioButton;
    public JComboBox sortingMethodComboBox;

    public void setContentLimitComboBox(JComboBox contentLimitComboBox) {
        this.contentLimitComboBox = contentLimitComboBox;
    }

    public void setCurrentPageNumberTextField(JTextField currentPageNumberTextField) {
        this.currentPageNumberTextField = currentPageNumberTextField;
    }

    public void setPreviousButton(JButton previousButton) {
        this.previousButton = previousButton;
    }

    public void setNextButton(JButton nextButton) {
        this.nextButton = nextButton;
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

    public int getCurrentSelectedPageLimit(){
        return Integer.parseInt(contentLimitComboBox.getSelectedItem().toString());
    }

    public int getCurrentPageNumber(){
        return Integer.parseInt(currentPageNumberTextField.getText());
    }

    public void updateCurrentPageNumberTextField(int pageNumber){
        currentPageNumberTextField.setText(String.valueOf(pageNumber));
    }

    public void resetCurrentPageToDefault(){
        updateCurrentPageNumberTextField(1);
    }


    public void enableButtons(){
        previousButton.setEnabled(true);
        nextButton.setEnabled(true);
    }

    public void handleCurrentPageNumberTextFieldWrongInputs(){
        int currentPageNumber = getCurrentPageNumber();
        int lastPage = getNumberOfPages();

        if (currentPageNumber > lastPage){
            updateCurrentPageNumberTextField(lastPage);
        }

        if (currentPageNumber < 1){
            updateCurrentPageNumberTextField(1);
        }
    }

    public void updateStateOfButtons(){
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

    public void disableSortRadioButtons(){
        ascendingRadioButton.setEnabled(false);
        descendingRadioButton.setEnabled(false);
    }

    public void enableSortRadioButtons(){
        ascendingRadioButton.setEnabled(true);
        descendingRadioButton.setEnabled(true);
    }

    public Sort getSortingMethod(){
        Sort sortingComboBoxValue = getSortingComboBoxValue();
        if (ascendingRadioButton.isSelected()){
            return sortingComboBoxValue.ascending();
        }

        return sortingComboBoxValue.descending();
    }

    public void contentLimitComboBoxActionPerformed(){
        updateCurrentPageNumberTextField(1);
        updateTableContents();
        updateStateOfButtons();
    }

    public void ascendingRadioButtonItemStateChanged(){
        updateTableContents();
        updateStateOfButtons();
    }

    public void sortingMethodComboBoxActionPerformed(){
        updateTableContents();
        updateStateOfButtons();
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

    public void currentPageNumberTextFieldKeyReleased(KeyEvent evt, JPanel paginationAndSortPanel) {
        if (validations.isEnterKeyPressed(evt)){
            paginationAndSortPanel.requestFocusInWindow();
        }
    }

    public int getNumberOfPages(){return 1;}

    public Sort getSortingComboBoxValue(){return Sort.unsorted();}

    public void updateTableContents(){};

}
