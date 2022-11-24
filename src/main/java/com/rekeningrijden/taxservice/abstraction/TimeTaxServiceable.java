package com.rekeningrijden.taxservice.abstraction;

import com.rekeningrijden.taxservice.dto.TimeTaxDto;
import com.rekeningrijden.taxservice.entity.TimeTax;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

public interface TimeTaxServiceable {
    List<TimeTaxDto> getTimeTaxes();
    BigDecimal getSurTaxByDateTimeAndDayOfWeek(LocalTime startTime, LocalTime endTime, int dayOfWeek);
    List<TimeTaxDto> getSurTaxByDayOfWeek(List<Integer> dayOfWeek);
    TimeTaxDto updateTimeTax(TimeTaxDto timeTaxDto);
    void deleteTimeTax(TimeTaxDto timeTaxDto);
}
