package org.example.flightbooking;

import java.util.ArrayList;

public abstract class FlightBooker {
    private ArrayList flightsAvailable;
    private ArrayList flightsBooked;
    private ArrayList seatsAvailable;
    private ArrayList seatsBooked;
    private ArrayList accommodations;

    public abstract void BookFlight();
    public abstract void RetrievePassword();
    public abstract void ChangePassword();
    public abstract void UpdateFlight();
    public abstract void DeleteFlight();
    public abstract void AdminBookFlight();
    public abstract void AdminUpdateFlight();
    public abstract void AdminDeleteFlight();

    }



