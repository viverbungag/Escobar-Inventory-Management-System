package com.exe.EscobarIMS.Supply.AddSupply;

import com.exe.EscobarIMS.Supplier.Supplier;
import com.exe.EscobarIMS.Supplier.SupplierRepository;
import com.exe.EscobarIMS.Supply.Supply;
import com.exe.EscobarIMS.SupplyCategory.SupplyCategory;
import com.exe.EscobarIMS.SupplyCategory.SupplyCategoryRepository;
import com.exe.EscobarIMS.UnitOfMeasurement.UnitOfMeasurement;
import com.exe.EscobarIMS.UnitOfMeasurement.UnitOfMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AddSupplyController {

    @Autowired
    private AddSupplyRepository addSupplyRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private UnitOfMeasurementRepository unitOfMeasurementRepository;

    @Autowired
    private SupplyCategoryRepository supplyCategoryRepository;

    public void addNewSupply(String supplyName, String supplierName, String unitOfMeasurementName, String supplyCategoryName, Double minimumQuantity){
        Supplier supplier =  supplierRepository.findBySupplierName(supplierName);
        UnitOfMeasurement unitOfMeasurement = unitOfMeasurementRepository.findByUnitOfMeasurementName(unitOfMeasurementName);
        SupplyCategory supplyCategory = supplyCategoryRepository.findBySupplyCategoryName(supplyCategoryName);

        Supply supply = new Supply(supplyName, minimumQuantity, supplier, unitOfMeasurement, supplyCategory);

        addSupplyRepository.save(supply);

    }
}
