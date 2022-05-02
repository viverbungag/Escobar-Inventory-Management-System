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

    public List<UnitOfMeasurement> getAllPagedUnitOfMeasurement(int pageNo, int pageSize, Sort sort){
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        Page<UnitOfMeasurement> pagedUnitOfMeasurement = viewEditDeleteUnitOfMeasurementRepository.getAllPagedUnitOfMeasurement(pageable);
        return pagedUnitOfMeasurement.getContent();
    }

    public List<UnitOfMeasurement> getAllUnitOfMeasurement(){
        List<UnitOfMeasurement> unitOfMeasurements = viewEditDeleteUnitOfMeasurementRepository.getAllUnitOfMeasurements();
        return unitOfMeasurements;
    }

    public Long findUnitOfMeasurementIdByName(String unitOfMeasurementName){
        UnitOfMeasurement currentUnitOfMeasurement = unitOfMeasurementRepository.findByUnitOfMeasurementName(unitOfMeasurementName);
        Long currentUnitOfMeasurementId = currentUnitOfMeasurement.getUnitOfMeasurementId();
        return currentUnitOfMeasurementId;
    }

    @Transactional
    public void deleteAllUnitOfMeasurementByName(List<String> unitOfMeasurementNames){
        viewEditDeleteUnitOfMeasurementRepository.deleteAllUnitOfMeasurementByName(unitOfMeasurementNames);
    }

    @Transactional
    public void editUnitOfMeasurementNameById(Long Id, String newMenuCategoryName, String newAbbreviation){
        viewEditDeleteUnitOfMeasurementRepository.updateUnitOfMeasurementNameById(Id, newMenuCategoryName, newAbbreviation);
    }

    public int getTotalNumberOfPages(int pageSize){
        Pageable pageable = PageRequest.ofSize(pageSize);
        Page<UnitOfMeasurement> pagedUnitOfMeasurement =  viewEditDeleteUnitOfMeasurementRepository.getAllPagedUnitOfMeasurement(pageable);
        return pagedUnitOfMeasurement.getTotalPages();
    }



}
