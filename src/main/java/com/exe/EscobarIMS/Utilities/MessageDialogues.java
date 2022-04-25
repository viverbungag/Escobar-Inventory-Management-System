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
        if (shouldShowMessageDialog) showMessageDialog(
                                            null,
                                            NAME_ALREADY_EXISTS_MESSAGE,
                                            ERROR_TITLE,
                                            ERROR_MESSAGE);
    }

    public void showSuccessfullyAddedMenuCategoryMessageDialogue(){
        if (shouldShowMessageDialog) showMessageDialog(null,
                                            MENU_CATEGORY_ADDED_MESSAGE,
                                            SUCCESSFUL_TITLE,
                                            INFORMATION_MESSAGE);
    }

    public void showSuccessfullyAddedSupplyCategoryMessageDialogue(){
        if (shouldShowMessageDialog) showMessageDialog(null,
                                            SUPPLY_CATEGORY_ADDED_MESSAGE,
                                            SUCCESSFUL_TITLE,
                                            INFORMATION_MESSAGE);
    }

    public void showSuccessfullyDeletedMenuCategoryMessageDialogue(){
        if (shouldShowMessageDialog) showMessageDialog(null,
                                            MENU_CATEGORY_DELETED_MESSAGE,
                                            SUCCESSFUL_TITLE,
                                            INFORMATION_MESSAGE);
    }

    public void showSuccessfullyDeletedSupplyCategoryMessageDialogue(){
        if (shouldShowMessageDialog) showMessageDialog(null,
                                            SUPPLY_CATEGORY_DELETED_MESSAGE,
                                            SUCCESSFUL_TITLE,
                                            INFORMATION_MESSAGE);
    }

    public void showSuccessfullyEditedMenuCategoryMessageDialogue(){
        if (shouldShowMessageDialog) showMessageDialog(null,
                                            MENU_CATEGORY_UPDATED_MESSAGE,
                                            SUCCESSFUL_TITLE,
                                            INFORMATION_MESSAGE);
    }

    public void showSuccessfullyEditedSupplyCategoryMessageDialogue(){
        if (shouldShowMessageDialog) showMessageDialog(null,
                                            SUPPLY_CATEGORY_UPDATED_MESSAGE,
                                            SUCCESSFUL_TITLE,
                                            INFORMATION_MESSAGE);
    }

    public void showSelectOneOrMoreRowMessageDialogue(){
        if (shouldShowMessageDialog) showMessageDialog(null,
                                            SELECT_ONE_OR_MORE_ROW_MESSAGE,
                                            ERROR_TITLE,
                                            ERROR_MESSAGE);
    }

    public void showSelectJustOneRowMessageDialogue(){
        if (shouldShowMessageDialog) showMessageDialog(null,
                                            SELECT_JUST_ONE_ROW_MESSAGE,
                                            ERROR_TITLE,
                                            ERROR_MESSAGE);
    }

    public void showFillOutAllTextFieldsMessageDialogue(){
        if (shouldShowMessageDialog) showMessageDialog(null,
                                            FILL_OUT_ALL_TEXT_FIELD_MESSAGE,
                                            ERROR_TITLE,
                                            ERROR_MESSAGE);
    }

    public void showNumericValuesOnlyMessageDialogue(){
        if (shouldShowMessageDialog) showMessageDialog(null,
                                            NUMERIC_VALUES_ONLY_MESSAGE,
                                            ERROR_TITLE,
                                            ERROR_MESSAGE);
    }
}
