package com.exe.EscobarIMS.SupplyCategory.ViewEditDeleteSupplyCategory;


import com.exe.EscobarIMS.SupplyCategory.SupplyCategory;
import com.exe.EscobarIMS.SupplyCategory.SupplyCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class ViewEditDeleteSupplyCategoryController {

    @Autowired
    ViewEditDeleteSupplyCategoryRepository viewEditDeleteSupplyCategoryRepository;

    @Autowired
    SupplyCategoryRepository supplyCategoryRepository;

    public List<SupplyCategory> getAllSupplyCategories(){
        return viewEditDeleteSupplyCategoryRepository.getAllSupplyCategories();
    }

    public Long findSupplyCategoryIdBySupplyCategoryName(String supplyCategoryName){
        SupplyCategory currentSupplyCategory = supplyCategoryRepository.findBySupplyCategoryName(supplyCategoryName);
        Long currentSupplyCategoryId = currentSupplyCategory.getSupplyCategoryId();
        return currentSupplyCategoryId;
    }

    @Transactional
    public void deleteAllSupplyCategoriesByName(List<String> supplyCategoryNames){
        viewEditDeleteSupplyCategoryRepository.deleteAllMenuCategoriesByName(supplyCategoryNames);
    }

    @Transactional
    public void editSupplyCategoryNameBySupplyCategoryId(Long Id, String newSupplyCategoryName){
        viewEditDeleteSupplyCategoryRepository.updateMenuCategoryNameById(Id, newSupplyCategoryName);
    }

}
