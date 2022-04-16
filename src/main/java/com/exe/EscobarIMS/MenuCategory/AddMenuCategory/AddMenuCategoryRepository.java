package com.exe.EscobarIMS.MenuCategory.AddMenuCategory;

import com.exe.EscobarIMS.MenuCategory.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddMenuCategoryRepository extends JpaRepository<MenuCategory, Long> {

    @Query(value = "SELECT * from #{#entityName} as m where m.menu_category_name = :menu_category_name", nativeQuery = true)
    MenuCategory findByMenuCategoryName(@Param("menu_category_name") String name);
}