package com.exe.EscobarIMS.Supply;

import com.exe.EscobarIMS.Supplier.Supplier;
import com.exe.EscobarIMS.SupplyCategory.SupplyCategory;
import com.exe.EscobarIMS.UnitOfMeasurement.UnitOfMeasurement;

import javax.persistence.*;

import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "supply")
public class Supply {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "supply_id")
    private Long supplyId;

    @Column(name = "supply_name")
    private String supplyName;

    @Column(name = "supply_quantity")
    private Double supplyQuantity;

    @Column(name = "minimumQuantity")
    private Double minimumQuantity;

    @Column(name = "in_minimum_quantity")
    private Boolean inMinimumQuantity;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "unit_of_measurement_id")
    private UnitOfMeasurement unitOfMeasurement;

    @ManyToOne
    @JoinColumn(name = "supply_category_id")
    private SupplyCategory supplyCategory;

    public Long getSupplyId() {
        return supplyId;
    }

    public String getSupplyName() {
        return supplyName;
    }

    public Double getSupplyQuantity() {
        return supplyQuantity;
    }

    public Double getMinimumQuantity() {
        return minimumQuantity;
    }

    public Boolean getInMinimumQuantity() {
        return inMinimumQuantity;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public UnitOfMeasurement getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public SupplyCategory getSupplyCategory() {
        return supplyCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supply supply = (Supply) o;
        return Objects.equals(supplyId, supply.supplyId) && Objects.equals(supplyName, supply.supplyName) && Objects.equals(supplyQuantity, supply.supplyQuantity) && Objects.equals(minimumQuantity, supply.minimumQuantity) && Objects.equals(inMinimumQuantity, supply.inMinimumQuantity) && Objects.equals(supplier, supply.supplier) && Objects.equals(unitOfMeasurement, supply.unitOfMeasurement) && Objects.equals(supplyCategory, supply.supplyCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplyId, supplyName, supplyQuantity, minimumQuantity, inMinimumQuantity, supplier, unitOfMeasurement, supplyCategory);
    }

    @Override
    public String toString() {
        return "Supply{" +
                "supplyId=" + supplyId +
                ", supplyName='" + supplyName + '\'' +
                ", supplyQuantity=" + supplyQuantity +
                ", minimumQuantity=" + minimumQuantity +
                ", inMinimumQuantity=" + inMinimumQuantity +
                ", supplier=" + supplier +
                ", unitOfMeasurement=" + unitOfMeasurement +
                ", supplyCategory=" + supplyCategory +
                '}';
    }
}
