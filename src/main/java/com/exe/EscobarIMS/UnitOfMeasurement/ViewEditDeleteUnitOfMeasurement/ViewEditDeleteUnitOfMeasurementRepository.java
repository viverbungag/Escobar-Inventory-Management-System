package com.exe.EscobarIMS.UnitOfMeasurement.ViewEditDeleteUnitOfMeasurement;

import com.exe.EscobarIMS.UnitOfMeasurement.UnitOfMeasurement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewEditDeleteUnitOfMeasurementRepository extends JpaRepository<UnitOfMeasurement, Long> {


    @Query(value = "SELECT * FROM #{#entityName}",
            nativeQuery = true)
    List<UnitOfMeasurement> getAllMenuCategories();

    @Query(value = "SELECT * FROM #{#entityName}",
            nativeQuery = true)
    Page<UnitOfMeasurement> getAllPagedMenuCategories(Pageable pageable);

    @Modifying
    @Query(value = "DELETE FROM #{#entityName} " +
            " WHERE menu_category_name IN :listOfMenuCategoryNames",
            nativeQuery = true)
    void deleteAllMenuCategoriesByName(@Param("listOfMenuCategoryNames") List<String> names);

    @Modifying
    @Query(value = "UPDATE #{#entityName} " +
            "AS m SET m.menu_category_name = :newMenuCategoryName " +
            "WHERE m.menu_category_id = :menuCategoryId",
            nativeQuery = true)
    void updateMenuCategoryNameById(@Param("menuCategoryId") Long id,
                                    @Param("newMenuCategoryName") String name);
}
