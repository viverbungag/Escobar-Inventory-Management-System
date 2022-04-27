package com.exe.EscobarIMS.UnitOfMeasurement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitOfMeasurementRepository extends JpaRepository<UnitOfMeasurement, Long> {

    @Query(value = "SELECT * FROM #{#entityName} AS m WHERE m.menu_category_name = :menuCategoryName",
            nativeQuery = true)
    UnitOfMeasurement findByMenuCategoryName(@Param("menuCategoryName") String name);

    @Query(value = "SELECT * FROM #{#entityName} AS m WHERE m.menu_category_id = :menuCategoryId",
            nativeQuery = true)
    UnitOfMeasurement findByMenuCategoryId(@Param("menuCategoryId") Long id);

}
