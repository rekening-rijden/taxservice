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

@Service
public class TimeTaxService implements TimeTaxServiceable {

    private final TimeTaxRepository timeTaxRepo;

    @Autowired
    public TimeTaxService(TimeTaxRepository timeTaxRepo) {
        this.timeTaxRepo = timeTaxRepo;
    }

    @Override
    public void saveTimeTax(TimeTaxDto timeTaxDto) {
        timeTaxRepo.save(ObjectMapperUtils.map(timeTaxDto, TimeTax.class));
    }

    @Override
    public List<TimeTaxDto> getTimeTaxes() {
        return ObjectMapperUtils.mapAll(timeTaxRepo.findAll(), TimeTaxDto.class);
    }

    @Override
    public BigDecimal getSurTaxByDateTime(LocalTime startTime, LocalTime endTime) {

        return null;
    }

    @Override
    public TimeTaxDto updateTimeTax(TimeTaxDto timeTaxDto) {
        return ObjectMapperUtils.map(timeTaxRepo.save(ObjectMapperUtils.map(timeTaxDto, TimeTax.class)), TimeTaxDto.class);
    }

    @Override
    public void deleteTimeTax(TimeTaxDto timeTaxDto) {
        timeTaxRepo.delete(ObjectMapperUtils.map(timeTaxDto, TimeTax.class));
    }

}
