package com.exe.EscobarIMS.Supply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplyRepository extends JpaRepository<Supply, Long> {

    @Query(value = "SELECT * FROM #{#entityName} WHERE supply_name = :supplyName",
            nativeQuery = true)
    Supply findBySupplyName(@Param("supplyName")String name);

    @Query(value = "SELECT * FROM #{#entityName} " +
            "WHERE supply_name = :supplyName AND supplier_id = :supplierId",
            nativeQuery = true)
    Supply findBySupplyNameAndCategory(@Param("supplyName")String name, @Param("supplierId")Long supplierId);

    @Query(value = "SELECT * FROM #{#entityName} WHERE supply_id = :supplyId",
            nativeQuery = true)
    Supply findBySupplyId(@Param("supplyId") Long id);
}
