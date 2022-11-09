package com.rekeningrijden.taxservice.dto;

import java.math.BigDecimal;

public class RoadTaxDto {

    private BigDecimal surTax;
    private String roadType;

    public RoadTaxDto() {}

    public RoadTaxDto(BigDecimal surTax, String roadType) {
        this.surTax = surTax;
        this.roadType = roadType;
    }

    public BigDecimal getSurTax() {
        return surTax;
    }

    public void setSurTax(BigDecimal surTax) {
        this.surTax = surTax;
    }

    public String getRoadType() {
        return roadType;
    }

    public void setRoadType(String roadType) {
        this.roadType = roadType;
    }
}
