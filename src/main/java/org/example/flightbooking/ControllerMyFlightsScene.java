package org.example.flightbooking;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.text.TableView;
import java.sql.SQLException;
import java.util.Objects;

public class ControllerMyFlightsScene {


    public Parent AvailableFLightsRoot;
    public Scene AvailableFlightsScene;
    public Stage window;
    public TableView MyFlightsTable;

    public void getMyFlights() throws SQLException {
        ControllerLogInScene.c1.getUserFlights(ControllerLogInScene.c1.getUser());

    }

    public void GoBackToAvailableFlightsButtonClick(ActionEvent event)throws Exception{
        AvailableFLightsRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AvailableFlightsScene.fxml")));
        window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        AvailableFlightsScene = new Scene(AvailableFLightsRoot);
        window.setScene(AvailableFlightsScene);
        window.show();
    }
}
