package com.example.BusBookingApp.repositories;

import com.example.BusBookingApp.model.BankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankRepo extends CrudRepository<BankAccount,Integer>{
    Optional<BankAccount> findByCardNumber(String cardNumber);
}
