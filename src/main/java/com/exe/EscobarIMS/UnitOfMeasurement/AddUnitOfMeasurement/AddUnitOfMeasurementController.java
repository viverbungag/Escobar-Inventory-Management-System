package com.exe.EscobarIMS.UnitOfMeasurement.AddUnitOfMeasurement;

import com.exe.EscobarIMS.UnitOfMeasurement.UnitOfMeasurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AddUnitOfMeasurementController {

    @Autowired
    private AddUnitOfMeasurementRepository addUnitOfMeasurementRepository;

    public void addNewMenuCategory(String menuCategoryName){
        UnitOfMeasurement newUnitOfMeasurement = new UnitOfMeasurement(menuCategoryName);
        addUnitOfMeasurementRepository.save(newUnitOfMeasurement);
    }
}
