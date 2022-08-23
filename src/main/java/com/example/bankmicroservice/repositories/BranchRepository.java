package com.example.bankmicroservice.repositories;

import com.example.bankmicroservice.entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<Branch, String> {
    boolean existsByRoutingNumber(String routingNumber);

    List<Branch> findByBankIdAndDistrictIdAndStatus(String bankId, String districtId, boolean b);

    void deleteAllByBankId(String bankId);

    void deleteByDistrictId(String districtId);
}
