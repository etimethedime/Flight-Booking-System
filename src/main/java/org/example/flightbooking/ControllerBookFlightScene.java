package org.example.flightbooking;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class ControllerBookFlightScene {
    public Parent AvailableFlightsRoot;
    public Scene AvailableFlightsScene;
    public Stage window;
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
        flightinfo.append("Seat Selection = " + selectedFlight.getSeat() + "\n");
        bookingInformation.setText(flightinfo.toString());
    }
    @FXML
    public void handleGoBack(ActionEvent event)throws Exception {
        AvailableFlightsRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("openScene.fxml")));
        window = (Stage)((Node)event.getSource()).getScene().getWindow();
        AvailableFlightsScene = new Scene(AvailableFlightsRoot);
        window.setScene(AvailableFlightsScene);
        window.show();
    }

    @FXML
    private void handleBookButtonClick()throws Exception{
        ControllerLogInScene.c1.bookFlight(ControllerLogInScene.c1.getUser(), selectedFlight.getFlightID(),selectedFlight.getSeat());
    }



}