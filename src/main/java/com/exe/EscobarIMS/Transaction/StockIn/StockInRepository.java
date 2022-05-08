package com.exe.EscobarIMS.Transaction.StockIn;


import com.exe.EscobarIMS.Transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockInRepository extends JpaRepository<Transaction, Long> {
}
