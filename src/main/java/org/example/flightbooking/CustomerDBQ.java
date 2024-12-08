package org.example.flightbooking;

import java.sql.SQLException;

public abstract interface CustomerDBQ {

    //this will hold all the queries to get data from the database

    public abstract void register(String Username, String Password, String FirstName, String LastName, String Email,
                                  String PhoneNumber, String Street, String Zipcode, String State, String City, String SSN,
                                  String SecurityQuestion, String SecurityAnswer) throws SQLException; // should get registration information and add a new customer using INSERT
    public abstract void logIn(String Username, String Password) throws SQLException; // should get username and password using SELECT Query
    public abstract void bookFlight(String Booking_ID, String Username, String Flight_ID, String Seat_Number) throws SQLException; // should add a booked flight using INSERT query
    public abstract void retrievePassword(String Username, String SecurityQuestion, String SecurityAnswer) throws SQLException; // should get password using SELECT query
    public abstract void changePassword(String Password, String Username) throws SQLException; // should change password with new password using UPDATE query
    public abstract void updateFlight(String DepartureTime, String Arrival_Time, String Terminal, String Flight_ID) throws SQLException; // should change flight with new flight using UPDATE query
    public abstract void deleteFlight(String FlightID) throws SQLException; // should delete flight using DELETE query
    }



