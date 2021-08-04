package com.globpay.bankmicroservice.repositories;

import com.globpay.bankmicroservice.entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, String> {

}
