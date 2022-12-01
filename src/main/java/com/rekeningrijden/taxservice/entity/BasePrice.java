package com.rekeningrijden.taxservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "BASEPRICE")
@Data
public class BasePrice {

    @Id
    private String engineType;
    private BigDecimal surTax;

    public BasePrice() {}

    public BasePrice(BigDecimal kilometerTax, String engineType) {
        this.surTax = kilometerTax;
        this.engineType = engineType;
    }

    public BigDecimal getSurTax() {
        return surTax;
    }

    public void setSurTax(BigDecimal kilometerTax) {
        this.surTax = kilometerTax;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
}
