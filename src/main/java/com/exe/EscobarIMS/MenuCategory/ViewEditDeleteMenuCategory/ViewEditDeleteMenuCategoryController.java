package com.exe.EscobarIMS.MenuCategory.ViewEditDeleteMenuCategory;

import com.exe.EscobarIMS.MenuCategory.MenuCategory;
import com.exe.EscobarIMS.MenuCategory.MenuCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Controller
public class ViewEditDeleteMenuCategoryController {

    @Autowired
    ViewEditDeleteMenuCategoryRepository viewEditDeleteMenuCategoryRepository;

    @Autowired
    MenuCategoryRepository menuCategoryRepository;

    public List<MenuCategory> getAllPagedMenuCategories(int pageNo, int pageSize, Sort sort){
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        Page<MenuCategory> pagedMenuCategories = viewEditDeleteMenuCategoryRepository.getAllPagedMenuCategories(pageable);
        return pagedMenuCategories.getContent();
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

    public int getTotalNumberOfPages(int pageSize){
        Pageable pageable = PageRequest.ofSize(pageSize);
        Page<MenuCategory> pagedMenuCategories =  viewEditDeleteMenuCategoryRepository.getAllPagedMenuCategories(pageable);
        return pagedMenuCategories.getTotalPages();
    }



}
