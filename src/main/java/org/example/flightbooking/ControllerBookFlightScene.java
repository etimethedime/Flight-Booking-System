package org.example.flightbooking;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class ControllerBookFlightScene {

    public Flight selectedFlight = ControllerAvailableFlightsScene.selectedFlight;
    @FXML
    public Text bookingInformation= new Text();
    public StringBuilder flightinfo = new StringBuilder();
    public void initialize(){
        flightinfo.append("Flight ID = " + selectedFlight.getFlightID() + "\n");
        flightinfo.append("Flight Number = " + selectedFlight.getFlightNO() + "\n");
        flightinfo.append("Departing From = " + selectedFlight.getDepartureCity() + "\n");
        flightinfo.append("Flying To = " + selectedFlight.getArrivalCity() + "\n");
        flightinfo.append("Takeoff = " + selectedFlight.getDepartureTime() + "\n");
        flightinfo.append("Arrive = " + selectedFlight.getArrivalTime() + "\n");
        flightinfo.append("Gate = " + selectedFlight.getTerminal() + "\n");
        bookingInformation.setText(flightinfo.toString());
    }
    @FXML
    public void handleBook(ActionEvent event)throws SQLException{
        ControllerLogInScene.c1.bookFlight(ControllerLogInScene.c1.getUser(), selectedFlight.getFlightID(),"1");

        /*
        BookFlightVerrificationRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AvailableFlightScene.fxml")));
        window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        BookFlightVerrificationScene = new Scene(BookFlightVerrificationRoot);
        window.setScene(BookFlightVerrificationScene);
        window.show();

         */
    }
}

