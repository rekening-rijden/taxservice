package com.rekeningrijden.taxservice.repository;

import com.rekeningrijden.taxservice.entity.BasePrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasePriceRepository extends JpaRepository<BasePrice, Long> {
    BasePrice findByEngineType(String engineType);
}
