package org.example.flightbooking;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

import static org.example.flightbooking.ExceptionHandler.validateRegistrationInput;

public class Customer extends Account implements CustomerDBQ {

    private String user;

    public Customer() {

    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://cis32702024.mysql.database.azure.com:3306/flightbooker",
                "ezradegafe1", "GSUproject123");
        System.out.println("Database connected");
        return connection;
    }

    @Override
    public String register(String Username, String Password, String FirstName, String LastName, String Email,
                           String Address, String SSN, String SecurityQuestion, String SecurityAnswer) throws SQLException {
        // Validate input fields
        String validationError = validateRegistrationInput(Username, Password, FirstName, LastName, Email, Address, SSN, SecurityQuestion, SecurityAnswer);
        if (validationError != null) {
            return "Registration failed: " + validationError;
        }

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
            setUser(Username);
            return "User registered successfully.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Registration failed: Database error.";
        }
    }

    @Override
    public boolean logIn(String InputUsername, String InputPassword) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement loginPs = connection.prepareStatement(Queries.LOGIN);

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

    public static String getSecurityQuestion(String username) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(Queries.SELECTSECQUESTION)) {
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("SecurityQuestion");
            } else {
                return "Username not found.";
            }
        }
    }
    //merging

    public static String getPassword(String username, String securityAnswer) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(Queries.SELECTPASSWORD)) {
            ps.setString(1, username);
            ps.setString(2, securityAnswer);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("Password");
            } else {
                return "Invalid username or incorrect security answer.";
            }
        }
    }


    /*
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
        Objec.equalsto( )
     */
    @Override
    public String bookFlight(String Username, String Flight_ID, String Seat_Number,
                             String DepartureCity, String ArrivalCity,
                             String DepartureTime, String ArrivalTime)
            throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement bookFlightPs = connection.prepareStatement(Queries.BOOKFLIGHT);

            bookFlightPs.setString(1, Username);
            bookFlightPs.setString(2, Flight_ID);
            bookFlightPs.setString(3, Seat_Number);
            bookFlightPs.setString(4, DepartureCity);
            bookFlightPs.setString(5, ArrivalCity);
            bookFlightPs.setString(6, DepartureTime);
            bookFlightPs.setString(7, ArrivalTime);

            bookFlightPs.executeUpdate();

            return "Flight Booked";
        }
    }




    /*
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

      */

    public String deleteFlight(String FlightID) throws SQLException {
        try (Connection connection = getConnection()) {
            // Prepare SQL query for deleting a flight based on the FlightID
            PreparedStatement deleteFlightPs = connection.prepareStatement(Queries.CUSTDELETEFLIGHT);

            // Set the FlightID parameter in the query
            deleteFlightPs.setString(1, FlightID);

            // Execute the deletion query
            int rowsAffected = deleteFlightPs.executeUpdate();

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
    public ObservableList<FlightBooked> getUserFlights() throws SQLException {
        ObservableList<FlightBooked> flightBookedList = FXCollections.observableArrayList();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Queries.USERFLIGHTS)) {

            // Set the parameter for the query
            preparedStatement.setString(1, ControllerLogInScene.c1.getUser());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String BookingID = resultSet.getString("BookingID");
                    String FlightID = resultSet.getString("Flight_ID");
                    String DepartureCity = resultSet.getString("DepartureCity");
                    String ArrivalCity = resultSet.getString("ArrivalCity");
                    String DepartureTime = resultSet.getString("DepartureTime");
                    String ArrivalTime = resultSet.getString("ArrivalTime");
                    String Seat = resultSet.getString("Seat_Number");

                    flightBookedList.add(new FlightBooked(BookingID, FlightID, DepartureCity, ArrivalCity, DepartureTime, ArrivalTime, Seat));
                }
            }

            if (flightBookedList.isEmpty()) {
                return null;
            }
        }
        return flightBookedList;
    }



}
