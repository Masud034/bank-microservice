package com.globpay.bankmicroservice.repositories;

import com.globpay.bankmicroservice.entities.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BankRepository extends JpaRepository<Bank, String> {

    @Override
    List<Bank> findAll();
    boolean existsByName(String name);
}
