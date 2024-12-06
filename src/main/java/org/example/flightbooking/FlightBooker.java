package org.example.flightbooking;

import java.util.ArrayList;

public abstract interface FlightBooker {

    //this will hold all the queries to get data from the database

    public abstract void register(); // should get registration information and add a new customer using INSERT
    public abstract void logIn(); // should get username and password using SELECT Query
    public abstract void bookFlight(); // should add a booked flight using INSERT query
    public abstract void retrievePassword(); // should get password using SELECT query
    public abstract void changePassword(); // should change password with new password using UPDATE query
    public abstract void updateFlight(); // should change flight with new flight using UPDATE query
    public abstract void deleteFlight(); // should delete flight using DELETE query
    public abstract void adminBookFlight(); // should add a booked flight for specified USER using INSERT query
    public abstract void adminUpdateFlight(); // should change flight with new flight for specified USER using UPDATE query
    public abstract void adminDeleteFlight(); // should delete flight for specified USER using DELETE query

    }



