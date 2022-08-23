package com.example.bankmicroservice.repositories;

import com.example.bankmicroservice.entities.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District, String> {
    boolean existsByNameAndBankId(String name, String bankId);
    List<District> findAllByBankIdAndStatus(String bankId, boolean b);
    void deleteAllByBankId(String bankId);

    District findByBankId(String bankId);

    void deleteByBankIdAndId(String bankId, String districtId);

    District findByBankIdAndId(String bankId, String districtId);
}
