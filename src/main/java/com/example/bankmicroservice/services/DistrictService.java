package com.example.bankmicroservice.services;

import com.example.bankmicroservice.entities.District;
import com.example.bankmicroservice.exceptions.DuplicateDistrictException;
import com.example.bankmicroservice.repositories.DistrictRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DistrictService {

    private final DistrictRepository districtRepository;

    public District addDistrict(String bankId, District district) {
        if (districtRepository.existsByNameAndBankId(district.getName(), bankId))
            throw new DuplicateDistrictException("This district is already registered with this bank");
        district.setBankId(bankId);
        return districtRepository.save(district);
    }

    public List<District> getAllDistrict(String bankId) {
        return districtRepository.findAllByBankId(bankId);
    }
}
