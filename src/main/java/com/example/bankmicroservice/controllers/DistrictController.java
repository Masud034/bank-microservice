package com.example.bankmicroservice.controllers;

import com.example.bankmicroservice.entities.District;
import com.example.bankmicroservice.services.DistrictService;
import com.example.bankmicroservice.utils.EndpointsUtils;
import com.example.bankmicroservice.validators.BankIdMustExist;
import com.example.bankmicroservice.validators.DistrictIdMustExist;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
public class DistrictController {

    private final DistrictService districtService;

    //enlist a bank in a district
    @PostMapping(value = EndpointsUtils.ADD_DISTRICT)
    public ResponseEntity<District> addDistrict(@PathVariable @BankIdMustExist String bankId, @Valid @RequestBody District district) {
        return new ResponseEntity<>(districtService.addDistrict(bankId, district), HttpStatus.CREATED);
    }

    //Get all districtcs where bank is availabe
    @GetMapping(value = EndpointsUtils.GET_ALL_DISTRICT)
    public ResponseEntity<List<District>> getAllDistrict(@PathVariable @BankIdMustExist String bankId) {
        return new ResponseEntity<>(districtService.getAllDistrict(bankId), HttpStatus.OK);
    }

    @PutMapping(value = EndpointsUtils.UPDATE_DISTRICT_DETAILS)
    public ResponseEntity<District> updateDistrictDetails(@PathVariable @DistrictIdMustExist String districtId,
                                                          @RequestBody District district) {
        return new ResponseEntity<>(districtService.updateDistrictDetails(districtId, district), HttpStatus.OK);
    }

    @DeleteMapping(value = EndpointsUtils.DELETE_DISTRICT)
    public ResponseEntity<String> deleteDistrict(@PathVariable String districtId) {
        districtService.deleteDistrict(districtId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
