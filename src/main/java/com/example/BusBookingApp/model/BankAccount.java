package com.example.BusBookingApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String holderName;
    private String cardNumber;
    @Temporal(TemporalType.DATE)
    private Date expiredDate;
    private String cvv;
    private double price;

    public BankAccount() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiredDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-yy");
        return dateFormat.format(expiredDate);

    }

    public void setExpiredDate(String expiredDate) throws ParseException {
        this.expiredDate = parseDate(expiredDate);
    }

    public String getCVV() {
        return cvv;
    }

    public void setCVV(String CVV) {
        this.cvv = CVV;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    private Date parseDate(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-yy");
        return dateFormat.parse(date);
    }
}
