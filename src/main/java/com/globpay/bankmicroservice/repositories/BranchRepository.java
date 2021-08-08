package com.globpay.bankmicroservice.repositories;

import com.globpay.bankmicroservice.entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<Branch, String> {

    List<Branch> findByBankId(String bankId);
    boolean existsByRoutingNumber(String routingNumber);
}
