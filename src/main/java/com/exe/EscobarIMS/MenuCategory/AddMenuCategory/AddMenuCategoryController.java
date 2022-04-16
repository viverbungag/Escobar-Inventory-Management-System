package com.exe.EscobarIMS.MenuCategory.AddMenuCategory;

import com.exe.EscobarIMS.MenuCategory.MenuCategory;
import com.exe.EscobarIMS.MenuCategory.MessageDialogues;
import com.exe.EscobarIMS.MenuCategory.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AddMenuCategoryController {

    @Autowired
    private AddMenuCategoryRepository addMenuCategoryRepository;

    @Autowired
    private Validations validations;

    @Autowired
    private MessageDialogues messageDialogues;


    public void addNewMenuCategory(String menuCategoryName){
        if (validations.isMenuCategoryExisting(menuCategoryName)){
            messageDialogues.showNameAlreadyExistsMessageDialogue();
        }else{
            MenuCategory newMenuCategory = new MenuCategory();
            newMenuCategory.setMenuCategoryName(menuCategoryName);
            addMenuCategoryRepository.save(newMenuCategory);
            messageDialogues.showSuccessfullyAddedMenuCategoryMessageDialogue();
        }
    }
}
