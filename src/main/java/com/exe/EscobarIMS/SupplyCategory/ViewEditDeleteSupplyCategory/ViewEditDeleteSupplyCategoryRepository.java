package com.exe.EscobarIMS.SupplyCategory.ViewEditDeleteSupplyCategory;

import com.exe.EscobarIMS.SupplyCategory.SupplyCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewEditDeleteSupplyCategoryRepository extends JpaRepository<SupplyCategory, Long> {


    @Query(value = "SELECT * FROM #{#entityName}",
            nativeQuery = true)
    List<SupplyCategory> getAllSupplyCategories();

    @Query(value = "SELECT * FROM #{#entityName}",
            nativeQuery = true)
    Page<SupplyCategory> getAllPagedSupplyCategories(Pageable pageable);

    @Modifying
    @Query(value = "DELETE FROM #{#entityName} " +
            "WHERE supply_category_name IN :listOfMenuCategoryNames",
    nativeQuery = true)
    void deleteAllMenuCategoriesByName(@Param("listOfMenuCategoryNames") List<String> names);

    @Modifying
    @Query(value = "UPDATE #{#entityName} " +
            "SET supply_category_name = :newSupplyCategoryName " +
            "WHERE supply_category_id = :supplyCategoryId",
            nativeQuery = true)
    void updateMenuCategoryNameById(@Param("supplyCategoryId") Long id,
                                    @Param("newSupplyCategoryName") String name);



}
