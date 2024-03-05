package com.example.BusBookingApp.repositories;

import com.example.BusBookingApp.model.UserProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepo extends CrudRepository<UserProfile,Integer> {

}
