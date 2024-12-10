package org.example.flightbooking;

public class Queries {

                // All for users
    public static final String REGISTER = "INSERT INTO User (Username, Password, FirstName, LastName, Email, Address, SSN, SecurityQuestion, SecurityAnswer)"  +
                        "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?); ";// INSERT
    public static final String LOGIN = "SELECT Username, Password FROM User WHERE Username = ? AND Password = ?"; // SELECT
    public static final String FORGOTPASSWORD = "SELECT Password AND SecurityQuestion AND SecurityAnswer FROM User WHERE Username = ?"; //SELECT
    public static final String CHANGEPASSWORD = "UPDATE User SET Password = ? WHERE Username =  ?"; // UPDATE

    public static final String SELECTSECQUESTION = "SELECT SecurityQuestion FROM Users WHERE Username = ?";

    public static final String SELECTPASSWORD = "SELECT Password FROM Users WHERE Username = ? AND SecurityAnswer = ?";



                // For Flights
    public static final String GETFLIGHTS = "SELECT * FROM FLIGHTS"; // SELECT
    public static final String USERFLIGHTS = "SELECT * FROM FLIGHTS_BOOKED WHERE Username = ?";
    public static final String BOOKFLIGHT = "INSERT INTO FLIGHTS_BOOKED (Username, Flight_ID, Seat_Number, DepartureCity, ArrivalCity, DepartureTime, ArrivalTime) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?)";
    // INSERT
    public static final String CHANGEFLIGHT = "UPDATE FLIGHTS SET Departure_Time = ?, Arrival_Time = ?, Terminal = ? WHERE Flight_ID = ?"; // UPDATE
    public static final String DELETEFLIGHT = "DELETE FROM FLIGHTS WHERE Flight_ID = ?"; //DELETE

}
