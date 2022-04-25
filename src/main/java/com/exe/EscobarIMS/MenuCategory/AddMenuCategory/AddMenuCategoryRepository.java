package com.exe.EscobarIMS.MenuCategory.AddMenuCategory;

import com.exe.EscobarIMS.MenuCategory.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddMenuCategoryRepository extends JpaRepository<MenuCategory, Long> {

}