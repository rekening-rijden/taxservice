package com.rekeningrijden.taxservice.controller;

import com.rekeningrijden.taxservice.abstraction.BasePriceServiceable;
import com.rekeningrijden.taxservice.dto.BasePriceDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(path="/baseprice")
@CrossOrigin(origins = "*")
public class BasePriceController {

    private final BasePriceServiceable basePriceService;
    private final Logger logger = LoggerFactory.getLogger(BasePriceController.class);

    @Autowired
    public BasePriceController(BasePriceServiceable basePriceService) {
        this.basePriceService = basePriceService;
    }

    @GetMapping(path="/all")
    public @ResponseBody ResponseEntity<List<BasePriceDto>> getBasePrices(){
        logger.info("Get all baseprices");
        return new ResponseEntity<>(basePriceService.getBasePrices(), HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<BigDecimal> getKilometerTaxByEngineType(@RequestParam String engineType){
        logger.info("Get kilometer tax for engineType: " + engineType);
        return new ResponseEntity<>(basePriceService.getKilometerTaxByEngineType(engineType), HttpStatus.OK);
    }

    @PostMapping
    public @ResponseBody ResponseEntity<BasePriceDto> postBasePrice(@RequestBody BasePriceDto basePriceDto){
        try {
            logger.info("Post baseprice for object: " + basePriceDto.toString());
            basePriceService.saveBasePrice(basePriceDto);
        }catch (Exception e){
            logger.error("Post baseprice encountered exception: " + e.getMessage());
            return new ResponseEntity<>(basePriceDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(basePriceDto, HttpStatus.OK);
    }

    @PutMapping
    public @ResponseBody ResponseEntity<BasePriceDto> putBasePrice(@RequestBody BasePriceDto basePriceDto){
        logger.info("Put baseprice");
        return new ResponseEntity<>(basePriceService.updateBasePrice(basePriceDto), HttpStatus.OK);
    }

    @DeleteMapping
    public @ResponseBody ResponseEntity<HttpStatus> deleteBasePrice(@RequestParam String engineType){
        try {
            System.out.println(engineType);
            basePriceService.deleteBasePriceByEngineType(engineType);
        }catch (Exception e){
            logger.error("Delete baseprice encountered exception: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
