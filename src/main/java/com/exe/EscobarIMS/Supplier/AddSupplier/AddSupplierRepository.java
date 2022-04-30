package com.exe.EscobarIMS.Supplier.AddSupplier;

import com.exe.EscobarIMS.Supplier.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddSupplierRepository extends JpaRepository<Supplier, Long> {

}