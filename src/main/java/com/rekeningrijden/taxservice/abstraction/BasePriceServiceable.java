package com.rekeningrijden.taxservice.abstraction;

import com.rekeningrijden.taxservice.dto.BasePriceDto;

import java.math.BigDecimal;
import java.util.List;

public interface BasePriceServiceable {
    void saveBasePrice(BasePriceDto basePriceDto);
    List<BasePriceDto> getBasePrices();
    BigDecimal getKilometerTaxByEngineType(String engineType);
    BasePriceDto updateBasePrice(BasePriceDto basePriceDto);
    void deleteBasePrice(BasePriceDto basePriceDto);
}
