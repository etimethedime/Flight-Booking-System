package org.example.flightbooking;

public class Queries {

                // All for users
    public static final String REGISTER = "INSERT INTO User (Username, Password, FirstName, LastName, Email, PhoneNumber, Street, Zipcode, State, City, SSN, SecurityQuestion, SecurityAnswer)"  +
                        "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";// INSERT
    public static final String LOGIN = ""; // SELECT
    public static final String FORGOTPASSWORD = ""; //SELECT
    public static final String CHANGEPASSWORD = ""; // UPDATE



                // For Flights
    public static final String GETFLIGHT = ""; // SELECT
    public static final String BOOKFLIGHT = ""; // INSERT
    public static final String CHANGEFLIGHT = ""; // UPDATE
    public static final String DELETEFLIGHT = ""; //DELETE




}
