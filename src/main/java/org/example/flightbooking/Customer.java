package org.example.flightbooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class Customer extends Account implements CustomerDBQ {
    /*public Customer (String firstName, String lastName, String street,
                     String zipCode, String state, String username,
                    String password, String email, String SSN,
                     String secQuestion, String secAnswer, String secPIN) {

        super(firstName, lastName, street,
                zipCode, state, username,
                password, email, SSN,
                secQuestion, secAnswer, secPIN);
    }

     */
    public Customer(){

    }
    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://cis32702024.mysql.database.azure.com:3306/cosmas",
                "ezradegafe1", "GSUproject123");
        System.out.println("Database connected");
        return connection;
    }


    public void register(String Username, String Password, String FirstName, String LastName, String Email
            , String Address, String SSN, String SecurityQuestion, String SecurityAnswer) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement registerPs = connection.prepareStatement(Queries.REGISTER);

            // Set parameters for the PreparedStatement
            registerPs.setString(1, Username);
            registerPs.setString(2, Password);
            registerPs.setString(3, FirstName);
            registerPs.setString(4, LastName);
            registerPs.setString(5, Email);
            registerPs.setString(6, Address);
            registerPs.setString(7, SSN);
            registerPs.setString(8, SecurityQuestion);
            registerPs.setString(9, SecurityAnswer);

            // Execute the statement
            registerPs.executeUpdate();
            System.out.println("User registered successfully.");
            connection.close();
        }
    }
    @Override
    public void logIn(String Username, String Password) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement loginPs = connection.prepareStatement(Queries.LOGIN);

            loginPs.setString(1, Username);
            loginPs.setString(2, Password);

            loginPs.executeUpdate();
            System.out.println("Login successful.");
            connection.close();
        }
    }
    @Override
    public void retrievePassword(String Username, String SecurityQuestion, String SecurityAnswer) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement retrievePasswordPs = connection.prepareStatement(Queries.FORGOTPASSWORD);

            retrievePasswordPs.setString(1, Username);
            retrievePasswordPs.setString(2, SecurityQuestion);
            retrievePasswordPs.setString(3, SecurityAnswer);


            retrievePasswordPs.executeUpdate();
            System.out.println("Password Retrieved.");
            connection.close();
        }
    }
    @Override
    public void changePassword(String Password, String Username) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement changePasswordPs = connection.prepareStatement(Queries.CHANGEPASSWORD);

            changePasswordPs.setString(1, Password);
            changePasswordPs.setString(2, Username);


            changePasswordPs.executeUpdate();
            System.out.println("Password Changed.");
            connection.close();
        }
    }

    @Override
    public void bookFlight(String Booking_ID, String Username, String Flight_ID, String Seat_Number)
            throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement bookFlightPs = connection.prepareStatement(Queries.BOOKFLIGHT);

            bookFlightPs.setString(1, Booking_ID);
            bookFlightPs.setString(2, Username);
            bookFlightPs.setString(3, Flight_ID);
            bookFlightPs.setString(4, Seat_Number);

            bookFlightPs.executeUpdate();
            System.out.println("Flight Booked.");
            connection.close();
        }
    }
    @Override
    public void updateFlight(String DepartureTime, String ArrivalTime, String Terminal, String FlightID)
            throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement updateFlightPs = connection.prepareStatement(Queries.CHANGEFLIGHT);

            updateFlightPs.setString(1, DepartureTime);
            updateFlightPs.setString(2, ArrivalTime);
            updateFlightPs.setString(3, Terminal);
            updateFlightPs.setString(4, FlightID);

            updateFlightPs.executeUpdate();
            System.out.println("Flight Updated.");
            connection.close();
        }
    }
    @Override
    public void deleteFlight(String FlightID) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement deleteFlightPs = connection.prepareStatement(Queries.DELETEFLIGHT);

            deleteFlightPs.setString(1, FlightID);

            deleteFlightPs.executeUpdate();
            System.out.println("Flight Deleted.");
            connection.close();
        }
    }

}
