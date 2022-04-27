package com.exe.EscobarIMS.UnitOfMeasurement.AddUnitOfMeasurement;

import com.exe.EscobarIMS.UnitOfMeasurement.UnitOfMeasurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AddUnitOfMeasurementController {

    @Autowired
    private AddUnitOfMeasurementRepository addUnitOfMeasurementRepository;

    public void addNewMenuCategory(String unitOfMeasurementName, String unitOfMeasurementAbbreviation){
        UnitOfMeasurement newUnitOfMeasurement = new UnitOfMeasurement(unitOfMeasurementName, unitOfMeasurementAbbreviation);
        addUnitOfMeasurementRepository.save(newUnitOfMeasurement);
    }
}
