package com.rekeningrijden.taxservice.dto;

import java.math.BigDecimal;

public class BasePriceDto {

    private BigDecimal surTax;
    private String engineType;

    public BasePriceDto() {}

    public BasePriceDto(BigDecimal kilometerTax, String engineType) {
        this.surTax = kilometerTax;
        this.engineType = engineType;
    }

    public BigDecimal getSurTax() {
        return surTax;
    }

    public void setSurTax(BigDecimal surTax) {
        this.surTax = surTax;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
}
