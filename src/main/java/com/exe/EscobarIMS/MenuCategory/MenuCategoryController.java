package com.exe.EscobarIMS.MenuCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.swing.*;

import static com.exe.EscobarIMS.Utilities.Constants.ErrorMessages.NAME_ALREADY_EXISTS_MESSAGE;
import static com.exe.EscobarIMS.Utilities.Constants.ErrorTitles.NOT_SAVED_TITLE;
import static com.exe.EscobarIMS.Utilities.Constants.SuccessMessages.MENU_CATEGORY_ADDED_MESSAGE;
import static com.exe.EscobarIMS.Utilities.Constants.SuccessfulTitles.SUCCESSFUL_TITLE;
import static javax.swing.JOptionPane.*;

@Controller
public class MenuCategoryController {

    @Autowired
    private MenuCategoryRepository menuCategoryRepository;

    private boolean isMenuCategoryExisting(String menuCategoryName){
        return menuCategoryRepository.findMenuCategoryByName(menuCategoryName) != null;
    }

    private void showErrorMessageDialogue(){
        showMessageDialog(
                null,
                NAME_ALREADY_EXISTS_MESSAGE,
                NOT_SAVED_TITLE,
                ERROR_MESSAGE);
    }

    private void showSuccessfulMessageDialogue(){
        showMessageDialog(null,
                MENU_CATEGORY_ADDED_MESSAGE,
                SUCCESSFUL_TITLE,
                INFORMATION_MESSAGE);
    }

    public void addNewMenuCategory(String menuCategoryName){
        if (isMenuCategoryExisting(menuCategoryName)){
            showErrorMessageDialogue();
        }else{
            MenuCategory newMenuCategory = new MenuCategory();
            newMenuCategory.setMenuCategoryName(menuCategoryName);
            menuCategoryRepository.save(newMenuCategory);
            showSuccessfulMessageDialogue();
        }
    }
}
