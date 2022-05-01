package com.exe.EscobarIMS.Supplier;

import com.exe.EscobarIMS.Supplier.AddSupplier.AddSupplierController;
import com.exe.EscobarIMS.Supplier.ViewEditDeleteSupplier.ViewEditDeleteSupplierController;
import com.exe.EscobarIMS.Utilities.Exceptions.*;
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
public class SupplierFormActions extends SortAndPaginationMethods {

    @Autowired
    AddSupplierController addSupplierController;

    @Autowired
    ViewEditDeleteSupplierController viewEditDeleteSupplierController;

    @Autowired
    MessageDialogues messageDialogues;

    @Autowired
    Validations validations;

    @Autowired
    SupplierValidations supplierValidations;

    private JTextField supplierNameTextField;
    private JTextField supplierAddressTextField;
    private JTextField supplierContactNumberTextField;
    private JTextField supplierContactPersonTextField;
    private JTable supplierTable;
    private Boolean shouldUpdateTableContents = true;

    public void setSupplierNameTextField(JTextField supplierNameTextField) {
        this.supplierNameTextField = supplierNameTextField;
    }

    public void setSupplierTable(JTable supplierTable) {
        this.supplierTable = supplierTable;
    }

    public void setSupplierAddressTextField(JTextField supplierAddressTextField) {
        this.supplierAddressTextField = supplierAddressTextField;
    }

    public void setSupplierContactNumberTextField(JTextField supplierContactNumberTextField) {
        this.supplierContactNumberTextField = supplierContactNumberTextField;
    }

    public void setSupplierContactPersonTextField(JTextField supplierContactPersonTextField) {
        this.supplierContactPersonTextField = supplierContactPersonTextField;
    }

    private void resetShouldUpdateTableContentsVariableToDefault(){
        shouldUpdateTableContents = true;
    }

    private void clearTextField(){
        supplierNameTextField.setText("");
        supplierAddressTextField.setText("");
        supplierContactNumberTextField.setText("");
        supplierContactPersonTextField.setText("");
    }

    @Override
    public int getNumberOfPages(){
        int selectedContentLimit = getCurrentSelectedPageLimit();
        int numberOfPages = viewEditDeleteSupplierController.getTotalNumberOfPages(selectedContentLimit);
        return numberOfPages;
    }

    private void addTableRow(Supplier supplier,
                             DefaultTableModel tableModel){
        String[] itemsOfRow = new String[]{
                supplier.getSupplierName(),
                supplier.getSupplierAddress(),
                String.valueOf(supplier.getSupplierContactNumber()),
                supplier.getSupplierContactPerson()};
        tableModel.addRow(itemsOfRow);
    }

    private void deleteExistingTableContents(){
        DefaultTableModel tableModel = (DefaultTableModel) supplierTable.getModel();
        tableModel.setRowCount(0);
    }

    @Override
    public Sort getSortingComboBoxValue(){
        String sortingMethodName = sortingMethodComboBox.getSelectedItem().toString();
        enableSortRadioButtons();

        switch(sortingMethodName){
            case "Supplier Name":
                return Sort.by("supplier_name");
            case "Supplier Address":
                return Sort.by("supplier_address");
            case "Supplier Contact Number":
                return Sort.by("supplier_contact_number");
            case "Supplier Contact Person":
                return Sort.by("supplier_contact_person");
            default:
                disableSortRadioButtons();
                return Sort.unsorted();
        }
    }

    public void generateTableContents(){
        DefaultTableModel tableModel = (DefaultTableModel) supplierTable.getModel();
        int currentPageNumber = getCurrentPageNumber();
        int currentSelectedPageLimit = getCurrentSelectedPageLimit();
        Sort sort = getSortingMethod();

        List<Supplier> suppliers =  viewEditDeleteSupplierController
                .getAllPagedSupplier(currentPageNumber, currentSelectedPageLimit, sort);

        for (Supplier supplier :suppliers){
            addTableRow(supplier, tableModel);
        }
    }

    private List<String> generateToBeDeletedList(){
        List<String> supplierNames = new ArrayList<>();
        int[] selectedTableRows = supplierTable.getSelectedRows();
        for (int selectedTableRow:selectedTableRows){

            String selectedSupplierName =  supplierTable
                    .getValueAt(selectedTableRow,
                            SUPPLIER_NAME_COLUMN_NUMBER).toString();

            supplierNames.add(selectedSupplierName);
        }
        return supplierNames;
    }

    @Override
    public void updateTableContents(){
        if (shouldUpdateTableContents){
            if(validations.hasExistingTableContents(supplierTable)){
                deleteExistingTableContents();
            }
            generateTableContents();
        }else{
            resetShouldUpdateTableContentsVariableToDefault();
        }
    }

    private String getSelectedRowSupplierName(){
        int selectedTableRow = supplierTable.getSelectedRow();
        String selectedSupplierName = supplierTable
                .getValueAt(selectedTableRow,
                        SUPPLIER_NAME_COLUMN_NUMBER)
                .toString();

        return selectedSupplierName;
    }
    private String getSelectedRowSupplierAddress(){
        int selectedTableRow = supplierTable.getSelectedRow();
        String selectedSupplierAddress = supplierTable
                .getValueAt(selectedTableRow,
                        SUPPLIER_ADDRESS_COLUMN_NUMBER)
                .toString();

        return selectedSupplierAddress;
    }

    private String getSelectedRowSupplierContactNumber(){
        int selectedTableRow = supplierTable.getSelectedRow();
        String selectedSupplierContactNumber = supplierTable
                .getValueAt(selectedTableRow,
                        SUPPLIER_CONTACT_NUMBER_COLUMN_NUMBER)
                .toString();

        return selectedSupplierContactNumber;
    }

    private String getSelectedRowSupplierContactPerson(){
        int selectedTableRow = supplierTable.getSelectedRow();
        String selectedSupplierContactPerson = supplierTable
                .getValueAt(selectedTableRow,
                        SUPPLIER_CONTACT_PERSON_COLUMN_NUMBER)
                .toString();

        return selectedSupplierContactPerson;
    }


    private void validateIfEditingIsAllowed(){
        supplierValidations.validateIfEditingIsAllowed(supplierNameTextField, supplierAddressTextField,
                supplierContactNumberTextField, supplierContactPersonTextField, supplierTable);
    }

    private void validateIfDeletingIsAllowed(){
        supplierValidations.validateIfDeletingIsAllowed(supplierTable);
    }

    private void validateIfAddingIsAllowed(){
        supplierValidations.validateIfAddingIsAllowed(supplierNameTextField, supplierAddressTextField,
                supplierContactNumberTextField, supplierContactPersonTextField);
    }

    public void isAddSupplierSuccessful(){
        validateIfAddingIsAllowed();
        String newName = supplierNameTextField.getText();
        String newAddress = supplierAddressTextField.getText();
        String newContactNumber = supplierContactNumberTextField.getText();
        String newContactPerson = supplierContactPersonTextField.getText();
        addSupplierController.addNewSupplier(newName, newAddress, newContactNumber, newContactPerson);


    }

    public void isEditSupplierSuccessful(){
        String newName = supplierNameTextField.getText();
        String newAddress = supplierAddressTextField.getText();
        String newContactNumber = supplierContactNumberTextField.getText();
        String newContactPerson = supplierContactPersonTextField.getText();
        validateIfEditingIsAllowed();
        String selectedSupplierName = getSelectedRowSupplierName();
        Long selectedSupplierId = viewEditDeleteSupplierController
                .findSupplierIdByName(selectedSupplierName);

        viewEditDeleteSupplierController
                .editSupplierNameById(selectedSupplierId,
                        newName, newAddress, newContactNumber, newContactPerson);


    }

    public void isDeleteSupplierSuccessful(){
        validateIfDeletingIsAllowed();
        List<String> supplierNames = generateToBeDeletedList();

        viewEditDeleteSupplierController
                .deleteAllSupplierByName(supplierNames);
    }

    public void formWindowActivated(){
        updateTableContents();
        updateStateOfButtons();
    }

    public void formWindowOpened(JTable supplierTable){
        supplierTable.setDefaultEditor(Object.class, null);
    }

    public void supplierTableMousePressed(){
        String selectedSupplierName = getSelectedRowSupplierName();
        String selectedSupplierAddress = getSelectedRowSupplierAddress();
        String selectedSupplierContactNumber = getSelectedRowSupplierContactNumber();
        String selectedSupplierContactPerson = getSelectedRowSupplierContactPerson();

        supplierNameTextField.setText(selectedSupplierName);
        supplierAddressTextField.setText(selectedSupplierAddress);
        supplierContactNumberTextField.setText(selectedSupplierContactNumber);
        supplierContactPersonTextField.setText(selectedSupplierContactPerson);
    }

    public void editSupplierButtonActionPerformed() {
        try{
            isEditSupplierSuccessful();
            messageDialogues.showSuccessfullyEditedUnitOfMeasurementMessageDialogue();
            clearTextField();
        }catch(SelectJustOneRowException e){
            shouldUpdateTableContents = false;
            System.out.println(e.getMessage());
            messageDialogues.showSelectJustOneRowMessageDialogue();
        }catch(FillOutAllTextFieldsException e){
            shouldUpdateTableContents = false;
            System.out.println(e.getMessage());
            messageDialogues.showFillOutAllTextFieldsMessageDialogue();
        }catch(NameAlreadyExistsException e){
            shouldUpdateTableContents = false;
            System.out.println(e.getMessage());
            messageDialogues.showNameAlreadyExistsMessageDialogue();
        }catch(InvalidPhoneNumberException e){
            shouldUpdateTableContents = false;
            System.out.println(e.getMessage());
            messageDialogues.showInvalidPhoneNumberMessageDialogue();
        }
    }

    public void deleteSupplierButtonActionPerformed() {
        try{
            isDeleteSupplierSuccessful();
            messageDialogues.showSuccessfullyDeletedUnitOfMeasurementMessageDialogue();
            clearTextField();
        }catch(SelectOneOrMoreRowException e){
            System.out.println(e.getMessage());
            messageDialogues.showSelectOneOrMoreRowMessageDialogue();
        }
    }

    public void addSupplierButtonActionPerformed() {
        try{
            isAddSupplierSuccessful();
            messageDialogues.showSuccessfullyAddedUnitOfMeasurementMessageDialogue();
            clearTextField();
        }catch(NameAlreadyExistsException e){
            System.out.println(e.getMessage());
            messageDialogues.showNameAlreadyExistsMessageDialogue();
        }catch(FillOutAllTextFieldsException e){
            System.out.println(e.getMessage());
            messageDialogues.showFillOutAllTextFieldsMessageDialogue();
        }catch(InvalidPhoneNumberException e){
            System.out.println(e.getMessage());
            messageDialogues.showInvalidPhoneNumberMessageDialogue();
        }
    }



}
