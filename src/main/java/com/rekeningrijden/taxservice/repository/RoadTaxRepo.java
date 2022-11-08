package com.rekeningrijden.taxservice.repository;

import com.rekeningrijden.taxservice.dto.RoadTaxDto;
import org.springframework.data.repository.Repository;

public interface RoadTaxRepo extends Repository<RoadTaxDto, Long> {
}
