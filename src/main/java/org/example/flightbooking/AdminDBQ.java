package org.example.flightbooking;

import java.sql.SQLException;

public interface AdminDBQ {

    //this will hold all the queries to get data from the database

    public String adminRegister(String employeeId, String username, String password, String confirmPassword,
                                    String firstName, String lastName) throws SQLException; // should get registration information and add a new customer using INSERT
    public boolean adminLogIn(String Username, String Password) throws SQLException; // should get username and password using SELECT Query

    public String adminUpdateFlight(String FlightId, String FlightNumber, String DepartureCity, String ArrivalCity, String DepartureTime, String ArrivalTime, String Terminal)
        throws SQLException;
    public String adminDeleteFlight(String FlightID) throws SQLException; // should delete flight for specified USER using DELETE query;
    public String adminInsertFlight(String Flight_ID, String Flight_Number, String Departure_City, String Arrival_City, String Departure_Time,
                                    String Arrival_Time, String Terminal) throws SQLException;

    }



