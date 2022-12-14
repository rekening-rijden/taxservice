package com.rekeningrijden.taxservice.abstraction;

import com.rekeningrijden.taxservice.dto.RoadTaxDto;

import java.math.BigDecimal;
import java.util.List;

public interface RoadTaxServiceable {
    void saveRoadTax(RoadTaxDto roadTaxDto);
    List<RoadTaxDto> getRoadTaxes();
    BigDecimal getSurTaxByRoadType(String roadType);
    RoadTaxDto updateRoadTax(RoadTaxDto roadTaxDto);
    void deleteRoadTaxByRoadType(String roadType);
}
