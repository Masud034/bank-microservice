package com.example.bankmicroservice.services;

import com.example.bankmicroservice.entities.District;
import com.example.bankmicroservice.exceptions.DuplicateDistrictException;
import com.example.bankmicroservice.repositories.BranchRepository;
import com.example.bankmicroservice.repositories.DistrictRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
@RequiredArgsConstructor
public class DistrictService {

    private final DistrictRepository districtRepository;

    private final BranchRepository branchRepository;

    public District addDistrict(String bankId, District district) {
        if (districtRepository.existsByNameAndBankId(district.getName(), bankId))
            throw new DuplicateDistrictException("This district is already registered with this bank");
        district.setBankId(bankId);
        return districtRepository.save(district);
    }

    public List<District> getAllDistrict(String bankId) {
        return districtRepository.findAllByBankIdAndStatus(bankId, true)
                .stream()
                .sorted(Comparator.comparing(District :: getName))
                .collect(Collectors.toList());
    }

    public District updateDistrictDetails(String districtId, District district) {
        District fetchedDistrict = districtRepository.findById(districtId).get();
        fetchedDistrict.setName(district.getName());
        fetchedDistrict.setStatus(district.isStatus());
        return districtRepository.save(fetchedDistrict);
    }

    public void deleteDistrict(String districtId) {
        districtRepository.deleteById(districtId);
        branchRepository.deleteByDistrictId(districtId);
    }
}
