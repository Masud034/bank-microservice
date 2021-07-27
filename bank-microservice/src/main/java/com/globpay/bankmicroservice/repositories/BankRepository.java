package com.globpay.bankmicroservice.repositories;

import com.globpay.bankmicroservice.entities.Bank;
import org.springframework.data.repository.CrudRepository;

public interface BankRepository extends CrudRepository<Bank, String> {

}
