package com.rekeningrijden.taxservice.controller;

import com.rekeningrijden.taxservice.abstraction.BasePriceServiceable;
import com.rekeningrijden.taxservice.dto.BasePriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path="/baseprice")
public class BasePriceController {

    private final BasePriceServiceable basePriceService;

    @Autowired
    public BasePriceController(BasePriceServiceable basePriceService) {
        this.basePriceService = basePriceService;
    }

    @GetMapping(path="/all")
    public @ResponseBody ResponseEntity<List<BasePriceDto>> getBasePrices(){
        return new ResponseEntity<>(basePriceService.getBasePrices(), HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<BigDecimal> getKilometerTaxByEngineType(@RequestParam String engineType){
        return new ResponseEntity<>(basePriceService.getKilometerTaxByEngineType(engineType), HttpStatus.OK);
    }

    @PostMapping
    public @ResponseBody ResponseEntity<String> postBasePrice(@RequestBody BasePriceDto basePriceDto){
        try {
            basePriceService.saveBasePrice(basePriceDto);
        }catch (Exception e){
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Baseprice saved", HttpStatus.OK);
    }

    @PutMapping
    public @ResponseBody ResponseEntity<BasePriceDto> putBasePrice(@RequestBody BasePriceDto basePriceDto){
        return new ResponseEntity<>(basePriceService.updateBasePrice(basePriceDto), HttpStatus.OK);
    }

    @DeleteMapping
    public @ResponseBody ResponseEntity<String> deleteBasePrice(@RequestBody BasePriceDto basePriceDto){
        try {
            basePriceService.deleteBasePrice(basePriceDto);
        }catch (Exception e){
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Baseprice deleted", HttpStatus.OK);
    }
}
