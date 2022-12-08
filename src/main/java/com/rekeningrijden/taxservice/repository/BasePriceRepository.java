package com.rekeningrijden.taxservice.repository;

import com.rekeningrijden.taxservice.entity.BasePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface BasePriceRepository extends JpaRepository<BasePrice, Long> {
    BasePrice findByEngineType(String engineType);
    void deleteBasePriceByEngineType(String engineType);
}
