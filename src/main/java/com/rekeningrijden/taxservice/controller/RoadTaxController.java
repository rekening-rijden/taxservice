package com.rekeningrijden.taxservice.controller;

import com.rekeningrijden.taxservice.abstraction.RoadTaxServiceable;
import com.rekeningrijden.taxservice.dto.RoadTaxDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/roadtax")
public class RoadTaxController {

    private final RoadTaxServiceable roadTaxService;
    private final Logger logger = LoggerFactory.getLogger(RoadTaxController.class);

    @Autowired
    public RoadTaxController(RoadTaxServiceable roadTaxService) {
        this.roadTaxService = roadTaxService;
    }

    @GetMapping(path="/all")
    public @ResponseBody
    ResponseEntity<List<RoadTaxDto>> getRoadTaxes(){
        logger.info("Get all roadtaxes");
        return new ResponseEntity<>(roadTaxService.getRoadTaxes(), HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<BigDecimal> getKilometerTaxByEngineType(@RequestParam String roadType){
        logger.info("Get sur tax for roadType: " + roadType);
        return new ResponseEntity<>(roadTaxService.getSurTaxByRoadType(roadType), HttpStatus.OK);
    }

    @PostMapping
    public @ResponseBody ResponseEntity<String> postRoadTax(@RequestBody RoadTaxDto roadTaxDto){
        try {
            logger.info("Post road tax for object: " + roadTaxDto.toString());
            roadTaxService.saveRoadTax(roadTaxDto);
        }catch (Exception e){
            logger.error("Post road tax encountered exception: " + e.getMessage());
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Roadtax saved", HttpStatus.OK);
    }

    @PutMapping
    public @ResponseBody ResponseEntity<RoadTaxDto> putRoadTax(@RequestBody RoadTaxDto roadTaxDto){
        logger.info("Put road tax");
        return new ResponseEntity<>(roadTaxService.updateRoadTax(roadTaxDto), HttpStatus.OK);
    }

    @DeleteMapping
    public @ResponseBody ResponseEntity<String> deleteRoadTax(@RequestBody RoadTaxDto roadTaxDto){
        try {
            roadTaxService.deleteRoadTax(roadTaxDto);
        }catch (Exception e){
            logger.error("Delete road tax encountered exception: " + e.getMessage());
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Roadtax deleted", HttpStatus.OK);
    }

}
