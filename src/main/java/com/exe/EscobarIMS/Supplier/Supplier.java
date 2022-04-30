package com.exe.EscobarIMS.Supplier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;


@Entity(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "supplier_id")
    private Long supplierId;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "supplier_address")
    private String supplierAddress;

    @Column(name = "supplier_contact_number")
    private String supplierContactNumber;

    @Column(name = "supplier_contact_person")
    private String supplierContactPerson;


    public Supplier() {
    }

    public Supplier(String supplierName, String supplierAddress, String supplierContactNumber, String supplierContactPerson) {
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.supplierContactNumber = supplierContactNumber;
        this.supplierContactPerson = supplierContactPerson;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public String getSupplierContactNumber() {
        return supplierContactNumber;
    }

    public String getSupplierContactPerson() {
        return supplierContactPerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(supplierId, supplier.supplierId) && Objects.equals(supplierName, supplier.supplierName) && Objects.equals(supplierAddress, supplier.supplierAddress) && Objects.equals(supplierContactNumber, supplier.supplierContactNumber) && Objects.equals(supplierContactPerson, supplier.supplierContactPerson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierId, supplierName, supplierAddress, supplierContactNumber, supplierContactPerson);
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", supplierAddress='" + supplierAddress + '\'' +
                ", supplierContactNumber='" + supplierContactNumber + '\'' +
                ", supplierContactPerson='" + supplierContactPerson + '\'' +
                '}';
    }
}




