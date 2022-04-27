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

    @Column(name = "unit_of_measurement_abbreviation")
    private String unitOfMeasurementAbbreviation;


    public UnitOfMeasurement() {
    }

    public UnitOfMeasurement(String unitOfMeasurementName, String unitOfMeasurementAbbreviation) {
        this.unitOfMeasurementName = unitOfMeasurementName;
        this.unitOfMeasurementAbbreviation = unitOfMeasurementAbbreviation;
    }

    public Long getUnitOfMeasurementId() {
        return unitOfMeasurementId;
    }


    public String getUnitOfMeasurementName() {
        return unitOfMeasurementName;
    }

    public String getUnitOfMeasurementAbbreviation() {
        return unitOfMeasurementAbbreviation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnitOfMeasurement that = (UnitOfMeasurement) o;
        return Objects.equals(unitOfMeasurementId, that.unitOfMeasurementId) && Objects.equals(unitOfMeasurementName, that.unitOfMeasurementName) && Objects.equals(unitOfMeasurementAbbreviation, that.unitOfMeasurementAbbreviation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitOfMeasurementId, unitOfMeasurementName, unitOfMeasurementAbbreviation);
    }

    @Override
    public String toString() {
        return "UnitOfMeasurement{" +
                "unitOfMeasurementId=" + unitOfMeasurementId +
                ", unitOfMeasurementName='" + unitOfMeasurementName + '\'' +
                ", unitOfMeasurementAbbreviation='" + unitOfMeasurementAbbreviation + '\'' +
                '}';
    }
}




