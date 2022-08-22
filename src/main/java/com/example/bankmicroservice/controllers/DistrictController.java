package com.example.bankmicroservice.controllers;

import com.example.bankmicroservice.entities.District;
import com.example.bankmicroservice.services.DistrictService;
import com.example.bankmicroservice.utils.EndpointsUtils;
import com.example.bankmicroservice.validators.BankIdMustExist;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
public class DistrictController {

    private final DistrictService districtService;

    @PostMapping(value = EndpointsUtils.ADD_DISTRICT)
    public District addDistrict(@PathVariable @BankIdMustExist String bankId, @Valid @RequestBody District district) {
        return districtService.addDistrict(bankId, district);
    }

    @GetMapping(value = EndpointsUtils.GET_ALL_DISTRICT)
    public List<District> getAllDistrict(@PathVariable @BankIdMustExist String bankId) {
        return districtService.getAllDistrict(bankId);
    }
}
