package com.exe.EscobarIMS.MenuCategory;

import org.springframework.stereotype.Component;

import static com.exe.EscobarIMS.Utilities.Constants.ErrorMessages.*;
import static com.exe.EscobarIMS.Utilities.Constants.ErrorTitles.ERROR_TITLE;
import static com.exe.EscobarIMS.Utilities.Constants.SuccessMessages.*;
import static com.exe.EscobarIMS.Utilities.Constants.SuccessfulTitles.SUCCESSFUL_TITLE;
import static javax.swing.JOptionPane.*;

@Component
public class MessageDialogues {

    public void showNameAlreadyExistsMessageDialogue(){
        showMessageDialog(
                null,
                NAME_ALREADY_EXISTS_MESSAGE,
                ERROR_TITLE,
                ERROR_MESSAGE);
    }

    public void showSuccessfullyAddedMenuCategoryMessageDialogue(){
        showMessageDialog(null,
                MENU_CATEGORY_ADDED_MESSAGE,
                SUCCESSFUL_TITLE,
                INFORMATION_MESSAGE);
    }

    public void showSuccessfullyDeletedMenuCategoryMessageDialogue(){
        showMessageDialog(null,
                MENU_CATEGORY_DELETED_MESSAGE,
                SUCCESSFUL_TITLE,
                INFORMATION_MESSAGE);
    }

    public void showSuccessfullyEditedMenuCategoryMessageDialogue(){
        showMessageDialog(null,
                MENU_CATEGORY_UPDATED_MESSAGE,
                SUCCESSFUL_TITLE,
                INFORMATION_MESSAGE);
    }

    public void showSelectOneOrMoreRowMessageDialogue(){
        showMessageDialog(null,
                SELECT_ONE_OR_MORE_ROW_MESSAGE,
                ERROR_TITLE,
                ERROR_MESSAGE);
    }

    public void showSelectJustOneRowMessageDialogue(){
        showMessageDialog(null,
                SELECT_JUST_ONE_ROW_MESSAGE,
                ERROR_TITLE,
                ERROR_MESSAGE);
    }

    public void showFillOutAllTextFieldsMessageDialogue(){
        showMessageDialog(null,
                FILL_OUT_ALL_TEXT_FIELD_MESSAGE,
                ERROR_TITLE,
                ERROR_MESSAGE);
    }
}
