package com.exe.EscobarIMS.Transaction;

import com.exe.EscobarIMS.Supplier.Supplier;
import com.exe.EscobarIMS.Supply.Supply;
import com.exe.EscobarIMS.SupplyCategory.SupplyCategory;
import com.exe.EscobarIMS.UnitOfMeasurement.UnitOfMeasurement;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionTest {

    @Test
    void getTransactionCost() {
        Supply supply1 = new Supply("Supply 1", 11D, new Supplier(), new UnitOfMeasurement(), new SupplyCategory());
        Transaction transaction = new Transaction(1L, LocalDateTime.now(), 1L, 5D, List.of(supply1), new BigDecimal(50), LocalDateTime.of(2022, 5, 13,0,0));
        assertEquals(new BigDecimal("250.00"), transaction.getTransactionCost());

        Transaction transaction2 = new Transaction(1L, LocalDateTime.now(), 1L, 1D, List.of(supply1), new BigDecimal(150.5951), LocalDateTime.of(2022, 5, 13,0,0));
        assertEquals(new BigDecimal("150.60"), transaction2.getTransactionCost());
    }
}