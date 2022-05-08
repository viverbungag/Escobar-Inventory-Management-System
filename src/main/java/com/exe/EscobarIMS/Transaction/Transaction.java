package com.exe.EscobarIMS.Transaction;

import com.exe.EscobarIMS.Supply.Supply;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    @Column(name = "supplier_id")
    private Long supplierId;

    @Column(name = "transaction_supply_quantity")
    private Double transactionSupplyQuantity;

    @ManyToOne
    @JoinColumn(name = "supply_id")
    private List<Supply> Supplies;

    @Column(name = "supply_per_unit_cost")
    private BigDecimal supplyPerUnitCost;

    @Column(name = "expiry_date")
    private LocalDateTime expiryDate;

    public BigDecimal getTransactionCost(){
        BigDecimal convertedSupplyQuantity = new BigDecimal(transactionSupplyQuantity);
        return supplyPerUnitCost.multiply(convertedSupplyQuantity).setScale(2, RoundingMode.HALF_UP);
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public Double getTransactionSupplyQuantity() {
        return transactionSupplyQuantity;
    }

    public List<Supply> getSupplies() {
        return Supplies;
    }

    public BigDecimal getSupplyPerUnitCost() {
        return supplyPerUnitCost;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public Transaction() {
    }

    public Transaction(Long employeeId, LocalDateTime transactionDate,
                       Long supplierId, Double transactionSupplyQuantity,
                       List<Supply> supplies, BigDecimal supplyPerUnitCost,
                       LocalDateTime expiryDate) {
        this.employeeId = employeeId;
        this.transactionDate = transactionDate;
        this.supplierId = supplierId;
        this.transactionSupplyQuantity = transactionSupplyQuantity;
        Supplies = supplies;
        this.supplyPerUnitCost = supplyPerUnitCost;
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(employeeId, that.employeeId) && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(supplierId, that.supplierId) && Objects.equals(transactionSupplyQuantity, that.transactionSupplyQuantity) && Objects.equals(Supplies, that.Supplies) && Objects.equals(supplyPerUnitCost, that.supplyPerUnitCost) && Objects.equals(expiryDate, that.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, employeeId, transactionDate, supplierId, transactionSupplyQuantity, Supplies, supplyPerUnitCost, expiryDate);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", employeeId=" + employeeId +
                ", transactionDate=" + transactionDate +
                ", supplierId=" + supplierId +
                ", transactionSupplyQuantity=" + transactionSupplyQuantity +
                ", Supplies=" + Supplies +
                ", supplyPerUnitCost=" + supplyPerUnitCost +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
