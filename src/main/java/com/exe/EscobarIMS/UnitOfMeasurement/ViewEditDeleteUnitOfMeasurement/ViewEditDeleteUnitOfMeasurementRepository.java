package com.exe.EscobarIMS.UnitOfMeasurement.ViewEditDeleteUnitOfMeasurement;

import com.exe.EscobarIMS.UnitOfMeasurement.UnitOfMeasurement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewEditDeleteUnitOfMeasurementRepository extends JpaRepository<UnitOfMeasurement, Long> {


    @Query(value = "SELECT * FROM #{#entityName}",
            nativeQuery = true)
    List<UnitOfMeasurement> getAllUnitOfMeasurements();

    @Query(value = "SELECT * FROM #{#entityName}",
            nativeQuery = true)
    Page<UnitOfMeasurement> getAllPagedUnitOfMeasurement(Pageable pageable);

    @Modifying
    @Query(value = "DELETE FROM #{#entityName} " +
            " WHERE unit_of_measurement_name IN :listOfUnitOfMeasurementNames",
            nativeQuery = true)
    void deleteAllUnitOfMeasurementByName(@Param("listOfUnitOfMeasurementNames") List<String> names);

    @Modifying
    @Query(value = "UPDATE #{#entityName} " +
            "SET unit_of_measurement_name = :newUnitOfMeasurementName, unit_of_measurement_abbreviation = :newAbbreviation " +
            "WHERE unit_of_measurement_id = :unitOfMeasurementId",
            nativeQuery = true)
    void updateUnitOfMeasurementNameById(@Param("unitOfMeasurementId") Long id,
                                         @Param("newUnitOfMeasurementName") String name,
                                         @Param("newAbbreviation") String abbreviation);
}
