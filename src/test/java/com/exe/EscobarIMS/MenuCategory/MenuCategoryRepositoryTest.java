package com.exe.EscobarIMS.MenuCategory;

import com.exe.EscobarIMS.MenuCategory.AddMenuCategory.AddMenuCategoryRepository;
import com.exe.EscobarIMS.MenuCategory.ViewEditDeleteMenuCategory.ViewEditDeleteMenuCategoryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class MenuCategoryRepositoryTest {

    @Autowired AddMenuCategoryRepository addMenuCategoryRepository;
    @Autowired ViewEditDeleteMenuCategoryRepository viewEditDeleteMenuCategoryRepository;
    @Autowired MenuCategoryRepository menuCategoryRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void Injected_Components_are_not_null(){
        assertNotNull(addMenuCategoryRepository);
        assertNotNull(viewEditDeleteMenuCategoryRepository);
        assertNotNull(menuCategoryRepository);
    }

    @Test
    void findCategoryByName_when_menu_category_name_is_existing(){
        MenuCategory acquiredMenuCategory = menuCategoryRepository.findByMenuCategoryName("Menu Category 1");
        assertNotNull(acquiredMenuCategory);
    }

    @Test
    void findCategoryByName_when_menu_category_name_is_not_existing(){
        MenuCategory acquiredMenuCategory = menuCategoryRepository.findByMenuCategoryName("Menu Category 0");
        assertNull(acquiredMenuCategory);
    }

    @Test
    void getAllMenuCategories_when_there_are_24_menu_categories(){
        List<MenuCategory> menuCategories = viewEditDeleteMenuCategoryRepository.getAllMenuCategories();
        assertEquals(menuCategories.size(), 16);
    }

    @Test
    void deleteALlMenuCategoriesByName_when_deleting_2_existing_menu_categories(){
        Integer oldSize = viewEditDeleteMenuCategoryRepository.getAllMenuCategories().size();
        viewEditDeleteMenuCategoryRepository.deleteAllMenuCategoriesByName(List.of("Menu Category 1", "Menu Category 2"));
        Integer newSize = viewEditDeleteMenuCategoryRepository.getAllMenuCategories().size();
        assertEquals(oldSize-2, newSize);
    }

    @Test
    void deleteALlMenuCategoriesByName_when_deleting_1_existing_and_1_non_existing_menu_categories(){
        Integer oldSize = viewEditDeleteMenuCategoryRepository.getAllMenuCategories().size();
        viewEditDeleteMenuCategoryRepository.deleteAllMenuCategoriesByName(List.of("Menu Category 0", "Menu Category 1"));
        Integer newSize = viewEditDeleteMenuCategoryRepository.getAllMenuCategories().size();
        assertEquals(oldSize-1, newSize);
    }

    @Test
    void updateMenuCategoryNameById_when_updating_id_2(){
        viewEditDeleteMenuCategoryRepository.updateMenuCategoryNameById(2L, "Updated Menu Category 2");
        MenuCategory acquiredMenuCategory = menuCategoryRepository.findByMenuCategoryId(2L);
        assertEquals(acquiredMenuCategory.getMenuCategoryName(), "Updated Menu Category 2");
    }

    @Test
    void getAllPagedMenuCategories_when_page_is_0_and_the_size_is_5(){
        Pageable pageable = PageRequest.of(0, 5);
        Page<MenuCategory> pagedMenuCategories =  viewEditDeleteMenuCategoryRepository.getAllPagedMenuCategories(pageable);
        assertEquals(5, pagedMenuCategories.getContent().size());
    }

    @Test
    void getAllPagedMenuCategories_when_page_is_3_and_the_size_is_5(){
        Pageable pageable = PageRequest.of(3, 5);
        Page<MenuCategory> pagedMenuCategories =  viewEditDeleteMenuCategoryRepository.getAllPagedMenuCategories(pageable);
        assertEquals(1, pagedMenuCategories.getContent().size());
    }

    @Test
    void getAllPagedMenuCategories_when_getting_the_total_pages_and_the_size_is_15(){
        Pageable pageable = PageRequest.ofSize(15);
        Page<MenuCategory> pagedMenuCategories =  viewEditDeleteMenuCategoryRepository.getAllPagedMenuCategories(pageable);
        assertEquals(2, pagedMenuCategories.getTotalPages());
    }

    @Test
    void getAllPagedMenuCategories_when_getting_the_first_menu_category_name_sorted_by_category_name_ascending(){
        Sort sort = Sort.by("menu_category_name").ascending();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<MenuCategory> menuCategories =  viewEditDeleteMenuCategoryRepository.getAllPagedMenuCategories(pageable).getContent();
        assertEquals("Menu Category 1", menuCategories.get(0).getMenuCategoryName());
    }

    @Test
    void getAllPagedMenuCategories_when_getting_the_last_menu_category_name_sorted_by_category_name_descending(){
        Sort sort = Sort.by("menu_category_name").descending();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<MenuCategory> menuCategories =  viewEditDeleteMenuCategoryRepository.getAllPagedMenuCategories(pageable).getContent();
        assertEquals("Menu Category 1", menuCategories.get(menuCategories.size()-1).getMenuCategoryName());
    }

    @Test
    void getAllPagedMenuCategories_when_getting_the_first_menu_category_name_not_sorted(){
        Sort sort = Sort.unsorted();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<MenuCategory> menuCategories =  viewEditDeleteMenuCategoryRepository.getAllPagedMenuCategories(pageable).getContent();
        assertEquals("Menu Category 1", menuCategories.get(0).getMenuCategoryName());
    }

}
