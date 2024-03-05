package com.example.BusBookingApp.controller;

import com.example.BusBookingApp.classerequest.VerificationRequest;
import com.example.BusBookingApp.model.*;
import com.example.BusBookingApp.repositories.PassengerRepo;
import com.example.BusBookingApp.services.TripDetailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private TripDetailsServices tripDetailsServices;
    @Autowired
    private PassengerRepo passengerRepo;

    @PostMapping("/details/saveDetails")
    public TripDetails tripDetails(@RequestBody TripDetails tripDetails){

        return  tripDetailsServices.saveTripDetails(tripDetails);
    }
    @PostMapping("/BookPackages/addPackages")
    public BookPackage bookPackage(@RequestBody BookPackage bookPackage){
        return  tripDetailsServices.savePackage(bookPackage);
    }
    @PostMapping("/passengers/addPassengers")
    public Passengers creatpassenger(@RequestBody Passengers passengers){
        return  tripDetailsServices.savePassenger(passengers);
    }
    @PostMapping("/passengers/addListPassengers")
    public ResponseEntity<String> addPassengers(@RequestBody List<Passengers> passengers) {
        try {
            // Save the list of passengers to the database
            passengerRepo.saveAll(passengers);
            return ResponseEntity.ok("Passengers saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save passengers");
        }
    }
@PostMapping("/bank/addBankAccount")
    public BankAccount creatBank(@RequestBody BankAccount bankAccount){
        return tripDetailsServices.createBank(bankAccount);
}
    @PostMapping("/accounts/verify-and-deduct")
    public ResponseEntity<String> verifyAndDeduct(@RequestBody VerificationRequest request) {
        String cardNumber = request.getCardNumber();
        double paymentAmount = request.getPaymentAmount();

        // Perform account verification logic (check if the account exists).
        BankAccount account = tripDetailsServices.findBank(cardNumber);

        if (account == null) {
            return ResponseEntity.badRequest().body("Account not found");
        }

        if (account.getPrice() < paymentAmount) {
            return ResponseEntity.badRequest().body("Insufficient funds");
        }

        // Deduct the payment amount from the account.
        account.setPrice(account.getPrice() - paymentAmount);
        tripDetailsServices.createBank(account);

        return ResponseEntity.ok("Payment successful. Remaining balance: " + account.getPrice());
    }
    @PostMapping("/books/verify")
    public ResponseEntity<String> verifyPrice(@RequestBody VerificationRequest request) {
        double price = request.getPrice();


        // Perform account verification logic (check if the account exists).
        BookPackage priceBook = tripDetailsServices.findBookPrice(price);


        if (priceBook != null) {
            return ResponseEntity.badRequest().body("found");
        }

        return ResponseEntity.ok("fund not found");
    }
    @PostMapping("/userProfile/saveUserProfile")
    public UserProfile addProfile(@RequestBody UserProfile userProfile){
        return tripDetailsServices.saveProfile(userProfile);
    }
}
