package com.example.bankmicroservice.repositories;

import com.example.bankmicroservice.entities.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankRepository extends JpaRepository<Bank, String> {
    boolean existsBySwiftCode(String swiftCode);

    List<Bank> findAllByStatus(boolean b);
}
