package com.exe.EscobarIMS.Utilities;

import org.springframework.stereotype.Component;

import static com.exe.EscobarIMS.Utilities.Constants.ErrorMessages.*;
import static com.exe.EscobarIMS.Utilities.Constants.ErrorTitles.ERROR_TITLE;
import static com.exe.EscobarIMS.Utilities.Constants.SuccessMessages.*;
import static com.exe.EscobarIMS.Utilities.Constants.SuccessfulTitles.SUCCESSFUL_TITLE;
import static javax.swing.JOptionPane.*;

@Component
public class MessageDialogues {

    private boolean shouldShowMessageDialog = true;

    public void setShouldShowMessageDialog(boolean shouldShowMessageDialog) {
        this.shouldShowMessageDialog = shouldShowMessageDialog;
    }

    public void showNameAlreadyExistsMessageDialogue(){
        if (shouldShowMessageDialog)
            showMessageDialog(
                null,
                NAME_ALREADY_EXISTS_MESSAGE,
                ERROR_TITLE,
                ERROR_MESSAGE);
    }

    public void showSuccessfullyAddedMenuCategoryMessageDialogue(){
        if (shouldShowMessageDialog)
            showMessageDialog(null,
                MENU_CATEGORY_ADDED_MESSAGE,
                SUCCESSFUL_TITLE,
                INFORMATION_MESSAGE);
    }

    public void showSuccessfullyAddedSupplyCategoryMessageDialogue(){
        if (shouldShowMessageDialog)
            showMessageDialog(null,
                SUPPLY_CATEGORY_ADDED_MESSAGE,
                SUCCESSFUL_TITLE,
                INFORMATION_MESSAGE);
    }

    public void showSuccessfullyAddedUnitOfMeasurementMessageDialogue(){
        if (shouldShowMessageDialog)
            showMessageDialog(null,
                UNIT_OF_MEASUREMENT_ADDED_MESSAGE,
                SUCCESSFUL_TITLE,
                INFORMATION_MESSAGE);
    }

    public void showSuccessfullyAddedSupplierMessageDialogue(){
        if (shouldShowMessageDialog)
            showMessageDialog(null,
                SUPPLIER_CATEGORY_ADDED_MESSAGE,
                SUCCESSFUL_TITLE,
                INFORMATION_MESSAGE);
    }


    public void showSuccessfullyDeletedMenuCategoryMessageDialogue(){
        if (shouldShowMessageDialog)
            showMessageDialog(null,
                MENU_CATEGORY_DELETED_MESSAGE,
                SUCCESSFUL_TITLE,
                INFORMATION_MESSAGE);
    }

    public void showSuccessfullyDeletedSupplyCategoryMessageDialogue(){
        if (shouldShowMessageDialog)
            showMessageDialog(null,
                SUPPLY_CATEGORY_DELETED_MESSAGE,
                SUCCESSFUL_TITLE,
                INFORMATION_MESSAGE);
    }

    public void showSuccessfullyDeletedUnitOfMeasurementMessageDialogue(){
        if (shouldShowMessageDialog)
            showMessageDialog(null,
                UNIT_OF_MEASUREMENT_DELETED_MESSAGE,
                SUCCESSFUL_TITLE,
                INFORMATION_MESSAGE);
    }

    public void showSuccessfullyDeletedSupplierMessageDialogue(){
        if (shouldShowMessageDialog)
            showMessageDialog(null,
                    SUPPLIER_CATEGORY_DELETED_MESSAGE,
                    SUCCESSFUL_TITLE,
                    INFORMATION_MESSAGE);
    }

    public void showSuccessfullyEditedMenuCategoryMessageDialogue(){
        if (shouldShowMessageDialog)
            showMessageDialog(null,
                MENU_CATEGORY_UPDATED_MESSAGE,
                SUCCESSFUL_TITLE,
                INFORMATION_MESSAGE);
    }

    public void showSuccessfullyEditedSupplyCategoryMessageDialogue(){
        if (shouldShowMessageDialog)
            showMessageDialog(null,
                SUPPLY_CATEGORY_UPDATED_MESSAGE,
                SUCCESSFUL_TITLE,
                INFORMATION_MESSAGE);
    }

    public void showSuccessfullyEditedUnitOfMeasurementMessageDialogue(){
        if (shouldShowMessageDialog)
            showMessageDialog(null,
                UNIT_OF_MEASUREMENT_UPDATED_MESSAGE,
                SUCCESSFUL_TITLE,
                INFORMATION_MESSAGE);
    }

    public void showSuccessfullyEditedSupplierMessageDialogue(){
        if (shouldShowMessageDialog)
            showMessageDialog(null,
                    SUPPLIER_CATEGORY_UPDATED_MESSAGE,
                    SUCCESSFUL_TITLE,
                    INFORMATION_MESSAGE);
    }

    public void showSelectOneOrMoreRowMessageDialogue(){
        if (shouldShowMessageDialog)
            showMessageDialog(null,
                SELECT_ONE_OR_MORE_ROW_MESSAGE,
                ERROR_TITLE,
                ERROR_MESSAGE);
    }

    public void showSelectJustOneRowMessageDialogue(){
        if (shouldShowMessageDialog)
            showMessageDialog(null,
                SELECT_JUST_ONE_ROW_MESSAGE,
                ERROR_TITLE,
                ERROR_MESSAGE);
    }

    public void showFillOutAllTextFieldsMessageDialogue(){
        if (shouldShowMessageDialog)
            showMessageDialog(null,
                FILL_OUT_ALL_TEXT_FIELD_MESSAGE,
                ERROR_TITLE,
                ERROR_MESSAGE);
    }

    public void showIntegerValuesOnlyMessageDialogue(){
        if (shouldShowMessageDialog)
            showMessageDialog(null,
                INTEGER_VALUES_ONLY_MESSAGE,
                ERROR_TITLE,
                ERROR_MESSAGE);
    }

    public void showInvalidPhoneNumberMessageDialogue(){
        if (shouldShowMessageDialog)
            showMessageDialog(null,
                    INVALID_PHONE_NUMBER_MESSAGE,
                    ERROR_TITLE,
                    ERROR_MESSAGE);
    }

    public void showNumericalValuesMessageDialogue(){
        if (shouldShowMessageDialog)
            showMessageDialog(null,
                    NUMERICAL_VALUES_ONLY_MESSAGE,
                    ERROR_TITLE,
                    ERROR_MESSAGE);
    }

    public void showPositiveValuesMessageDialogue(){
        if (shouldShowMessageDialog)
            showMessageDialog(null,
                    POSITIVE_VALUES_ONLY_MESSAGE,
                    ERROR_TITLE,
                    ERROR_MESSAGE);
    }


}
