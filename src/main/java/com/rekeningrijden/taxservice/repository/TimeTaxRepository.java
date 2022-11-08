package com.rekeningrijden.taxservice.repository;

import com.rekeningrijden.taxservice.dto.TimeTaxDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeTaxRepository extends JpaRepository<TimeTaxDto, Long> {
}
