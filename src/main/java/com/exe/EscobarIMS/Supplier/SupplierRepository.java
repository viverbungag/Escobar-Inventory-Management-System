package com.exe.EscobarIMS.Supplier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    @Query(value = "SELECT * FROM #{#entityName} WHERE supplier_name = :supplierName",
            nativeQuery = true)
    Supplier findBySupplierName(@Param("supplierName") String name);

    @Query(value = "SELECT * FROM #{#entityName} WHERE supplier_id = :supplierId",
            nativeQuery = true)
    Supplier findBySupplierId(@Param("supplierId") Long id);

}
