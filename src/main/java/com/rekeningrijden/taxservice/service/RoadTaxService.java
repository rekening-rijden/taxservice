package com.rekeningrijden.taxservice.service;

import com.rekeningrijden.taxservice.abstraction.RoadTaxServiceable;
import com.rekeningrijden.taxservice.dto.RoadTaxDto;
import com.rekeningrijden.taxservice.entity.RoadTax;
import com.rekeningrijden.taxservice.publisher.UpdateProducer;
import com.rekeningrijden.taxservice.repository.RoadTaxRepository;
import com.rekeningrijden.taxservice.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RoadTaxService implements RoadTaxServiceable {

    private final RoadTaxRepository roadTaxRepo;
    private UpdateProducer producer;

    @Autowired
    public RoadTaxService(RoadTaxRepository roadTaxRepo, UpdateProducer producer) {
        this.roadTaxRepo = roadTaxRepo;
        this.producer = producer;
    }

    @Override
    public void saveRoadTax(RoadTaxDto roadTaxDto) {
        roadTaxRepo.save(ObjectMapperUtils.map(roadTaxDto, RoadTax.class));
    }

    @Override
    public List<RoadTaxDto> getRoadTaxes() {
        return ObjectMapperUtils.mapAll(roadTaxRepo.findAll(), RoadTaxDto.class);
    }

    @Override
    public BigDecimal getSurTaxByRoadType(String roadType) {
        return roadTaxRepo.findRoadTaxByRoadType(roadType).getSurTax();
    }

    @Override
    public RoadTaxDto updateRoadTax(RoadTaxDto roadTaxDto) {
        RoadTaxDto response = ObjectMapperUtils.map(roadTaxRepo.save(ObjectMapperUtils.map(roadTaxDto, RoadTax.class)), RoadTaxDto.class);
        this.producer.sendMessage(roadTaxDto);
        return response;
    }

    @Override
    public void deleteRoadTax(RoadTaxDto roadTaxDto) {
        roadTaxRepo.delete(ObjectMapperUtils.map(roadTaxDto, RoadTax.class));
    }
}
