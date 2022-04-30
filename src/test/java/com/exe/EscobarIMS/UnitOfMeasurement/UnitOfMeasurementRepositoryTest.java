package com.exe.EscobarIMS.UnitOfMeasurement;

import com.exe.EscobarIMS.UnitOfMeasurement.AddUnitOfMeasurement.AddUnitOfMeasurementRepository;
import com.exe.EscobarIMS.UnitOfMeasurement.ViewEditDeleteUnitOfMeasurement.ViewEditDeleteUnitOfMeasurementRepository;
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
class UnitOfMeasurementRepositoryTest {

    @Autowired
    AddUnitOfMeasurementRepository addUnitOfMeasurementRepository;
    @Autowired
    ViewEditDeleteUnitOfMeasurementRepository viewEditDeleteUnitOfMeasurementRepository;
    @Autowired
    UnitOfMeasurementRepository unitOfMeasurementRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void Injected_Components_are_not_null(){
        assertNotNull(addUnitOfMeasurementRepository);
        assertNotNull(viewEditDeleteUnitOfMeasurementRepository);
        assertNotNull(unitOfMeasurementRepository);
    }

    @Test
    void findByUnitOfMeasurementName_when_unit_of_measurement_name_is_existing(){
        UnitOfMeasurement acquiredMenuCategory = unitOfMeasurementRepository.findByUnitOfMeasurementName("Unit of Measurement 1");
        assertNotNull(acquiredMenuCategory);
    }

    @Test
    void findByUnitOfMeasurementName_when_unit_of_measurement_name_is_not_existing(){
        UnitOfMeasurement acquiredMenuCategory = unitOfMeasurementRepository.findByUnitOfMeasurementName("Unit of Measurement 0");
        assertNull(acquiredMenuCategory);
    }

    @Test
    void getAllUnitOfMeasurements_when_there_are_16_unit_of_measurements(){
        List<UnitOfMeasurement> unitOfMeasurements = viewEditDeleteUnitOfMeasurementRepository.getAllUnitOfMeasurements();
        assertEquals(unitOfMeasurements.size(), 16);
    }

    @Test
    void deleteAllUnitOfMeasurementByName_when_deleting_2_existing_unit_of_measurements(){
        Integer oldSize = viewEditDeleteUnitOfMeasurementRepository.getAllUnitOfMeasurements().size();
        viewEditDeleteUnitOfMeasurementRepository.deleteAllUnitOfMeasurementByName(List.of("Unit of Measurement 1", "Unit of Measurement 2"));
        Integer newSize = viewEditDeleteUnitOfMeasurementRepository.getAllUnitOfMeasurements().size();
        assertEquals(oldSize-2, newSize);
    }

    @Test
    void deleteAllUnitOfMeasurementByName_when_deleting_1_existing_and_1_non_existing_unit_of_measurements(){
        Integer oldSize = viewEditDeleteUnitOfMeasurementRepository.getAllUnitOfMeasurements().size();
        viewEditDeleteUnitOfMeasurementRepository.deleteAllUnitOfMeasurementByName(List.of("Unit of Measurement 0", "Unit of Measurement 1"));
        Integer newSize = viewEditDeleteUnitOfMeasurementRepository.getAllUnitOfMeasurements().size();
        assertEquals(oldSize-1, newSize);
    }

    @Test
    void findByUnitOfMeasurementId_when_updating_id_2(){
        viewEditDeleteUnitOfMeasurementRepository.updateUnitOfMeasurementNameById(2L, "Updated Unit of Measurement 2", "Updated UOM 2");
        UnitOfMeasurement acquiredUnitOfMeasurement = unitOfMeasurementRepository.findByUnitOfMeasurementId(2L);
        assertEquals(acquiredUnitOfMeasurement.getUnitOfMeasurementName(), "Updated Unit of Measurement 2");
        assertEquals(acquiredUnitOfMeasurement.getUnitOfMeasurementAbbreviation(), "Updated UOM 2");
    }

    @Test
    void getAllPagedUnitOfMeasurement_when_page_is_0_and_the_size_is_5(){
        Pageable pageable = PageRequest.of(0, 5);
        Page<UnitOfMeasurement> pagedUnitOfMeasurement =  viewEditDeleteUnitOfMeasurementRepository.getAllPagedUnitOfMeasurement(pageable);
        assertEquals(5, pagedUnitOfMeasurement.getContent().size());
    }

    @Test
    void getAllPagedUnitOfMeasurement_when_page_is_3_and_the_size_is_5(){
        Pageable pageable = PageRequest.of(3, 5);
        Page<UnitOfMeasurement> pagedUnitOfMeasurement =  viewEditDeleteUnitOfMeasurementRepository.getAllPagedUnitOfMeasurement(pageable);
        assertEquals(1, pagedUnitOfMeasurement.getContent().size());
    }

    @Test
    void getAllPagedUnitOfMeasurement_when_getting_the_total_pages_and_the_size_is_15(){
        Pageable pageable = PageRequest.ofSize(15);
        Page<UnitOfMeasurement> pagedUnitOfMeasurement =  viewEditDeleteUnitOfMeasurementRepository.getAllPagedUnitOfMeasurement(pageable);
        assertEquals(2, pagedUnitOfMeasurement.getTotalPages());
    }

    @Test
    void getAllPagedUnitOfMeasurement_when_getting_the_first_unit_of_measurement_sorted_by_name_ascending(){
        Sort sort = Sort.by("unit_of_measurement_name").ascending();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<UnitOfMeasurement> pagedUnitOfMeasurement =  viewEditDeleteUnitOfMeasurementRepository.getAllPagedUnitOfMeasurement(pageable).getContent();
        assertEquals("Unit of Measurement 1", pagedUnitOfMeasurement.get(0).getUnitOfMeasurementName());
    }

    @Test
    void getAllPagedUnitOfMeasurement_when_getting_the_last_unit_of_measurement_name_sorted_by_name_descending(){
        Sort sort = Sort.by("unit_of_measurement_name").descending();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<UnitOfMeasurement> pagedUnitOfMeasurement =  viewEditDeleteUnitOfMeasurementRepository.getAllPagedUnitOfMeasurement(pageable).getContent();
        assertEquals("Unit of Measurement 1", pagedUnitOfMeasurement.get(pagedUnitOfMeasurement.size()-1).getUnitOfMeasurementName());
    }

    @Test
    void getAllPagedUnitOfMeasurement_when_getting_the_first_unit_of_measurement_abbreviation_sorted_by_name_ascending(){
        Sort sort = Sort.by("unit_of_measurement_abbreviation").ascending();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<UnitOfMeasurement> pagedUnitOfMeasurement =  viewEditDeleteUnitOfMeasurementRepository.getAllPagedUnitOfMeasurement(pageable).getContent();
        assertEquals("Unit of Measurement 1", pagedUnitOfMeasurement.get(0).getUnitOfMeasurementName());
    }

    @Test
    void getAllPagedUnitOfMeasurement_when_getting_the_last_unit_of_measurement_abbreviation_sorted_by_name_descending(){
        Sort sort = Sort.by("unit_of_measurement_abbreviation").descending();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<UnitOfMeasurement> pagedUnitOfMeasurement =  viewEditDeleteUnitOfMeasurementRepository.getAllPagedUnitOfMeasurement(pageable).getContent();
        assertEquals("Unit of Measurement 1", pagedUnitOfMeasurement.get(pagedUnitOfMeasurement.size()-1).getUnitOfMeasurementName());
    }

    @Test
    void getAllPagedUnitOfMeasurement_when_getting_the_first_unit_of_measurement_name_not_sorted(){
        Sort sort = Sort.unsorted();
        Pageable pageable = PageRequest.of(0, 100, sort);
        List<UnitOfMeasurement> pagedUnitOfMeasurement =  viewEditDeleteUnitOfMeasurementRepository.getAllPagedUnitOfMeasurement(pageable).getContent();
        assertEquals("Unit of Measurement 1", pagedUnitOfMeasurement.get(0).getUnitOfMeasurementName());
    }
}