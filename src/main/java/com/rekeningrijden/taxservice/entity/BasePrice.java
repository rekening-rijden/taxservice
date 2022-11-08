package com.rekeningrijden.taxservice.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "BasePrice")
public class BasePrice {

    @Id
    private String engineType;
    private BigDecimal kilometerTax;

    public BasePrice() {}

    public BasePrice(BigDecimal kilometerTax, String engineType) {
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
