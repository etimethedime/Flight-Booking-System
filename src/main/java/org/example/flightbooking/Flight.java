package org.example.flightbooking;

public class Flight {

    String FlightID;
    String FlightNO;
    String DepartureCity;
    String ArrivalCity;
    String DepartureTime;
    String ArrivalTime;
    String Terminal;

    public Flight(String FlightId, String FlightNumber, String DepartureCity, String ArrivalCity,String DepartureTime, String ArrivalTime, String Terminal){
        this.FlightID = new String(FlightId);
        this.FlightNO = new String(FlightNumber);
        this.DepartureCity = new String(DepartureCity);
        this.ArrivalCity = new String(ArrivalCity);
        this.DepartureTime = new String(DepartureTime);
        this.ArrivalTime = new String(ArrivalTime);
        this.Terminal = new String(Terminal);
    }

    public String getFlightID() {
        return FlightID;
    }

    public String getFlightNO() {
        return FlightNO;
    }

    public String getDepartureCity() {
        return DepartureCity;
    }

    public String getArrivalTime() {
        return ArrivalTime;
    }

    public String getArrivalCity() {
        return ArrivalCity;
    }

    public String getDepartureTime() {
        return DepartureTime;
    }

    public String getTerminal() {
        return Terminal;
    }
}
