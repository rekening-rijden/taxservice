package com.rekeningrijden.taxservice.service;

import com.rekeningrijden.taxservice.abstraction.TimeTaxServiceable;
import com.rekeningrijden.taxservice.dto.TimeTaxDto;
import com.rekeningrijden.taxservice.entity.TimeTax;
import com.rekeningrijden.taxservice.repository.TimeTaxRepository;
import com.rekeningrijden.taxservice.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class TimeTaxService implements TimeTaxServiceable {

    private final TimeTaxRepository timeTaxRepo;

    @Autowired
    public TimeTaxService(TimeTaxRepository timeTaxRepo) {
        this.timeTaxRepo = timeTaxRepo;
    }

    @Override
    public List<TimeTaxDto> getTimeTaxes() {
        return ObjectMapperUtils.mapAll(timeTaxRepo.findAll(), TimeTaxDto.class);
    }

    @Override
    public BigDecimal getSurTaxByDateTimeAndDayOfWeek(LocalTime startTime, LocalTime endTime, int dayOfWeek) {
        return null;
    }

    @Override
    public List<TimeTaxDto> getSurTaxByDayOfWeek(List<Integer> daysOfWeek) {
        return ObjectMapperUtils.mapAll(this.timeTaxRepo.findAllByDaysOfWeek(daysOfWeek), TimeTaxDto.class);
    }


    @Override
    public TimeTaxDto updateTimeTax(TimeTaxDto timeTaxDto) {
        // update time tax
        return timeTaxRepo.findById(timeTaxDto.getId()).map(timeTax -> {
            timeTax.setSurTax(timeTaxDto.getSurTax());
            return ObjectMapperUtils.map(timeTaxRepo.save(timeTax), TimeTaxDto.class);
        })
                .orElseGet(() -> {
                    TimeTax timeTax = ObjectMapperUtils.map(timeTaxDto, TimeTax.class);
                    return ObjectMapperUtils.map(timeTaxRepo.save(timeTax), TimeTaxDto.class);
                });

    }

    @Override
    public void deleteTimeTax(TimeTaxDto timeTaxDto) {
        timeTaxRepo.delete(ObjectMapperUtils.map(timeTaxDto, TimeTax.class));
    }
}
