package com.globpay.bankmicroservice.repositories;

import com.globpay.bankmicroservice.entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BranchRepository extends JpaRepository<Branch, String> {
    public List<Branch> findByBankId(String bankId);

    boolean existsByRoutingNumber(String routingNumber);
}
