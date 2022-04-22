package com.exe.EscobarIMS.SupplyCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SupplyCategoryRepository extends JpaRepository<SupplyCategory, Long> {

    @Query(value = "SELECT * FROM #{#entityName} WHERE supply_category_name = :supplyCategoryName",
            nativeQuery = true)
    SupplyCategory findBySupplyCategoryName(@Param("supplyCategoryName") String name);

    @Query(value = "SELECT * FROM #{#entityName} WHERE supply_category_id = :supplyCategoryId",
            nativeQuery = true)
    SupplyCategory findBySupplyCategoryId(@Param("supplyCategoryId") Long id);
}
