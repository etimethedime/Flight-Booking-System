package org.example.flightbooking;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;


public class AccountSettingsSceneController {

    public Parent AvailableFLightsRoot;
    public Scene AvailableFlightsScene;
    public Stage window;

    public void handleChangePassword(ActionEvent event) {
    }

    public void handleUpdateEmail(ActionEvent event) {
    }

    public void handleUpdateInformation(ActionEvent event) {
    }

    public void handleGoBackToMainPage(ActionEvent event) throws Exception {
        AvailableFLightsRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AvaialableFlightsScene.fxml")));
        window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        AvailableFlightsScene = new Scene(AvailableFLightsRoot);
        window.setScene(AvailableFlightsScene);
        window.show();
    }
}
