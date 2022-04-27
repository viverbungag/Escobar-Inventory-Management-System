package com.exe.EscobarIMS.UnitOfMeasurement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;


@Entity(name = "unit_of_measurement")
public class UnitOfMeasurement {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "unit_of_measurement_id")
    private Long unitOfMeasurementId;

    @Column(name = "unit_of_measurement_name")
    private String unitOfMeasurementName;

    public UnitOfMeasurement() {
    }

    public UnitOfMeasurement(String unitOfMeasurementName) {
        this.unitOfMeasurementName = unitOfMeasurementName;
    }

    public Long getUnitOfMeasurementId() {
        return unitOfMeasurementId;
    }


    public String getUnitOfMeasurementName() {
        return unitOfMeasurementName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnitOfMeasurement that = (UnitOfMeasurement) o;
        return Objects.equals(unitOfMeasurementId, that.unitOfMeasurementId) && unitOfMeasurementName.equals(that.unitOfMeasurementName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitOfMeasurementId, unitOfMeasurementName);
    }

    @Override
    public String toString() {
        return "UnitOfMeasurement{" +
                "unitOfMeasurementId=" + unitOfMeasurementId +
                ", unitOfMeasurementName='" + unitOfMeasurementName + '\'' +
                '}';
    }
}




