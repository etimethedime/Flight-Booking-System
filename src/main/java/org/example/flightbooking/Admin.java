package org.example.flightbooking;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;


import static org.example.flightbooking.ExceptionHandler.adminValidateRegistrationInput;
import static org.example.flightbooking.ExceptionHandler.validateRegistrationInput;

public class Admin extends Account implements AdminDBQ, CustomerDBQ{
    private String user;
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
                "jdbc:mysql://cis32702024.mysql.database.azure.com:3306/flightbooker",
                "ezradegafe1", "GSUproject123");
        System.out.println("Database connected");
        return connection;
    }

    @Override
    public String adminRegister(String employeeId, String username, String password, String confirmPassword,
                                  String firstName, String lastName) throws SQLException {
        // Validate input fields
        String validationError = adminValidateRegistrationInput(employeeId, username, password, confirmPassword, firstName, lastName);
        if (validationError != null) {
            return "Registration failed: " + validationError;
        }

        try (Connection connection = getConnection()) {
            PreparedStatement registerPs = connection.prepareStatement(Queries.ADMINREGISTER);

            // Set parameters for the PreparedStatement
            registerPs.setString(1, employeeId);
            registerPs.setString(2, username);
            registerPs.setString(3, password);
            registerPs.setString(4, firstName);
            registerPs.setString(5, lastName);


            // Execute the statement
            registerPs.executeUpdate();
            setUser(username);
            return "User registered successfully.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Registration failed: Database error.";
        }
    }

    @Override
    public ObservableList<Flight> getAllFlights() throws SQLException {
        ObservableList<Flight> flightlist = FXCollections.observableArrayList();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Queries.GETFLIGHTS);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String FlightID = resultSet.getString("Flight_ID");
                String FlightNO = resultSet.getString("Flight_Number");
                String DepartureCity = resultSet.getString("Departure_City");
                String ArrivalCity = resultSet.getString("Arrival_City");
                String DepartureTime = resultSet.getString("Departure_Time");
                String ArrivalTime = resultSet.getString("Arrival_Time");
                String Terminal = resultSet.getString("Terminal");
                flightlist.add(new Flight(FlightID, FlightNO, DepartureCity, ArrivalCity, DepartureTime, ArrivalTime, Terminal));
            }


            if (flightlist.isEmpty()) {
                return null;
            }
        }
        return flightlist;
    }
    @Override
    public ObservableList<Flight> getSearchedFlights(String DepartureFrom, String ArrivalTo) throws SQLException {
        ObservableList<Flight> flightlist = FXCollections.observableArrayList();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Queries.GETAFLIGHT);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            preparedStatement.setString(1, DepartureFrom);
            preparedStatement.setString(2, ArrivalTo);


            while (resultSet.next()) {
                String FlightID = resultSet.getString("Flight_ID");
                String FlightNO = resultSet.getString("Flight_Number");
                String DepartureCity = resultSet.getString("Departure_City");
                String ArrivalCity = resultSet.getString("Arrival_City");
                String DepartureTime = resultSet.getString("Departure_Time");
                String ArrivalTime = resultSet.getString("Arrival_Time");
                String Terminal = resultSet.getString("Terminal");
                flightlist.add(new Flight(FlightID, FlightNO, DepartureCity, ArrivalCity, DepartureTime, ArrivalTime, Terminal));
            }


            if (flightlist.isEmpty()) {
                return null;
            }
        }
        return flightlist;
    }


    @Override
    public boolean adminLogIn(String InputUsername, String InputPassword) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement loginPs = connection.prepareStatement(Queries.ADMINLOGIN);

            // Set parameters for the query
            loginPs.setString(1, InputUsername);
            loginPs.setString(2, InputPassword);

            // Execute the query
            ResultSet loginRs = loginPs.executeQuery();

            // Validate the result
            if (loginRs.next()) {
                System.out.println("Login successful. Welcome, " + loginRs.getString("username") + "!");
                return true;
            } else {
                throw new IllegalArgumentException("Login failed: Invalid username or password.");

            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Database error occurred during login.");
        }
        return false;
    }

    @Override
    public String register(String Username, String Password, String FirstName, String LastName, String Email, String address, String SSN, String SecurityQuestion, String SecurityAnswer) throws SQLException {
        Customer c1 = new Customer();
        return c1.register(Username,Password,FirstName, LastName, Email, address, SSN, SecurityQuestion, SecurityAnswer);
    }

    @Override
    public boolean logIn(String Username, String Password) throws SQLException {
        Customer c1 = new Customer();
        return c1.logIn(Username, Password);
    }

    @Override
    public String retrievePassword(String Username, String SecurityQuestion, String SecurityAnswer) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement retrievePasswordPs = connection.prepareStatement(Queries.FORGOTPASSWORD);

            retrievePasswordPs.setString(1, Username);
            retrievePasswordPs.setString(2, SecurityQuestion);
            retrievePasswordPs.setString(3, SecurityAnswer);


            retrievePasswordPs.executeUpdate();
            System.out.println("Password Retrieved.");
            connection.close();
        }
        return "string";
    }

    @Override
    public String deleteFlight(String FlightID) throws SQLException {
        Customer c1 = new Customer();
        return c1.deleteFlight(FlightID);
    }

    @Override
    public String bookFlight(String Username, String Flight_ID, String Seat_Number, String DepartureCity, String ArrivalCity, String DepartureTime, String ArrivalTime) throws SQLException {
        return "";
    }

    @Override
    public ObservableList<FlightBooked> getUserFlights() throws SQLException {
        return null;
    }
    /*

    @Override
    public String bookFlight(String Username, String Flight_ID, String Seat_Number) throws SQLException {
        Customer c1 = new Customer();
        return c1.bookFlight(Username, Flight_ID, Seat_Number);
    }
    @Override
    public String getUserFlights(String Username) throws SQLException {
        Customer c1 = new Customer();
        return c1.getUserFlights(Username);
    }

     */

    @Override
    public String adminUpdateFlight(String FlightId, String FlightNumber, String DepartureCity, String ArrivalCity, String DepartureTime, String ArrivalTime, String Terminal)
            throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement adminUpdateFlightPs = connection.prepareStatement(Queries.ADMINCHANGEFLIGHT);

            adminUpdateFlightPs.setString(1, FlightNumber);
            adminUpdateFlightPs.setString(2, DepartureCity);
            adminUpdateFlightPs.setString(3, ArrivalCity);
            adminUpdateFlightPs.setString(4, DepartureTime);
            adminUpdateFlightPs.setString(5, ArrivalTime);
            adminUpdateFlightPs.setString(6, Terminal);
            adminUpdateFlightPs.setString(7, FlightId);

            int rowsAffected = adminUpdateFlightPs.executeUpdate();

            if (rowsAffected > 0) {
                return "Flight with ID " + FlightId + " has been updated successfully.";
            } else {
                return "Flight ID not found. No flight was updated.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "An error occurred while updating the flight.";
        }
    }
    @Override
    public String adminDeleteFlight(String FlightID) throws SQLException {
        try (Connection connection = getConnection()) {
            // Prepare SQL query for deleting a flight based on the FlightID
            PreparedStatement adminDeleteFlightPs = connection.prepareStatement(Queries.ADMINDELETEFLIGHT);

            // Set the FlightID parameter in the query
            adminDeleteFlightPs.setString(1, FlightID);

            // Execute the deletion query
            int rowsAffected = adminDeleteFlightPs.executeUpdate();

            // Check if the deletion was successful
            if (rowsAffected > 0) {
                return "Flight with ID " + FlightID + " has been deleted successfully.";
            } else {
                return "Flight ID not found. No flight was deleted.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "An error occurred while deleting the flight.";
        }
    }

    @Override
    public String adminInsertFlight(String Flight_ID, String Flight_Number, String Departure_City, String Arrival_City, String Departure_Time, String Arrival_Time, String Terminal) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement adminInsertFlightPs = connection.prepareStatement(Queries.ADMININSERTFLIGHT);

            adminInsertFlightPs.setString(1, Flight_ID);
            adminInsertFlightPs.setString(2, Flight_Number);
            adminInsertFlightPs.setString(3, Departure_City);
            adminInsertFlightPs.setString(4, Arrival_City);
            adminInsertFlightPs.setString(5, Departure_Time);
            adminInsertFlightPs.setString(6, Arrival_Time);
            adminInsertFlightPs.setString(7, Terminal);

            adminInsertFlightPs.executeUpdate();

            return "Flight Booked";

        }

    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
