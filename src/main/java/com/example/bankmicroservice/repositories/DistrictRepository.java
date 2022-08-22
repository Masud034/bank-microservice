package com.example.bankmicroservice.repositories;

import com.example.bankmicroservice.entities.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District, String> {
    boolean existsByNameAndBankId(String name, String bankId);

    List<District> findAllByBankId(String bankId);
}
