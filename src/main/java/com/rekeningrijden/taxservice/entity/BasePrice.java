package com.rekeningrijden.taxservice.entity;

import java.math.BigDecimal;

public class BasePrice {

    private Long id;
    private BigDecimal kilometerTax;
    private String engineType;

    public BasePrice() {}

    public BasePrice(Long id, BigDecimal kilometerTax, String engineType) {
        this.id = id;
        this.kilometerTax = kilometerTax;
        this.engineType = engineType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
