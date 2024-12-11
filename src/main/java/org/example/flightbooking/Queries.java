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


                //For ADMIN
    public static final String ADMINLOGIN = "SELECT Username, Password FROM Admin WHERE Username = ? AND Password = ?"; // SELECT
    public static final String ADMINREGISTER = "INSERT INTO Admin (Employee_ID, Username, Password, First_Name, Last_Name) "
                        + "VALUES(?, ?, ?, ?, ?); "; //INSERT TO REGISTER ADMIN
    public static final String ADMININSERTFLIGHT = "INSERT INTO FLIGHTS (Flight_ID, Flight_Number, Departure_City, Arrival_City, Departure_Time, Arrival_Time, Terminal) " +
            "VALUES(?, ?, ?, ?, ?, ?, ?)";

    public static final String ADMINCHANGEFLIGHT = "UPDATE FLIGHTS SET Flight_Number = ?, Departure_City = ?, Arrival_City = ?, Departure_Time = ?, Arrival_Time = ?, Terminal = ? WHERE Flight_ID = ?";
    ; // UPDATE
    public static final String ADMINDELETEFLIGHT = "DELETE FROM FLIGHTS WHERE Flight_ID = ?"; //DELETE

                // For Flights
    public static final String GETFLIGHTS = "SELECT * FROM FLIGHTS"; // SELECT
    public static final String USERFLIGHTS = "SELECT * FROM FLIGHTS_BOOKED WHERE Username = ?";
    public static final String BOOKFLIGHT = "INSERT INTO FLIGHTS_BOOKED (Username, Flight_ID, Seat_Number) " + "VALUES(?, ?, ?)"; // INSERT
    public static final String CUSTDELETEFLIGHT = "DELETE FROM FLIGHTS_BOOKED WHERE Flight_ID = ?"; //DELETE

}
