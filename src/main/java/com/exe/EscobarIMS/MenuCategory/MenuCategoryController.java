package com.exe.EscobarIMS.MenuCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MenuCategoryController {

    @Autowired
    private MenuCategoryRepository menuCategoryRepository;

    public MenuCategory addNewMenuCategory(String menuCategoryName){
        MenuCategory newMenuCategory = new MenuCategory();
        newMenuCategory.setMenuCategoryName(menuCategoryName);
        return menuCategoryRepository.save(newMenuCategory);
    }
//
//    public List<MenuCategory> getAllMenuCategory(){
//        return menuCategoryRepository.findAllMenuCategory();
//    }
}
