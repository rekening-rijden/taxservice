package com.rekeningrijden.taxservice.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity(name = "ROADTAX")
@Data
public class RoadTax {

    @Id
    private String roadType;
    private BigDecimal surTax;

    public RoadTax() {}

    public RoadTax(BigDecimal surTax, String roadType) {
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

    public void setRoadType(String roadTax) {
        this.roadType = roadTax;
    }
}
