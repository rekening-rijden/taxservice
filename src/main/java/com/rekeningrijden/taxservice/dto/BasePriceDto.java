package com.rekeningrijden.taxservice.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity(name = "BasePrice")
public class BasePriceDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal kilometerTax;
    private String carType;

    public BasePriceDto() {}

    public BasePriceDto(Long id, BigDecimal kilometerTax, String carType) {
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
