package com.exe.EscobarIMS.SupplyCategory;

import com.exe.EscobarIMS.SupplyCategory.ViewEditDeleteSupplyCategory.ViewEditDeleteSupplyCategoryRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
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

    @Disabled
    @Test
    void getAllSupplyCategories_when_there_are_3_existing_supply_categories(){
        List<SupplyCategory> supplyCategories = viewEditDeleteSupplyCategoryRepository.getAllSupplyCategories();
        assertEquals(supplyCategories.size(), 3);
    }

    @Test
    void findBySupplyCategoryName_when_supply_category_name_is_existing(){
        SupplyCategory supplyCategory = supplyCategoryRepository.findBySupplyCategoryName("Drinks");
        assertNotNull(supplyCategory);
    }

    @Test
    void findBySupplyCategory_when_supply_category_name_is_not_existing(){
        SupplyCategory supplyCategory = supplyCategoryRepository.findBySupplyCategoryName("Fish");
        assertNull(supplyCategory);
    }

    @Test
    void deleteAllMenuCategoriesByName_when_deleting_2_existing_supply_categories(){
        List<SupplyCategory> oldSupplyCategories = viewEditDeleteSupplyCategoryRepository.getAllSupplyCategories();
        Integer oldSize = oldSupplyCategories.size();
        viewEditDeleteSupplyCategoryRepository.deleteAllMenuCategoriesByName(List.of("Vegetables", "Meat"));
        List<SupplyCategory> newSupplyCategories = viewEditDeleteSupplyCategoryRepository.getAllSupplyCategories();
        Integer newSize = newSupplyCategories.size();
        assertEquals(oldSize-2, newSize);
    }

    @Test
    void deleteAllMenuCategoriesByName_when_deleting_1_existing_and_1_non_existing_supply_categories(){
        List<SupplyCategory> oldSupplyCategories = viewEditDeleteSupplyCategoryRepository.getAllSupplyCategories();
        Integer oldSize = oldSupplyCategories.size();
        viewEditDeleteSupplyCategoryRepository.deleteAllMenuCategoriesByName(List.of("Vegetables", "Fish"));
        List<SupplyCategory> newSupplyCategories = viewEditDeleteSupplyCategoryRepository.getAllSupplyCategories();
        Integer newSize = newSupplyCategories.size();
        assertEquals(oldSize-1, newSize);
    }

    @Test
    void updateMenuCategoryNameById_when_updating_id_3(){
        viewEditDeleteSupplyCategoryRepository.updateMenuCategoryNameById(3L, "Fish");
        SupplyCategory supplyCategory = supplyCategoryRepository.findBySupplyCategoryId(3L);
        assertEquals(supplyCategory.getSupplyCategoryName(), "Fish");
    }





}