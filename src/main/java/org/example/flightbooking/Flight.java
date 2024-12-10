package org.example.flightbooking;

public class Flight {
    String FlightID;
    String FlightNO;
    String DepartureCity;
    String ArrivalCity;
    String ArrivalTime;
    String Terminal;

    public Flight(String FlightId, String FlightNumber, String DepartureCity, String ArrivalCity,String DepartureTime, String ArrivalTime, String Terminal){
        this.FlightID = FlightId;
        this.FlightNO = FlightNumber;
        this.DepartureCity = DepartureCity;
        this.ArrivalCity = ArrivalCity;
        this.ArrivalTime = ArrivalTime;
        this.Terminal = Terminal;
    }
}
