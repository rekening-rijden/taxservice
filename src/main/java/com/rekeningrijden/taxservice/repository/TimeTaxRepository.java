package com.rekeningrijden.taxservice.repository;

import com.rekeningrijden.taxservice.entity.TimeTax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeTaxRepository extends JpaRepository<TimeTax, Long> {
}
