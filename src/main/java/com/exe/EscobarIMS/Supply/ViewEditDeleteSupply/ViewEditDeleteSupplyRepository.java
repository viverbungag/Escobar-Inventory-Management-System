package com.exe.EscobarIMS.Supply.ViewEditDeleteSupply;

import com.exe.EscobarIMS.Supply.Supply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewEditDeleteSupplyRepository extends JpaRepository<Supply, Long> {

    @Query(value = "SELECT * FROM #{#entityName}",
            nativeQuery = true)
    List<Supply> getAllSupply();

    @Query(value = "SELECT * FROM supply AS supply" +
            " INNER JOIN supplier AS supplier ON supply.supplier_id = supplier.supplier_id" +
            " INNER JOIN unit_of_measurement AS unit_of_measurement ON supply.unit_of_measurement_id = unit_of_measurement.unit_of_measurement_id" +
            " INNER JOIN supply_category AS supply_category ON supply.supply_category_id = supply_category.supply_category_id",
            nativeQuery = true)
    Page<Supply> getAllPagedSupplies(Pageable pageable);

    @Modifying
    @Query(value = "DELETE FROM #{#entityName}" +
            " WHERE supply_name IN :supplyNames",
            nativeQuery = true)
    void deleteAllSupplyByName(@Param("supplyNames")List<String> names);

    @Modifying
    @Query(value = "UPDATE #{#entityName}" +
            " SET supply_name = :supplyName," +
            " supplier_id = :supplierId," +
            " unit_of_measurement_id = :unitOfMeasurementId," +
            " supply_category_id = :supplyCategoryId," +
            " minimum_quantity = :minimumQuantity" +
            " WHERE supply_id = :supplyId",
            nativeQuery = true)
    void updateSupplyById(@Param("supplyId") Long id,
                          @Param("supplyName") String name,
                          @Param("supplierId") Long supplierId,
                          @Param("unitOfMeasurementId") Long unitOfMeasurementId,
                          @Param("supplyCategoryId") Long supplyCategoryId,
                          @Param("minimumQuantity") Double minimumQuantity);
}
