package com.example.demo.deductible;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class DeductibleRestController {

    private final DeductibleService deductibleService;

    public DeductibleRestController(DeductibleService deductibleService) {
        this.deductibleService = deductibleService;
    }

    @GetMapping("/deductibles")
    public ResponseEntity<List<DeductibleDto>> findAll() {
        List<DeductibleDto> deductibles = new ArrayList<>();
        for (Deductible deductible : deductibleService.findAll()) {
            deductibles.add(DeductibleDto.fromDeductible(deductible));
        }
        return new ResponseEntity<>(deductibles, HttpStatus.OK);
    }

    @GetMapping("/deductibles/{id}")
    public ResponseEntity<List<DeductibleDto>> findByInsuranceId(@PathVariable Integer id) {
        List<DeductibleDto> deductibles = new ArrayList<>();
        for (Deductible deductible : deductibleService.findByInsuranceId(id)) {
            deductibles.add(DeductibleDto.fromDeductible(deductible));
        }
        return new ResponseEntity<>(deductibles, HttpStatus.OK);
    }

    @GetMapping("/deductible/{id}")
    public ResponseEntity<DeductibleDto> getDeductible(@PathVariable Integer id) {
        Deductible deductible = deductibleService.findById(id);
        if (deductible == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(DeductibleDto.fromDeductible(deductible), HttpStatus.OK);
    }

    @PostMapping("/deductible")
    public ResponseEntity<DeductibleDto> addDeductible(@RequestBody DeductibleDto deductibleDto) {
         if (deductibleDto.getId() != null) {
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
         }
        deductibleService.save(DeductibleDto.toDeductible(deductibleDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("deductible/{id}")
    public ResponseEntity<DeductibleDto> updateDeductible(@RequestBody DeductibleDto deductibleDto, @PathVariable Integer id) {
        // get deductible by id from database
        // find absolute value of difference between deductible in table and incoming deductible
        // update values in patient_deductible where deductible_id = deductible.getId and
        //   apply difference (+/-) of absolute value

        deductibleDto.setId(id);
        deductibleService.save(DeductibleDto.toDeductible(deductibleDto));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("deductible/{id}")
    public ResponseEntity<DeductibleDto> deleteDeductibleById(@PathVariable Integer id) {
        try {
            deductibleService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
