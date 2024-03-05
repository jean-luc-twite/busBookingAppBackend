package com.example.BusBookingApp.model;

import jakarta.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class TripDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String board_from;
    private String destination;

    @Temporal(TemporalType.DATE)
    private Date date;

    public TripDetails() {
    }

    public TripDetails(int id, String board_from, String destination, Date date) {
        this.id = id;
        this.board_from = board_from;
        this.destination = destination;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBoard_from() {
        return board_from;
    }

    public void setBoard_from(String board_from) {
        this.board_from = board_from;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(date);
    }

    public void setDate(String date) throws ParseException {
        this.date = parseDate(date);
    }

    private Date parseDate(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.parse(date);
    }
}
