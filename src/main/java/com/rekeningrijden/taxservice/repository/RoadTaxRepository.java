package com.rekeningrijden.taxservice.repository;

import com.rekeningrijden.taxservice.dto.RoadTaxDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoadTaxRepository extends JpaRepository<RoadTaxDto, Long> {
}
