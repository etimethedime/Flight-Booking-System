package org.example.flightbooking;

public class Queries {

                // All for users
    public static final String REGISTER = "INSERT INTO User (Username, Password, FirstName, LastName, Email, PhoneNumber, Street, Zipcode, State, City, SSN, SecurityQuestion, SecurityAnswer)"  +
                        "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";// INSERT
    public static final String LOGIN = "SELECT * FROM User WHERE Username = ? AND Password = ?"; // SELECT
    public static final String FORGOTPASSWORD = "SELECT Password FROM User WHERE Username = ? AND SecurityQuestion = ? AND SecurityAnswer = ?"; //SELECT
    public static final String CHANGEPASSWORD = "UPDATE User SET Password = ? WHERE Username =  ?"; // UPDATE



                // For Flights
    public static final String GETFLIGHT = ""; // SELECT
    public static final String BOOKFLIGHT = ""; // INSERT
    public static final String CHANGEFLIGHT = ""; // UPDATE
    public static final String DELETEFLIGHT = ""; //DELETE




}
