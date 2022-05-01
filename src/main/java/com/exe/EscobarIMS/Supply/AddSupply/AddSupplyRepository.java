package com.exe.EscobarIMS.Supply.AddSupply;

import com.exe.EscobarIMS.Supply.Supply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddSupplyRepository extends JpaRepository<Supply, Long> {
}
