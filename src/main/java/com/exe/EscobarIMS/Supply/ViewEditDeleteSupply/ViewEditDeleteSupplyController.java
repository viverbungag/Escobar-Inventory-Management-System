package com.exe.EscobarIMS.Supply.ViewEditDeleteSupply;

import com.exe.EscobarIMS.Supplier.Supplier;
import com.exe.EscobarIMS.Supplier.SupplierRepository;
import com.exe.EscobarIMS.Supply.Supply;
import com.exe.EscobarIMS.Supply.SupplyRepository;
import com.exe.EscobarIMS.SupplyCategory.SupplyCategory;
import com.exe.EscobarIMS.SupplyCategory.SupplyCategoryRepository;
import com.exe.EscobarIMS.UnitOfMeasurement.UnitOfMeasurement;
import com.exe.EscobarIMS.UnitOfMeasurement.UnitOfMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class ViewEditDeleteSupplyController {
    @Autowired
    ViewEditDeleteSupplyRepository viewEditDeleteSupplyRepository;

    @Autowired
    SupplyRepository supplyRepository;

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    UnitOfMeasurementRepository unitOfMeasurementRepository;

    @Autowired
    SupplyCategoryRepository supplyCategoryRepository;

    public List<Supply> getAllPagedSupplies(int pageNo, int pageSize, Sort sort){
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        Page<Supply> supplies = viewEditDeleteSupplyRepository.getAllPagedSupplies(pageable);
        return supplies.getContent();
    }

    public List<Supply> getAllSupply(){
        List<Supply> supplies = viewEditDeleteSupplyRepository.getAllSupply();
        return supplies;
    }

    public int getTotalNumberOfPages(int pageSize){
        Pageable pageable = PageRequest.ofSize(pageSize);
        Page<Supply> supplies =  viewEditDeleteSupplyRepository.getAllPagedSupplies(pageable);
        return supplies.getTotalPages();
    }

    @Transactional
    public void editSupplyById(String selectedSupplyName, String newSupplyName,
                               Double newMinimumQuantity, String newSupplierName,
                               String newUnitOfMeasurementName, String newSupplyCategoryName){

        Long supplyId = findSupplyIdByName(selectedSupplyName);
        Long supplierId = findSupplierIdByName(newSupplierName);
        Long unitOfMeasurementId = findUnitOfMeasurementIdByName(newUnitOfMeasurementName);
        Long supplyCategoryId = findSupplyCategoryIdByName(newSupplyCategoryName);

        viewEditDeleteSupplyRepository.updateSupplyById(supplyId, newSupplyName, supplierId, unitOfMeasurementId, supplyCategoryId, newMinimumQuantity);
    }

    public Long findSupplyIdByName(String supplyName){
        Supply supply = supplyRepository.findBySupplyName(supplyName);
        Long supplyId = supply.getSupplyId();
        return supplyId;
    }

    public Long findSupplierIdByName(String supplierName){
        Supplier supplier = supplierRepository.findBySupplierName(supplierName);
        Long supplierId = supplier.getSupplierId();
        return supplierId;
    }

    public Long findUnitOfMeasurementIdByName(String unitOfMeasurementName){
        UnitOfMeasurement unitOfMeasurement = unitOfMeasurementRepository.findByUnitOfMeasurementName(unitOfMeasurementName);
        Long unitOfMeasurementId = unitOfMeasurement.getUnitOfMeasurementId();
        return unitOfMeasurementId;
    }

    public Long findSupplyCategoryIdByName(String supplyCategoryName){
        SupplyCategory supplyCategory = supplyCategoryRepository.findBySupplyCategoryName(supplyCategoryName);
        Long supplyCategoryId = supplyCategory.getSupplyCategoryId();
        return supplyCategoryId;
    }
}
