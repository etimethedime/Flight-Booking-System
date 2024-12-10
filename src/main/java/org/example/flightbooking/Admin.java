package org.example.flightbooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import static org.example.flightbooking.ExceptionHandler.validateRegistrationInput;

public abstract class Admin extends Account implements AdminDBQ{

    /*
    public Admin (String firstName, String lastName, String street, String zipCode, String state, String username,
                     String password, String email, String SSN, String secQuestion, String secAnswer, String secPIN) {
        super(firstName, lastName, street, zipCode, state, username, password, email, SSN, secQuestion, secAnswer, secPIN);

    }

     */
    public Admin(){

    }

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://cis32702024.mysql.database.azure.com:3306/cosmas",
                "ezradegafe1", "GSUproject123");
        System.out.println("Database connected");
        return connection;
    }

    @Override
    public String register(String employeeId, String username, String password,
                                  String firstName, String lastName, String securityQuestion,
                           String securityAnswer, String SSN, String email,String address) throws SQLException {
        // Validate input fields
        String validationError = validateRegistrationInput(username,password,firstName,lastName,email,address,SSN,securityQuestion,securityAnswer);
        if (validationError != null) {
            return "Registration failed: " + validationError;
        }

        try (Connection connection = getConnection()) {
            PreparedStatement registerPs = connection.prepareStatement(Queries.REGISTER);

            // Set parameters for the PreparedStatement
            registerPs.setString(1, employeeId);
            registerPs.setString(2, username);
            registerPs.setString(3, password);
            registerPs.setString(4, firstName);
            registerPs.setString(5, lastName);


            // Execute the statement
            registerPs.executeUpdate();
            return "User registered successfully.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Registration failed: Database error.";
        }
    }

    @Override
    public void adminViewFlights(String Flight_ID) throws SQLException{
        try (Connection connection = getConnection()) {
            PreparedStatement viewFlightsPs = connection.prepareStatement(Queries.ADMINGETFLIGHT);

            viewFlightsPs.setString(1,Flight_ID);

            viewFlightsPs.executeUpdate();
            System.out.println("Here is Flights");
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
    public void adminBookFlight(String Booking_ID, String Username, String Flight_ID, String Seat_Number)
            throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement adminBookFlightPs = connection.prepareStatement(Queries.BOOKFLIGHT);

            adminBookFlightPs.setString(1, Booking_ID);
            adminBookFlightPs.setString(2, Username);
            adminBookFlightPs.setString(3, Flight_ID);
            adminBookFlightPs.setString(4, Seat_Number);

            adminBookFlightPs.executeUpdate();
            System.out.println("Flight Booked.");
            connection.close();
        }
    }
    @Override
    public void adminUpdateFlight(String DepartureTime, String ArrivalTime, String Terminal, String FlightID)
            throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement adminUpdateFlightPs = connection.prepareStatement(Queries.CHANGEFLIGHT);

            adminUpdateFlightPs.setString(1, DepartureTime);
            adminUpdateFlightPs.setString(2, ArrivalTime);
            adminUpdateFlightPs.setString(3, Terminal);
            adminUpdateFlightPs.setString(4, FlightID);

            adminUpdateFlightPs.executeUpdate();
            System.out.println("Flight Updated.");
            connection.close();
        }
    }
    @Override
    public void adminDeleteFlight(String FlightID) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement adminDeleteFlightPs = connection.prepareStatement(Queries.DELETEFLIGHT);

            adminDeleteFlightPs.setString(1, FlightID);

            adminDeleteFlightPs.executeUpdate();
            System.out.println("Flight Deleted.");
            connection.close();
        }
    }
}
