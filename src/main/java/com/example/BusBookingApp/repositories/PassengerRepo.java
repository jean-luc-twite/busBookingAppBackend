package com.example.BusBookingApp.repositories;

import com.example.BusBookingApp.model.Passengers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepo extends CrudRepository<Passengers,Integer> {
}
