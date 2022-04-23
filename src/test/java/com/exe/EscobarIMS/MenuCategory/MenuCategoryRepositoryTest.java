package com.exe.EscobarIMS.MenuCategory;

import com.exe.EscobarIMS.MenuCategory.ViewEditDeleteMenuCategory.ViewEditDeleteMenuCategoryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        assertEquals(menuCategories.size(), 24);
    }

    @Test
    void deleteALlMenuCategoriesByName_when_deleting_2_existing_menu_categories(){
        Integer oldSize = viewEditDeleteMenuCategoryRepository.getAllMenuCategories().size();
        viewEditDeleteMenuCategoryRepository.deleteAllMenuCategoriesByName(List.of("Pizza", "Pasta"));
        Integer newSize = viewEditDeleteMenuCategoryRepository.getAllMenuCategories().size();
        assertEquals(oldSize-2, newSize);
    }

    @Test
    void deleteALlMenuCategoriesByName_when_deleting_1_existing_and_1_non_existing_menu_categories(){
        Integer oldSize = viewEditDeleteMenuCategoryRepository.getAllMenuCategories().size();
        viewEditDeleteMenuCategoryRepository.deleteAllMenuCategoriesByName(List.of("Pizza", "Fries"));
        Integer newSize = viewEditDeleteMenuCategoryRepository.getAllMenuCategories().size();
        assertEquals(oldSize-1, newSize);
    }

    @Test
    void updateMenuCategoryNameById_when_updating_id_2(){
        viewEditDeleteMenuCategoryRepository.updateMenuCategoryNameById(2L, "Wine");
        MenuCategory acquiredMenuCategory = menuCategoryRepository.findByMenuCategoryId(2L);
        assertEquals(acquiredMenuCategory.getMenuCategoryName(), "Wine");
    }

    @Test
    void getAllPagedMenuCategories_when_page_is_0_and_there_are_15_per_page(){
        Pageable pageable = PageRequest.of(0, 15);
        Page<MenuCategory> pagedMenuCategories =  viewEditDeleteMenuCategoryRepository.getAllPagedMenuCategories(pageable);
        assertEquals(15, pagedMenuCategories.getContent().size());
    }

    @Test
    void getAllPagedMenuCategories_when_page_is_1_and_the_size_is_15(){
        Pageable pageable = PageRequest.of(1, 15);
        Page<MenuCategory> pagedMenuCategories =  viewEditDeleteMenuCategoryRepository.getAllPagedMenuCategories(pageable);
        assertEquals(9, pagedMenuCategories.getContent().size());
    }

    @Test
    void getAllPagedMenuCategories_when_getting_the_total_pages_and_the_size_is_15(){
        Pageable pageable = PageRequest.ofSize(15);
        Page<MenuCategory> pagedMenuCategories =  viewEditDeleteMenuCategoryRepository.getAllPagedMenuCategories(pageable);
        assertEquals(2, pagedMenuCategories.getTotalPages());
    }

    @Test
    void getAllPagedMenuCategories_when_sorted_by_category_name_ascending(){
        Sort sort = Sort.by("menu_category_name").ascending();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<MenuCategory> menuCategories =  viewEditDeleteMenuCategoryRepository.getAllPagedMenuCategories(pageable).getContent();
        assertEquals("Zebra", menuCategories.get(menuCategories.size()-1).getMenuCategoryName());
    }

    @Test
    void getAllPagedMenuCategories_when_sorted_by_category_name_descending(){
        Sort sort = Sort.by("menu_category_name").descending();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<MenuCategory> menuCategories =  viewEditDeleteMenuCategoryRepository.getAllPagedMenuCategories(pageable).getContent();
        assertEquals("Zebra", menuCategories.get(0).getMenuCategoryName());
    }

    @Test
    void getAllPagedMenuCategories_when_not_sorted(){
        Sort sort = Sort.unsorted();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<MenuCategory> menuCategories =  viewEditDeleteMenuCategoryRepository.getAllPagedMenuCategories(pageable).getContent();
        assertEquals("Pizza", menuCategories.get(0).getMenuCategoryName());
    }

}
