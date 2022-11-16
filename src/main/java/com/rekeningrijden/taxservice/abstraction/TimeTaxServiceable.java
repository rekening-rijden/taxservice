package com.rekeningrijden.taxservice.abstraction;

import com.rekeningrijden.taxservice.dto.TimeTaxDto;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

public interface TimeTaxServiceable {
    void saveTimeTax(TimeTaxDto timeTaxDto);
    List<TimeTaxDto> getTimeTaxes();
    BigDecimal getSurTaxByDateTime(LocalTime startTime, LocalTime endTime);
    TimeTaxDto updateTimeTax(TimeTaxDto timeTaxDto);
    void deleteTimeTax(TimeTaxDto timeTaxDto);
}
