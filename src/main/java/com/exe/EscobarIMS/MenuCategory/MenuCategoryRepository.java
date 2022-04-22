package com.exe.EscobarIMS.MenuCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Long> {

    @Query(value = "SELECT * FROM #{#entityName} AS m WHERE m.menu_category_name = :menuCategoryName",
            nativeQuery = true)
    MenuCategory findByMenuCategoryName(@Param("menuCategoryName") String name);

    @Query(value = "SELECT * FROM #{#entityName} AS m WHERE m.menu_category_id = :menuCategoryId",
            nativeQuery = true)
    MenuCategory findByMenuCategoryId(@Param("menuCategoryId") Long id);

}
