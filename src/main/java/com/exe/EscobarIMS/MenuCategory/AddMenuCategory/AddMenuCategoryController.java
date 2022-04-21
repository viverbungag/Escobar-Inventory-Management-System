package com.exe.EscobarIMS.MenuCategory.AddMenuCategory;

import com.exe.EscobarIMS.MenuCategory.MenuCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AddMenuCategoryController {

    @Autowired
    private AddMenuCategoryRepository addMenuCategoryRepository;

    public void addNewMenuCategory(String menuCategoryName){
        MenuCategory newMenuCategory = new MenuCategory(menuCategoryName);
        addMenuCategoryRepository.save(newMenuCategory);
    }
}
