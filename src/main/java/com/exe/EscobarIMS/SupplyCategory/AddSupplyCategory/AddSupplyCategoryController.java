package com.exe.EscobarIMS.SupplyCategory.AddSupplyCategory;

import com.exe.EscobarIMS.SupplyCategory.SupplyCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AddSupplyCategoryController {


    @Autowired
    AddSupplyCategoryRepository addSupplyCategoryRepository;

    public void addNewSupplyCategory(String supplyCategoryName){
        SupplyCategory newSupplyCategory = new SupplyCategory(supplyCategoryName);
        addSupplyCategoryRepository.save(newSupplyCategory);
    }
}
