package com.exe.EscobarIMS.UnitOfMeasurement.AddUnitOfMeasurement;

import com.exe.EscobarIMS.UnitOfMeasurement.UnitOfMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddUnitOfMeasurementRepository extends JpaRepository<UnitOfMeasurement, Long> {

}