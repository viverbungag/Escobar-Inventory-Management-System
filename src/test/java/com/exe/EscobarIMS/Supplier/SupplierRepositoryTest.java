package com.exe.EscobarIMS.Supplier;

import com.exe.EscobarIMS.Supplier.AddSupplier.AddSupplierRepository;
import com.exe.EscobarIMS.Supplier.ViewEditDeleteSupplier.ViewEditDeleteSupplierRepository;
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
class SupplierRepositoryTest {

    @Autowired
    AddSupplierRepository addSupplierRepository;
    @Autowired
    ViewEditDeleteSupplierRepository viewEditDeleteSupplierRepository;
    @Autowired
    SupplierRepository supplierRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void Injected_Components_are_not_null(){
        assertNotNull(addSupplierRepository);
        assertNotNull(viewEditDeleteSupplierRepository);
        assertNotNull(supplierRepository);
    }

    @Test
    void findBySupplierName_when_menu_supplier_is_existing(){
        Supplier acquiredSupplier = supplierRepository.findBySupplierName("Supplier 1");
        assertNotNull(acquiredSupplier);
    }

    @Test
    void findBySupplierName_when_supplier_name_is_not_existing(){
        Supplier supplier = supplierRepository.findBySupplierName("Supplier 0");
        assertNull(supplier);
    }

    @Test
    void getAllSupplier_when_there_are_16_supplier(){
        List<Supplier> suppliers = viewEditDeleteSupplierRepository.getAllSupplier();
        assertEquals(suppliers.size(), 16);
    }

    @Test
    void deleteAllSuppliersByName_when_deleting_2_existing_suppliers(){
        Integer oldSize = viewEditDeleteSupplierRepository.getAllSupplier().size();
        viewEditDeleteSupplierRepository.deleteAllSupplierByName(List.of("Supplier 1", "Supplier 2"));
        Integer newSize = viewEditDeleteSupplierRepository.getAllSupplier().size();
        assertEquals(oldSize-2, newSize);
    }

    @Test
    void deleteAllSuppliersByName_when_deleting_1_existing_and_1_non_existing_suppliers(){
        Integer oldSize = viewEditDeleteSupplierRepository.getAllSupplier().size();
        viewEditDeleteSupplierRepository.deleteAllSupplierByName(List.of("Supplier 0", "Supplier 1"));
        Integer newSize = viewEditDeleteSupplierRepository.getAllSupplier().size();
        assertEquals(oldSize-1, newSize);
    }

    @Test
    void updateSupplierNameById_when_updating_id_2(){
        viewEditDeleteSupplierRepository.updateSupplierNameById(2L, "Updated Supplier 2", "Updated Address 2", "19273173102", "Updated Person 2");
        Supplier supplier = supplierRepository.findBySupplierId(2L);
        assertEquals(supplier.getSupplierName(), "Updated Supplier 2");
        assertEquals(supplier.getSupplierAddress(), "Updated Address 2");
        assertEquals(supplier.getSupplierContactNumber(), "19273173102");
        assertEquals(supplier.getSupplierContactPerson(), "Updated Person 2");
    }

    @Test
    void getAllPagedSuppliers_when_page_is_0_and_the_size_is_5(){
        Pageable pageable = PageRequest.of(0, 5);
        Page<Supplier> suppliers =  viewEditDeleteSupplierRepository.getAllPagedSupplier(pageable);
        assertEquals(5, suppliers.getContent().size());
    }

    @Test
    void getAllPagedSuppliers_when_page_is_3_and_the_size_is_5(){
        Pageable pageable = PageRequest.of(3, 5);
        Page<Supplier> suppliers =  viewEditDeleteSupplierRepository.getAllPagedSupplier(pageable);
        assertEquals(1, suppliers.getContent().size());
    }

    @Test
    void getAllPagedSuppliers_when_getting_the_total_pages_and_the_size_is_15(){
        Pageable pageable = PageRequest.ofSize(15);
        Page<Supplier> suppliers =  viewEditDeleteSupplierRepository.getAllPagedSupplier(pageable);
        assertEquals(2, suppliers.getTotalPages());
    }

    @Test
    void getAllPagedSuppliers_when_getting_the_first_supplier_name_sorted_by_supplier_ascending(){
        Sort sort = Sort.by("supplier_name").ascending();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<Supplier> suppliers =  viewEditDeleteSupplierRepository.getAllPagedSupplier(pageable).getContent();
        assertEquals("Supplier 1", suppliers.get(0).getSupplierName());
    }
//
    @Test
    void getAllPagedSuppliers_when_getting_the_first_supplier_name_sorted_by_supplier_descending(){
        Sort sort = Sort.by("supplier_name").descending();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<Supplier> suppliers =  viewEditDeleteSupplierRepository.getAllPagedSupplier(pageable).getContent();
        assertEquals("Supplier 1", suppliers.get(suppliers.size()-1).getSupplierName());
    }

    @Test
    void getAllPagedSuppliers_when_getting_the_first_supplier_address_sorted_by_supplier_address_ascending(){
        Sort sort = Sort.by("supplier_address").ascending();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<Supplier> suppliers =  viewEditDeleteSupplierRepository.getAllPagedSupplier(pageable).getContent();
        assertEquals("Address 1", suppliers.get(0).getSupplierAddress());
    }

    @Test
    void getAllPagedSuppliers_when_getting_the_first_supplier_address_sorted_by_supplier_address_descending(){
        Sort sort = Sort.by("supplier_address").descending();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<Supplier> suppliers =  viewEditDeleteSupplierRepository.getAllPagedSupplier(pageable).getContent();
        assertEquals("Address 1", suppliers.get(suppliers.size()-1).getSupplierAddress());
    }

    @Test
    void getAllPagedSuppliers_when_getting_the_first_supplier_contact_number_sorted_by_supplier_contact_number_ascending(){
        Sort sort = Sort.by("supplier_contact_number").ascending();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<Supplier> suppliers =  viewEditDeleteSupplierRepository.getAllPagedSupplier(pageable).getContent();
        assertEquals("09273173101", suppliers.get(0).getSupplierContactNumber());
    }

    @Test
    void getAllPagedSuppliers_when_getting_the_first_supplier_contact_number_sorted_by_supplier_contact_number_descending(){
        Sort sort = Sort.by("supplier_contact_number").descending();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<Supplier> suppliers =  viewEditDeleteSupplierRepository.getAllPagedSupplier(pageable).getContent();
        assertEquals("09273173101", suppliers.get(suppliers.size()-1).getSupplierContactNumber());
    }

    @Test
    void getAllPagedSuppliers_when_getting_the_first_supplier_contact_person_sorted_by_supplier_contact_person_ascending(){
        Sort sort = Sort.by("supplier_contact_person").ascending();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<Supplier> suppliers =  viewEditDeleteSupplierRepository.getAllPagedSupplier(pageable).getContent();
        assertEquals("Person 1", suppliers.get(0).getSupplierContactPerson());
    }

    @Test
    void getAllPagedSuppliers_when_getting_the_first_supplier_contact_person_sorted_by_supplier_contact_person_descending(){
        Sort sort = Sort.by("supplier_contact_person").descending();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<Supplier> suppliers =  viewEditDeleteSupplierRepository.getAllPagedSupplier(pageable).getContent();
        assertEquals("Person 1", suppliers.get(suppliers.size()-1).getSupplierContactPerson());
    }

    @Test
    void getAllPagedSuppliers_when_getting_the_first_supplier_name_not_sorted(){
        Sort sort = Sort.unsorted();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<Supplier> suppliers =  viewEditDeleteSupplierRepository.getAllPagedSupplier(pageable).getContent();
        assertEquals("Supplier 1", suppliers.get(0).getSupplierName());
    }
}