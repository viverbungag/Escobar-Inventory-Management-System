package com.exe.EscobarIMS.UnitOfMeasurement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitOfMeasurementRepository extends JpaRepository<UnitOfMeasurement, Long> {

    @Query(value = "SELECT * FROM #{#entityName} WHERE unit_of_measurement_name = :unitOfMeasurementName",
            nativeQuery = true)
    UnitOfMeasurement findByUnitOfMeasurementName(@Param("unitOfMeasurementName") String name);

    @Query(value = "SELECT * FROM #{#entityName} WHERE unit_of_measurement_id = :unitOfMeasurementId",
            nativeQuery = true)
    UnitOfMeasurement findByUnitOfMeasurementId(@Param("unitOfMeasurementId") Long id);

}
