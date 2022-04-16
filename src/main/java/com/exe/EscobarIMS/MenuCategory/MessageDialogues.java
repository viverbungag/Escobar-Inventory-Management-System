package com.exe.EscobarIMS.MenuCategory;

import org.springframework.stereotype.Component;

import static com.exe.EscobarIMS.Utilities.Constants.ErrorMessages.NAME_ALREADY_EXISTS_MESSAGE;
import static com.exe.EscobarIMS.Utilities.Constants.ErrorTitles.ERROR_TITLE;
import static com.exe.EscobarIMS.Utilities.Constants.SuccessMessages.MENU_CATEGORY_ADDED_MESSAGE;
import static com.exe.EscobarIMS.Utilities.Constants.SuccessMessages.MENU_CATEGORY_DELETED_MESSAGE;
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
}
