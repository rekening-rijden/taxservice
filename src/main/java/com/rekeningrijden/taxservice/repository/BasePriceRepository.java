package com.rekeningrijden.taxservice.repository;

import com.rekeningrijden.taxservice.dto.BasePriceDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasePriceRepository extends JpaRepository<BasePriceDto, Long> {
    BasePriceDto findByEngineType(String engineType);
}
