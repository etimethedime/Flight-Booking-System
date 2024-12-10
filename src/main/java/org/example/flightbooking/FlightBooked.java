package org.example.flightbooking;

public class FlightBooked {

    String BookingID;
    String Username;
    String FlightID;
    String DepartureCity;
    String ArrivalCity;
    String DepartureTime;
    String ArrivalTime;
    String Seat;

    public FlightBooked(String BookingID, String FlightId, String DepartureCity,String ArrivalCity, String DepartureTime, String ArrivalTime, String Seat){
        this.BookingID = new String(BookingID);
        this.FlightID = new String(FlightId);
        this.DepartureCity = new String(DepartureCity);
        this.ArrivalCity = new String(ArrivalCity);
        this.DepartureTime = new String(DepartureTime);
        this.ArrivalTime = new String(ArrivalTime);
        this.Seat = new String(Seat);
    }

    public String getBookingID() {
        return BookingID;
    }

    public String getUsername() {
        return Username;
    }

    public String getFlightID() {
        return FlightID;
    }

    public String getDepartureCity() {
        return DepartureCity;
    }

    public String getArrivalCity() {
        return ArrivalCity;
    }

    public String getDepartureTime() {
        return DepartureTime;
    }

    public String getArrivalTime() {
        return ArrivalTime;
    }

    public String getSeat() {
        return Seat;
    }
}
