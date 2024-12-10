package org.example.flightbooking;

import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface CustomerDBQ {

    //this will hold all the queries to get data from the database

    public String register(String Username, String Password, String FirstName, String LastName, String Email, String address, String SSN,
                                  String SecurityQuestion, String SecurityAnswer) throws SQLException; // should get registration information and add a new customer using INSERT
    public boolean logIn(String Username, String Password) throws SQLException; // should get username and password using SELECT Query

    public String retrievePassword(String Username, String SecurityQuestion, String SecurityAnswer) throws SQLException; // should get password using SELECT query

    public String deleteFlight(String FlightID) throws SQLException; // should delete flight using DELETE query

    public String bookFlight(String Username, String Flight_ID, String Seat_Number) throws SQLException;

    public String getUserFlights(String Username) throws SQLException;// should add a booked flight using INSERT query

    public ObservableList<Flight> getAllFlights () throws SQLException;

    //public void changePassword(String Password, String Username) throws SQLException; // should change password with new password using UPDATE query

    //public void updateFlight(String DepartureTime, String Arrival_Time, String Terminal, String Flight_ID) throws SQLException; // should change flight with new flight using UPDATE query

    }




