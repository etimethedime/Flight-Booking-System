package org.example.flightbooking;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Objects;

public class ControllerBookFlightScene {

    @FXML
    private Text bookingInformation;

    private Parent availableFlightsRoot;
    private Scene availableFlightsScene;
    private Stage window;

    private final Flight selectedFlight = ControllerAvailableFlightsScene.selectedFlight;

    public void initialize() {
        StringBuilder flightInfo = new StringBuilder();
        flightInfo.append("Flight ID = ").append(selectedFlight.getFlightID()).append("\n");
        flightInfo.append("Flight Number = ").append(selectedFlight.getFlightNO()).append("\n");
        flightInfo.append("Departing From = ").append(selectedFlight.getDepartureCity()).append("\n");
        flightInfo.append("Flying To = ").append(selectedFlight.getArrivalCity()).append("\n");
        flightInfo.append("Takeoff = ").append(selectedFlight.getDepartureTime()).append("\n");
        flightInfo.append("Arrive = ").append(selectedFlight.getArrivalTime()).append("\n");
        flightInfo.append("Gate = ").append(selectedFlight.getTerminal()).append("\n");
        flightInfo.append("Seat Selection = ").append(selectedFlight.getSeat()).append("\n");
        bookingInformation.setText(flightInfo.toString());
    }

    @FXML
    private void handleBookButtonClick(ActionEvent event) throws Exception {
        System.out.println(
                ControllerLogInScene.c1.bookFlight(ControllerLogInScene.c1.getUser(),
                        selectedFlight.getFlightID(), selectedFlight.getSeat()));
    }

    @FXML
    private void handleGoBack(ActionEvent event) throws Exception {
        availableFlightsRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AvailableFlightsScene.fxml")));
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        availableFlightsScene = new Scene(availableFlightsRoot);
        window.setScene(availableFlightsScene);
        window.show();
    }
}
