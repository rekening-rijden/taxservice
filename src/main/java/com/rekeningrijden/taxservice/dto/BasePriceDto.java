package com.rekeningrijden.taxservice.dto;

import java.math.BigDecimal;

public class BasePriceDto {

    private BigDecimal kilometerTax;
    private String engineType;

    public BasePriceDto() {}

    public BasePriceDto(BigDecimal kilometerTax, String engineType) {
        this.kilometerTax = kilometerTax;
        this.engineType = engineType;
    }

    public BigDecimal getKilometerTax() {
        return kilometerTax;
    }

    public void setKilometerTax(BigDecimal kilometerTax) {
        this.kilometerTax = kilometerTax;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
}
