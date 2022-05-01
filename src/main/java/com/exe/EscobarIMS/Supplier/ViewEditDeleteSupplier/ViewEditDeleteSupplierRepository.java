package com.exe.EscobarIMS.Supplier.ViewEditDeleteSupplier;

import com.exe.EscobarIMS.Supplier.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewEditDeleteSupplierRepository extends JpaRepository<Supplier, Long> {


    @Query(value = "SELECT * FROM #{#entityName}",
            nativeQuery = true)
    List<Supplier> getAllSupplier();

    @Query(value = "SELECT * FROM #{#entityName}",
            nativeQuery = true)
    Page<Supplier> getAllPagedSupplier(Pageable pageable);

    @Modifying
    @Query(value = "DELETE FROM #{#entityName} " +
            " WHERE supplier_name IN :listOfSupplierNames",
            nativeQuery = true)
    void deleteAllSupplierByName(@Param("listOfSupplierNames") List<String> names);

    @Modifying
    @Query(value = "UPDATE #{#entityName}" +
            " SET supplier_name = :supplierName," +
            " supplier_address = :supplierAddress," +
            " supplier_contact_number = :supplierContactNumber," +
            " supplier_contact_person = :supplierContactPerson" +
            " WHERE supplier_id = :supplierId",
            nativeQuery = true)
    void updateSupplierById(@Param("supplierId") Long id,
                            @Param("supplierName") String name,
                            @Param("supplierAddress") String address,
                            @Param("supplierContactNumber") String contactNumber,
                            @Param("supplierContactPerson") String contactPerson);
}
