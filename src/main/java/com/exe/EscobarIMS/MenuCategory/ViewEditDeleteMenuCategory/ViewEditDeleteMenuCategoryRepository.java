package com.exe.EscobarIMS.MenuCategory.ViewEditDeleteMenuCategory;

import com.exe.EscobarIMS.MenuCategory.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewEditDeleteMenuCategoryRepository extends JpaRepository<MenuCategory, Long> {


    @Query(value = "SELECT * FROM #{#entityName}",
            nativeQuery = true)
    List<MenuCategory> getAllMenuCategories();

    @Modifying
    @Query(value = "DELETE FROM #{#entityName} " +
            "AS m WHERE m.menu_category_name IN :listOfMenuCategoryNames",
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
