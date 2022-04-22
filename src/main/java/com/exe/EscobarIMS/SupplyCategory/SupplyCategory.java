package com.exe.EscobarIMS.SupplyCategory;


import javax.persistence.*;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "supply_category")
public class SupplyCategory {

    @Id
    @GeneratedValue(strategy  = IDENTITY)
    @Column(name = "supply_category_id")
    private Long supplyCategoryId;

    @Column(name = "supply_category_name" )
    private String supplyCategoryName;

    public Long getSupplyCategoryId() {
        return supplyCategoryId;
    }

    public String getSupplyCategoryName() {
        return supplyCategoryName;
    }

    public SupplyCategory() {
    }

    public SupplyCategory(String supplyCategoryName) {
        this.supplyCategoryName = supplyCategoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplyCategory that = (SupplyCategory) o;
        return Objects.equals(supplyCategoryId, that.supplyCategoryId) && Objects.equals(supplyCategoryName, that.supplyCategoryName);
    }

    @Override
    public String toString() {
        return "SupplyCategory{" +
                "supplyCategoryId=" + supplyCategoryId +
                ", supplyCategoryName='" + supplyCategoryName + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplyCategoryId, supplyCategoryName);
    }
}
