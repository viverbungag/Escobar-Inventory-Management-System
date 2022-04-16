package com.exe.EscobarIMS.MenuCategory.ViewEditDeleteMenuCategory;

import com.exe.EscobarIMS.MenuCategory.MenuCategory;
import com.exe.EscobarIMS.MenuCategory.MenuCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Controller
public class ViewEditDeleteMenuCategoryController {

    @Autowired
    ViewEditDeleteMenuCategoryRepository viewEditDeleteMenuCategoryRepository;

    @Autowired
    MenuCategoryRepository menuCategoryRepository;


    public List<MenuCategory> getAllMenuCategories(){
        return viewEditDeleteMenuCategoryRepository.getAllMenuCategories();
    }

    public Long findMenuCategoryIdByMenuCategoryName(String menuCategoryName){
        MenuCategory currentMenuCategory = menuCategoryRepository.findByMenuCategoryName(menuCategoryName);
        Long currentMenuCategoryId = currentMenuCategory.getMenuCategoryId();
        return currentMenuCategoryId;
    }

    @Transactional
    public void deleteAllMenuCategoriesByName(List<String> menuCategoryNames){
        viewEditDeleteMenuCategoryRepository.deleteAllMenuCategoriesByName(menuCategoryNames);
    }

    @Transactional
    public void editMenuCategoryNameByMenuCategoryId(Long Id, String newMenuCategoryName){
        viewEditDeleteMenuCategoryRepository.updateMenuCategoryNameById(Id, newMenuCategoryName);
    }



}
