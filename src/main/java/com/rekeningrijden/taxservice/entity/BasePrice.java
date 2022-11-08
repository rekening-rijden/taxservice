package com.rekeningrijden.taxservice.entity;

import java.math.BigDecimal;

public class BasePrice {

    private Long id;
    private BigDecimal kilometerTax;
    private String carType;

    public BasePrice() {}

    public BasePrice(Long id, BigDecimal kilometerTax, String carType) {
        this.id = id;
        this.kilometerTax = kilometerTax;
        this.carType = carType;
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

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}
