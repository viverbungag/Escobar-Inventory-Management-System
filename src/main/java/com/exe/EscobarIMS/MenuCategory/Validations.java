package com.exe.EscobarIMS.MenuCategory;

import com.exe.EscobarIMS.MenuCategory.AddMenuCategory.AddMenuCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class Validations {

    @Autowired
    private AddMenuCategoryRepository addMenuCategoryRepository;


    public boolean isMenuCategoryExisting(String menuCategoryName){
        return addMenuCategoryRepository.findByMenuCategoryName(menuCategoryName) != null;
    }

    public boolean hasExistingTableContents(JTable table){
        return table.getSelectedRowCount() > 0;
    }
}
