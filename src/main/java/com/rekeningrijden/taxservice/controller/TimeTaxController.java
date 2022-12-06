package com.rekeningrijden.taxservice.controller;

import com.rekeningrijden.taxservice.abstraction.TimeTaxServiceable;
import com.rekeningrijden.taxservice.dto.TimeTaxDto;
import com.rekeningrijden.taxservice.entity.TimeTax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/timetax")
public class TimeTaxController {

    private final TimeTaxServiceable timeTaxService;

    @Autowired
    public TimeTaxController(TimeTaxServiceable timeTaxService) {
        this.timeTaxService = timeTaxService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TimeTaxDto>> getTimeTaxes() {
        return new ResponseEntity<>(timeTaxService.getTimeTaxes(), HttpStatus.OK);
    }

    @GetMapping(params = "daysofweek")
    public @ResponseBody ResponseEntity<List<TimeTaxDto>> getSurTaxByDaysOfWeek(@RequestParam List<Integer> daysofweek) {
        return new ResponseEntity<>(timeTaxService.getSurTaxByDayOfWeek(daysofweek), HttpStatus.OK);
    }

    @PutMapping
    public @ResponseBody ResponseEntity<?> updateTimeTax(@RequestBody TimeTaxDto timeTaxDto) {
        System.out.println("Put time tax");
        return new ResponseEntity<>(timeTaxService.updateTimeTax(timeTaxDto), HttpStatus.OK);
    }
}
