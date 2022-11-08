package com.rekeningrijden.taxservice.abstraction;

import com.rekeningrijden.taxservice.entity.BasePrice;

import java.math.BigDecimal;
import java.util.List;

public interface BasePriceServiceable {
    void saveBasePrice(BasePrice basePrice);
    List<BasePrice> getBasePrices();
    BigDecimal getKilometerTaxForEngineType(String engineType);
}
