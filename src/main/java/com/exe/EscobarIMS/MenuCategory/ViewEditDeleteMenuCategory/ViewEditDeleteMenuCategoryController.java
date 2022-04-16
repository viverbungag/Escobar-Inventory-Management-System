package com.exe.EscobarIMS.MenuCategory.ViewEditDeleteMenuCategory;

import com.exe.EscobarIMS.MenuCategory.MenuCategory;
import com.exe.EscobarIMS.MenuCategory.MessageDialogues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Controller
public class ViewEditDeleteMenuCategoryController {

    @Autowired
    ViewEditDeleteMenuCategoryRepository viewEditDeleteMenuCategoryRepository;

    @Autowired
    MessageDialogues messageDialogues;


    public List<MenuCategory> getAllMenuCategories(){
        return viewEditDeleteMenuCategoryRepository.getAllMenuCategories();
    }

    @Transactional
    public void deleteAllMenuCategoriesByName(List<String> menuCategoryNames){
        viewEditDeleteMenuCategoryRepository.deleteAllMenuCategoriesByName(menuCategoryNames);
        messageDialogues.showSuccessfullyDeletedMenuCategoryMessageDialogue();
    }



}
