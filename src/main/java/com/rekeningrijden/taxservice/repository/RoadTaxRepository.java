package com.rekeningrijden.taxservice.repository;

import com.rekeningrijden.taxservice.entity.RoadTax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface RoadTaxRepository extends JpaRepository<RoadTax, Long> {
    RoadTax findRoadTaxByRoadType(String roadType);
    @Transactional
    void deleteRoadTaxByRoadType(String roadType);
}
