package com.example.BusBookingApp.services;

import com.example.BusBookingApp.model.*;
import com.example.BusBookingApp.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripDetailsServices {

    @Autowired
    private TripDetailsRepo tripDetailsRepo;
    @Autowired
    private BookPackageRepo bookPackageRepo;
   @Autowired
   private PassengerRepo passengerRepo;
   @Autowired
   private BankRepo bankRepo;
   @Autowired
   private UserProfileRepo userProfileRepo;
    public TripDetails saveTripDetails(TripDetails tripDetails){
        return  tripDetailsRepo.save(tripDetails);
    }

    public BookPackage savePackage(BookPackage bookPackage){
        return  bookPackageRepo.save(bookPackage);
    }
    public Passengers  savePassenger(Passengers passengers){
        return passengerRepo.save(passengers);

    }
    public BankAccount createBank(BankAccount bankAccount){
        return bankRepo.save(bankAccount);
    }
    public BankAccount findBank(String cardNumber){
        return bankRepo.findByCardNumber(cardNumber).orElseThrow(()->new RuntimeException(cardNumber));
    }
    public BookPackage findBookPrice(double price){
        return bookPackageRepo.findByPrice(price).orElseThrow(()->new RuntimeException(String.valueOf(price)));
    }
    public UserProfile saveProfile(UserProfile userProfile){
        return userProfileRepo.save(userProfile);
    }

}
