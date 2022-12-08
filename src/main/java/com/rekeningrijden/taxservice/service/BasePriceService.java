package com.rekeningrijden.taxservice.service;

import com.rekeningrijden.taxservice.abstraction.BasePriceServiceable;
import com.rekeningrijden.taxservice.entity.BasePrice;
import com.rekeningrijden.taxservice.dto.BasePriceDto;
import com.rekeningrijden.taxservice.publisher.UpdateProducer;
import com.rekeningrijden.taxservice.repository.BasePriceRepository;
import com.rekeningrijden.taxservice.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BasePriceService implements BasePriceServiceable {

    private final BasePriceRepository basePriceRepo;
    private UpdateProducer producer;

    @Autowired
    public BasePriceService(BasePriceRepository basePriceRepo, UpdateProducer producer) {
        this.basePriceRepo = basePriceRepo;
        this.producer = producer;
    }

    @Override
    public void saveBasePrice(BasePriceDto basePriceDto) {
        basePriceRepo.save(ObjectMapperUtils.map(basePriceDto, BasePrice.class));
    }

    @Override
    public List<BasePriceDto> getBasePrices() {
        return ObjectMapperUtils.mapAll(basePriceRepo.findAll(), BasePriceDto.class);
    }

    @Override
    public BigDecimal getKilometerTaxByEngineType(String engineType) {
        return basePriceRepo.findByEngineType(engineType).getSurTax();
    }

    @Override
    public BasePriceDto updateBasePrice(BasePriceDto basePriceDto) {
        BasePriceDto response = ObjectMapperUtils.map(basePriceRepo.save(ObjectMapperUtils.map(basePriceDto, BasePrice.class)), BasePriceDto.class);
        producer.sendMessage(basePriceDto);
        return response;
    }

    @Override
    @Transactional
    public void deleteBasePriceByEngineType(String engineType) {
        basePriceRepo.deleteBasePriceByEngineType(engineType);
    }

}
