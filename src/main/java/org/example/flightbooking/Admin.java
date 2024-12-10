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
                "jdbc:mysql://cis32702024.mysql.database.azure.com:3306/cosmas",
                "ezradegafe1", "GSUproject123");
        System.out.println("Database connected");
        return connection;
    }

    @Override
    public String adminRegister(String employeeId, String username, String password,
                                  String firstName, String lastName) throws SQLException {
        // Validate input fields
        String validationError = adminValidateRegistrationInput(employeeId, username, password, firstName, lastName);
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
    public String bookFlight(String Username, String Flight_ID, String Seat_Number) throws SQLException {
        Customer c1 = new Customer();
        return c1.bookFlight(Username, Flight_ID, Seat_Number);
    }

    @Override
    public String getUserFlights(String Username) throws SQLException {
        Customer c1 = new Customer();
        return c1.getUserFlights(Username);
    }

    @Override
    public void adminUpdateFlight(String DepartureTime, String ArrivalTime, String Terminal, String FlightID)
            throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement adminUpdateFlightPs = connection.prepareStatement(Queries.ADMINCHANGEFLIGHT);

            adminUpdateFlightPs.setString(1, DepartureTime);
            adminUpdateFlightPs.setString(2, ArrivalTime);
            adminUpdateFlightPs.setString(3, Terminal);
            adminUpdateFlightPs.setString(4, FlightID);

            adminUpdateFlightPs.executeUpdate();
            System.out.println("Flight Updated.");
        }
    }
    @Override
    public void adminDeleteFlight(String FlightID) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement adminDeleteFlightPs = connection.prepareStatement(Queries.ADMINDELETEFLIGHT);

            adminDeleteFlightPs.setString(1, FlightID);

            adminDeleteFlightPs.executeUpdate();
            System.out.println("Flight Deleted.");
            connection.close();
        }
    }

    @Override
    public String adminInsertFlight(String Flight_ID, String Flight_Number, String Departure_City, String Arrival_City, String Departure_Time, String Arrival_Time, String Terminal) throws SQLException {
        return null;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
