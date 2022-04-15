package com.exe.EscobarIMS.MenuCategory;

import com.exe.EscobarIMS.MenuCategory.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Long> {

    @Query(value = "SELECT * FROM menu_category", nativeQuery = true)
    public List<MenuCategory> findAllMenuCategory();

    @Query(value = "SELECT * from menu_category as m where m.menu_category_name = :menu_category_name", nativeQuery = true)
    MenuCategory findMenuCategoryByName(@Param("menu_category_name") String name);
}