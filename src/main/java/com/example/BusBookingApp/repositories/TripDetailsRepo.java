package com.example.BusBookingApp.repositories;

import com.example.BusBookingApp.model.TripDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripDetailsRepo extends CrudRepository<TripDetails,Integer> {
}
