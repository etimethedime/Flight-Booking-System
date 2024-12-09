package org.example.flightbooking;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;


public class ControllerAccountSettingsScene {

    public Parent AvailableFLightsRoot;
    public Parent AccountUpdateSceneRoot;
    public Scene AccountUpdateScene;
    public Scene AvailableFlightsScene;
    public Stage window;

    public void accountUpdateInformationSceneClick(ActionEvent event) throws Exception{
        AccountUpdateSceneRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AccountUpdateScene.fxml")));
        window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        AccountUpdateScene = new Scene(AccountUpdateSceneRoot);
        window.setScene(AccountUpdateScene);
        window.show();
    }

    public void handleGoBackToMainPage(ActionEvent event) throws Exception {
        AvailableFLightsRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AvaialableFlightsScene.fxml")));
        window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        AvailableFlightsScene = new Scene(AvailableFLightsRoot);
        window.setScene(AvailableFlightsScene);
        window.show();
    }


}
