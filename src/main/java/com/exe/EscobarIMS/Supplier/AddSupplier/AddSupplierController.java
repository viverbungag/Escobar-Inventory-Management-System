package com.exe.EscobarIMS.Supplier.AddSupplier;

import com.exe.EscobarIMS.Supplier.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AddSupplierController {

    @Autowired
    private AddSupplierRepository addSupplierRepository;

    public void addNewSupplier(String supplierName, String supplierAddress, String supplierContactNumber, String supplierContactPerson){
        Supplier newSupplier = new Supplier(supplierName, supplierAddress, supplierContactNumber, supplierContactPerson);
        addSupplierRepository.save(newSupplier);
    }
}
