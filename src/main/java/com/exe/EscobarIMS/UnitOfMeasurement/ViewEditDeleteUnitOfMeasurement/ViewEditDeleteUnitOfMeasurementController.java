package com.exe.EscobarIMS.UnitOfMeasurement.ViewEditDeleteUnitOfMeasurement;

import com.exe.EscobarIMS.UnitOfMeasurement.UnitOfMeasurement;
import com.exe.EscobarIMS.UnitOfMeasurement.UnitOfMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Controller
public class ViewEditDeleteUnitOfMeasurementController {

    @Autowired
    ViewEditDeleteUnitOfMeasurementRepository viewEditDeleteUnitOfMeasurementRepository;

    @Autowired
    UnitOfMeasurementRepository unitOfMeasurementRepository;

    public List<UnitOfMeasurement> getAllPagedMenuCategories(int pageNo, int pageSize, Sort sort){
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        Page<UnitOfMeasurement> pagedMenuCategories = viewEditDeleteUnitOfMeasurementRepository.getAllPagedMenuCategories(pageable);
        return pagedMenuCategories.getContent();
    }

    public Long findMenuCategoryIdByMenuCategoryName(String menuCategoryName){
        UnitOfMeasurement currentUnitOfMeasurement = unitOfMeasurementRepository.findByMenuCategoryName(menuCategoryName);
        Long currentMenuCategoryId = currentUnitOfMeasurement.getUnitOfMeasurementId();
        return currentMenuCategoryId;
    }

    @Transactional
    public void deleteAllMenuCategoriesByName(List<String> menuCategoryNames){
        viewEditDeleteUnitOfMeasurementRepository.deleteAllMenuCategoriesByName(menuCategoryNames);
    }

    @Transactional
    public void editMenuCategoryNameByMenuCategoryId(Long Id, String newMenuCategoryName){
        viewEditDeleteUnitOfMeasurementRepository.updateMenuCategoryNameById(Id, newMenuCategoryName);
    }

    public int getTotalNumberOfPages(int pageSize){
        Pageable pageable = PageRequest.ofSize(pageSize);
        Page<UnitOfMeasurement> pagedMenuCategories =  viewEditDeleteUnitOfMeasurementRepository.getAllPagedMenuCategories(pageable);
        return pagedMenuCategories.getTotalPages();
    }



}
