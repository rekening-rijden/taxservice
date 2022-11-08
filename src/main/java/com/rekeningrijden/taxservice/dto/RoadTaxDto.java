package com.rekeningrijden.taxservice.dto;

import java.math.BigDecimal;

public class RoadTaxDto {

    private Long id;
    private BigDecimal surTax;
    private String roadTax;

    public RoadTaxDto() {}

    public RoadTaxDto(Long id, BigDecimal surTax, String roadTax) {
        this.id = id;
        this.surTax = surTax;
        this.roadTax = roadTax;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSurTax() {
        return surTax;
    }

    public void setSurTax(BigDecimal surTax) {
        this.surTax = surTax;
    }

    public String getRoadTax() {
        return roadTax;
    }

    public void setRoadTax(String roadTax) {
        this.roadTax = roadTax;
    }
}
