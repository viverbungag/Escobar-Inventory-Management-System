package com.exe.EscobarIMS.SupplyCategory.AddSupplyCategory;

import com.exe.EscobarIMS.SupplyCategory.SupplyCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddSupplyCategoryRepository extends JpaRepository<SupplyCategory, Long> {
}
