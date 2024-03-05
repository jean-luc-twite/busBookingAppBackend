package com.example.BusBookingApp.repositories;

import com.example.BusBookingApp.model.BookPackage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookPackageRepo extends CrudRepository<BookPackage,Integer> {


    Optional<BookPackage> findByPrice(double price);
}
