package com.exe.EscobarIMS.Supplier.ViewEditDeleteSupplier;

import com.exe.EscobarIMS.Supplier.Supplier;
import com.exe.EscobarIMS.Supplier.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Controller
public class ViewEditDeleteSupplierController {

    @Autowired
    ViewEditDeleteSupplierRepository viewEditDeleteSupplierRepository;

    @Autowired
    SupplierRepository supplierRepository;

    public List<Supplier> getAllPagedSupplier(int pageNo, int pageSize, Sort sort){
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        Page<Supplier> pagedSupplier = viewEditDeleteSupplierRepository.getAllPagedSupplier(pageable);
        return pagedSupplier.getContent();
    }

    public List<Supplier> getAllSupplier(){
        List<Supplier> suppliers = viewEditDeleteSupplierRepository.getAllSupplier();
        return suppliers;
    }

    public Long findSupplierIdByName(String supplierName){
        Supplier currentSupplier = supplierRepository.findBySupplierName(supplierName);
        Long currentSupplierId = currentSupplier.getSupplierId();
        return currentSupplierId;
    }

    @Transactional
    public void deleteAllSupplierByName(List<String> supplierNames){
        viewEditDeleteSupplierRepository.deleteAllSupplierByName(supplierNames);
    }

    @Transactional
    public void editSupplierNameById(Long Id, String newName, String newAddress, String newContactNumber, String newContactPerson){
        viewEditDeleteSupplierRepository.updateSupplierById(Id, newName, newAddress, newContactNumber, newContactPerson);
    }

    public int getTotalNumberOfPages(int pageSize){
        Pageable pageable = PageRequest.ofSize(pageSize);
        Page<Supplier> pagedSupplier =  viewEditDeleteSupplierRepository.getAllPagedSupplier(pageable);
        return pagedSupplier.getTotalPages();
    }



}
