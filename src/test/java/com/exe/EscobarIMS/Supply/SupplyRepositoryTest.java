package com.exe.EscobarIMS.Supply;

import com.exe.EscobarIMS.Supply.AddSupply.AddSupplyRepository;
import com.exe.EscobarIMS.Supply.ViewEditDeleteSupply.ViewEditDeleteSupplyRepository;
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
class SupplyRepositoryTest {

    @Autowired
    ViewEditDeleteSupplyRepository viewEditDeleteSupplyRepository;

    @Autowired
    AddSupplyRepository addSupplyRepository;

    @Autowired
    SupplyRepository supplyRepository;

    @Test
    void injected_components_are_not_null() {
        assertNotNull(addSupplyRepository);
        assertNotNull(viewEditDeleteSupplyRepository);
        assertNotNull(supplyRepository);
    }

    @Test
    void getAllSupply_when_there_are_16_supplies() {
        List<Supply> supplies = viewEditDeleteSupplyRepository.getAllSupply();
        assertEquals(16, supplies.size());
    }

    @Test
    void findBySupplyName_when_supply_is_existing() {
        Supply supply = supplyRepository.findBySupplyName("Supply 1");
        assertNotNull(supply);
    }

    @Test
    void findBySupplyName_when_supply_is_not_existing() {
        Supply supply = supplyRepository.findBySupplyName("Supply 0");
        assertNull(supply);
    }

    @Test
    void deleteAllSuppliesByName_when_deleting_1_existing_supply() {
        Integer oldSize = viewEditDeleteSupplyRepository.getAllSupply().size();
        viewEditDeleteSupplyRepository.deleteSupplyByNameAndSupplier("Supply 1", 1L);
        Integer newSize = viewEditDeleteSupplyRepository.getAllSupply().size();
        assertEquals(oldSize - 1, newSize);
    }

    @Test
    void updateSupplyById_when_updating_id_2() {
        viewEditDeleteSupplyRepository.updateSupplyById(2L, "Updated Supply 2", 3L, 4L, 5L, 9D);
        Supply supply = supplyRepository.findBySupplyId(2L);
        assertEquals("Updated Supply 2", supply.getSupplyName());
        assertEquals("Supplier 3", supply.getSupplier().getSupplierName());
        assertEquals("Unit of Measurement 4", supply.getUnitOfMeasurement().getUnitOfMeasurementName());
        assertEquals("Supply Category 5", supply.getSupplyCategory().getSupplyCategoryName());
        assertEquals(9D, supply.getMinimumQuantity());
    }

    @Test
    void getAllPagedSupplies_when_page_is_0_and_the_size_is_5(){
        Pageable pageable = PageRequest.of(0, 5);
        Page<Supply> supplies =  viewEditDeleteSupplyRepository.getAllPagedSupplies(pageable);
        assertEquals(5, supplies.getContent().size());
    }

    @Test
    void getAllPagedSupplies_when_page_is_3_and_the_size_is_5(){
        Pageable pageable = PageRequest.of(3, 5);
        Page<Supply> supplies =  viewEditDeleteSupplyRepository.getAllPagedSupplies(pageable);
        assertEquals(1, supplies.getContent().size());
    }

    @Test
    void getAllPagedSupplies_when_getting_the_total_pages_and_the_size_is_15(){
        Pageable pageable = PageRequest.ofSize(15);
        Page<Supply> supplies =  viewEditDeleteSupplyRepository.getAllPagedSupplies(pageable);
        assertEquals(2, supplies.getTotalPages());
    }

    @Test
    void getAllPagedSupplies_when_getting_the_first_supply_name_sorted_by_supply_name_ascending(){
        Sort sort = Sort.by("supply.supply_name").ascending();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<Supply> supplies =  viewEditDeleteSupplyRepository.getAllPagedSupplies(pageable).getContent();
        assertEquals("Supply 1", supplies.get(0).getSupplyName());
    }

    @Test
    void getAllPagedSupplies_when_getting_the_first_supply_name_sorted_by_supply_name_descending(){
        Sort sort = Sort.by("supply.supply_name").descending();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<Supply> supplies =  viewEditDeleteSupplyRepository.getAllPagedSupplies(pageable).getContent();
        assertEquals("Supply 1", supplies.get(supplies.size()-1).getSupplyName());
    }

    @Test
    void getAllPagedSupplies_when_getting_the_first_supplier_name_sorted_by_supplier_name_ascending(){
        Sort sort = Sort.by("supplier.supplier_name").ascending();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<Supply> supplies =  viewEditDeleteSupplyRepository.getAllPagedSupplies(pageable).getContent();
        assertEquals("Supplier 1", supplies.get(0).getSupplierName());
    }

    @Test
    void getAllPagedSupplies_when_getting_the_first_supplier_name_sorted_by_supplier_name_descending(){
        Sort sort = Sort.by("supplier.supplier_name").descending();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<Supply> supplies =  viewEditDeleteSupplyRepository.getAllPagedSupplies(pageable).getContent();
        assertEquals("Supplier 1", supplies.get(supplies.size()-1).getSupplierName());
    }

    @Test
    void getAllPagedSupplies_when_getting_the_first_unit_of_measurement_name_sorted_by_unit_of_measurement_name_ascending(){
        Sort sort = Sort.by("unit_of_measurement.unit_of_measurement_name").ascending();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<Supply> supplies =  viewEditDeleteSupplyRepository.getAllPagedSupplies(pageable).getContent();
        assertEquals("Unit of Measurement 1", supplies.get(0).getUnitOfMeasurementName());
    }

    @Test
    void getAllPagedSupplies_when_getting_the_first_unit_of_measurement_name_sorted_by_unit_of_measurement_name_descending(){
        Sort sort = Sort.by("unit_of_measurement.unit_of_measurement_name").descending();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<Supply> supplies =  viewEditDeleteSupplyRepository.getAllPagedSupplies(pageable).getContent();
        assertEquals("Unit of Measurement 1", supplies.get(supplies.size()-1).getUnitOfMeasurementName());
    }

    @Test
    void getAllPagedSupplies_when_getting_the_first_supply_category_name_sorted_by_supply_category_ascending(){
        Sort sort = Sort.by("supply_category.supply_category_name").ascending();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<Supply> supplies =  viewEditDeleteSupplyRepository.getAllPagedSupplies(pageable).getContent();
        assertEquals("Supply Category 1", supplies.get(0).getSupplyCategoryName());
    }

    @Test
    void getAllPagedSupplies_when_getting_the_first_supply_category_name_sorted_by_supply_category_descending(){
        Sort sort = Sort.by("supply_category.supply_category_name").descending();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<Supply> supplies =  viewEditDeleteSupplyRepository.getAllPagedSupplies(pageable).getContent();
        assertEquals("Supply Category 1", supplies.get(supplies.size()-1).getSupplyCategoryName());
    }

    @Test
    void getAllPagedSupplies_when_getting_the_first_minimum_quantity_sorted_by_minimum_quantity_ascending(){
        Sort sort = Sort.by("supply_category.supply_category_name").ascending();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<Supply> supplies =  viewEditDeleteSupplyRepository.getAllPagedSupplies(pageable).getContent();
        assertEquals(11D, supplies.get(0).getMinimumQuantity());
    }

    @Test
    void getAllPagedSupplies_when_getting_the_first_minimum_quantity_sorted_by_minimum_quantity_descending(){
        Sort sort = Sort.by("supply_category.supply_category_name").descending();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<Supply> supplies =  viewEditDeleteSupplyRepository.getAllPagedSupplies(pageable).getContent();
        assertEquals(11D, supplies.get(supplies.size()-1).getMinimumQuantity());
    }

    @Test
    void getAllPagedSuppliers_when_getting_the_first_supplier_name_not_sorted(){
        Sort sort = Sort.unsorted();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<Supply> suppliers =  viewEditDeleteSupplyRepository.getAllPagedSupplies(pageable).getContent();
        assertEquals("Supply 1", suppliers.get(0).getSupplyName());
    }

    @Test
    void findBySupplyNameAndCategory_when_getting_the_supply_exists(){
        Supply supply = supplyRepository.findBySupplyNameAndCategory("Supply 1", 1L);
        assertNotNull(supply);

        Supply supply1 = supplyRepository.findBySupplyNameAndCategory("Supply 2", 2L);
        assertNotNull(supply1);
    }

    @Test
    void findBySupplyNameAndCategory_when_getting_the_supply_does_not_exists(){
        Supply supply = supplyRepository.findBySupplyNameAndCategory("Supply 1", 2L);
        assertNull(supply);

        Supply supply1 = supplyRepository.findBySupplyNameAndCategory("Supply 2", 5L);
        assertNull(supply1);
    }
}