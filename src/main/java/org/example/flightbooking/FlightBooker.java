package org.example.flightbooking;

import java.util.ArrayList;

public abstract interface FlightBooker {

    public abstract void logIn();
    public abstract void bookFlight();
    public abstract void retrievePassword();
    public abstract void changePassword();
    public abstract void updateFlight();
    public abstract void deleteFlight();
    public abstract void adminBookFlight();
    public abstract void adminUpdateFlight();
    public abstract void adminDeleteFlight();

    }



