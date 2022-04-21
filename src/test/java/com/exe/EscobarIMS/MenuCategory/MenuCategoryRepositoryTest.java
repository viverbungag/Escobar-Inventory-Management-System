package com.exe.EscobarIMS.MenuCategory;

import com.exe.EscobarIMS.MenuCategory.AddMenuCategory.AddMenuCategoryRepository;
import com.exe.EscobarIMS.MenuCategory.ViewEditDeleteMenuCategory.ViewEditDeleteMenuCategoryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class MenuCategoryRepositoryTest {

    @Autowired
    ViewEditDeleteMenuCategoryRepository viewEditDeleteMenuCategoryRepository;

    @Autowired
    MenuCategoryRepository menuCategoryRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void Injected_Components_are_not_null(){
        assertNotNull(viewEditDeleteMenuCategoryRepository);
        assertNotNull(menuCategoryRepository);
    }

    @Test
    void findCategoryByName_when_menu_category_name_is_existing(){
        MenuCategory acquiredMenuCategory = menuCategoryRepository.findByMenuCategoryName("Pizza");
        assertNotNull(acquiredMenuCategory);
    }

    @Test
    void findCategoryByName_when_menu_category_name_is_not_existing(){
        MenuCategory acquiredMenuCategory = menuCategoryRepository.findByMenuCategoryName("Fries");
        assertNull(acquiredMenuCategory);
    }

    @Test
    void getAllMenuCategories_when_there_are_3_menu_categories(){
        List<MenuCategory> menuCategories = viewEditDeleteMenuCategoryRepository.getAllMenuCategories();
        assertEquals(menuCategories.size(), 3);
    }

    @Test
    void deleteALlMenuCategoriesByName_when_deleting_2_existing_menu_categories(){
        viewEditDeleteMenuCategoryRepository.deleteAllMenuCategoriesByName(List.of("Pizza", "Pasta"));
        List<MenuCategory> menuCategories = viewEditDeleteMenuCategoryRepository.getAllMenuCategories();
        assertEquals(menuCategories.size(), 1);
    }

    @Test
    void deleteALlMenuCategoriesByName_when_deleting_1_existing_and_1_non_existing_menu_categories(){
        viewEditDeleteMenuCategoryRepository.deleteAllMenuCategoriesByName(List.of("Pizza", "Fries"));
        List<MenuCategory> menuCategories = viewEditDeleteMenuCategoryRepository.getAllMenuCategories();
        assertEquals(menuCategories.size(), 2);
    }

    @Test
    void updateMenuCategoryNameById_when_updating_id_2(){
        viewEditDeleteMenuCategoryRepository.updateMenuCategoryNameById(2L, "Wine");
        MenuCategory acquiredMenuCategory = menuCategoryRepository.findByMenuCategoryId(2L);
        assertEquals(acquiredMenuCategory.getMenuCategoryName(), "Wine");
    }

}
