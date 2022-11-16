package com.rekeningrijden.taxservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.time.LocalTime;

public class TimeTaxDto {

    @JsonIgnore
    private Long id;
    private BigDecimal surTax;
    private LocalTime startTime;
    private LocalTime endTime;
    private int dayOfWeek;

    public TimeTaxDto() {}

    public TimeTaxDto(Long id, BigDecimal surTax, LocalTime startTime, LocalTime endTime, int dayOfWeek) {
        this.id = id;
        this.surTax = surTax;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayOfWeek = dayOfWeek;
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

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
