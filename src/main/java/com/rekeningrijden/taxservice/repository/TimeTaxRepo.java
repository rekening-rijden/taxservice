package com.rekeningrijden.taxservice.repository;

import com.rekeningrijden.taxservice.dto.TimeTaxDto;
import org.springframework.data.repository.Repository;

public interface TimeTaxRepo extends Repository<TimeTaxDto, Long> {
}
