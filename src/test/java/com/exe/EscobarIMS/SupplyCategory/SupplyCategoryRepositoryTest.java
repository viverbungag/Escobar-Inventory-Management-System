package com.exe.EscobarIMS.SupplyCategory;

import com.exe.EscobarIMS.SupplyCategory.ViewEditDeleteSupplyCategory.ViewEditDeleteSupplyCategoryRepository;
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
class SupplyCategoryRepositoryTest {

    @Autowired
    ViewEditDeleteSupplyCategoryRepository viewEditDeleteSupplyCategoryRepository;

    @Autowired
    SupplyCategoryRepository supplyCategoryRepository;

    @Test
    void Injected_Components_are_not_null(){
        assertNotNull(viewEditDeleteSupplyCategoryRepository);
        assertNotNull(supplyCategoryRepository);
    }

    @Test
    void getAllSupplyCategories_when_there_are_24_existing_supply_categories(){
        List<SupplyCategory> supplyCategories = viewEditDeleteSupplyCategoryRepository.getAllSupplyCategories();
        assertEquals(supplyCategories.size(), 16);
    }

    @Test
    void findBySupplyCategoryName_when_supply_category_name_is_existing(){
        SupplyCategory supplyCategory = supplyCategoryRepository.findBySupplyCategoryName("Supply Category 1");
        assertNotNull(supplyCategory);
    }

    @Test
    void findBySupplyCategory_when_supply_category_name_is_not_existing(){
        SupplyCategory supplyCategory = supplyCategoryRepository.findBySupplyCategoryName("Supply Category 0");
        assertNull(supplyCategory);
    }

    @Test
    void deleteAllMenuCategoriesByName_when_deleting_2_existing_supply_categories(){
        List<SupplyCategory> oldSupplyCategories = viewEditDeleteSupplyCategoryRepository.getAllSupplyCategories();
        Integer oldSize = oldSupplyCategories.size();
        viewEditDeleteSupplyCategoryRepository.deleteAllMenuCategoriesByName(List.of("Supply Category 1", "Supply Category 2"));
        List<SupplyCategory> newSupplyCategories = viewEditDeleteSupplyCategoryRepository.getAllSupplyCategories();
        Integer newSize = newSupplyCategories.size();
        assertEquals(oldSize-2, newSize);
    }

    @Test
    void deleteAllMenuCategoriesByName_when_deleting_1_existing_and_1_non_existing_supply_categories(){
        List<SupplyCategory> oldSupplyCategories = viewEditDeleteSupplyCategoryRepository.getAllSupplyCategories();
        Integer oldSize = oldSupplyCategories.size();
        viewEditDeleteSupplyCategoryRepository.deleteAllMenuCategoriesByName(List.of("Supply Category 0", "Supply Category 1"));
        List<SupplyCategory> newSupplyCategories = viewEditDeleteSupplyCategoryRepository.getAllSupplyCategories();
        Integer newSize = newSupplyCategories.size();
        assertEquals(oldSize-1, newSize);
    }

    @Test
    void updateMenuCategoryNameById_when_updating_id_3(){
        viewEditDeleteSupplyCategoryRepository.updateMenuCategoryNameById(3L, "Updated Supply Category 3");
        SupplyCategory supplyCategory = supplyCategoryRepository.findBySupplyCategoryId(3L);
        assertEquals(supplyCategory.getSupplyCategoryName(), "Updated Supply Category 3");
    }

    @Test
    void getAllPagedSupplyCategories_when_page_is_0_and_the_size_is_5(){
        Pageable pageable = PageRequest.of(0, 5);
        Page<SupplyCategory> pagedSupplyCategories =  viewEditDeleteSupplyCategoryRepository.getAllPagedSupplyCategories(pageable);
        assertEquals(5, pagedSupplyCategories.getContent().size());
    }

    @Test
    void getAllPagedSupplyCategories_when_page_is_3_and_the_size_is_5(){
        Pageable pageable = PageRequest.of(3, 5);
        Page<SupplyCategory> pagedSupplyCategories =  viewEditDeleteSupplyCategoryRepository.getAllPagedSupplyCategories(pageable);
        assertEquals(1, pagedSupplyCategories.getContent().size());
    }

    @Test
    void getAllPagedSupplyCategories_when_getting_the_total_pages_and_the_size_is_15(){
        Pageable pageable = PageRequest.ofSize(15);
        Page<SupplyCategory> pagedSupplyCategories =  viewEditDeleteSupplyCategoryRepository.getAllPagedSupplyCategories(pageable);
        assertEquals(2, pagedSupplyCategories.getTotalPages());
    }

    @Test
    void getAllPagedSupplyCategories_when_getting_the_first_supply_category_name_sorted_by_category_name_ascending(){
        Sort sort = Sort.by("supply_category_name").ascending();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<SupplyCategory> supplyCategories =  viewEditDeleteSupplyCategoryRepository.getAllPagedSupplyCategories(pageable).getContent();
        assertEquals("Supply Category 1", supplyCategories.get(0).getSupplyCategoryName());
    }

    @Test
    void getAllPagedSupplyCategories_when_getting_the_last_supply_category_name_sorted_by_category_name_descending(){
        Sort sort = Sort.by("supply_category_name").descending();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<SupplyCategory> supplyCategories =  viewEditDeleteSupplyCategoryRepository.getAllPagedSupplyCategories(pageable).getContent();
        assertEquals("Supply Category 1", supplyCategories.get(supplyCategories.size()-1).getSupplyCategoryName());
    }

    @Test
    void getAllPagedSupplyCategories_when_getting_the_first_supply_category_name_not_sorted(){
        Sort sort = Sort.by("supply_category_name").unsorted();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<SupplyCategory> supplyCategories =  viewEditDeleteSupplyCategoryRepository.getAllPagedSupplyCategories(pageable).getContent();
        assertEquals("Supply Category 1", supplyCategories.get(0).getSupplyCategoryName());
    }







}