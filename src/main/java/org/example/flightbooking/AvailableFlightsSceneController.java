package org.example.flightbooking;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

public class AvailableFlightsSceneController {

    private Parent openSceneRoot;
    private Parent AccountSettingsRoot;
    private Scene AccountSettingsScene;
    private Scene openScene;
    private Stage window;

    @FXML
    private VBox hiddenPane;
    @FXML
    private Button menuButton;
    @FXML
    private Button meButton;
    @FXML
    private Button accountSettingsButton;
    @FXML
    private Button signOffButton;

    @FXML
    private void handleMenuButtonClick() {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(hiddenPane);
        transition.setDuration(Duration.seconds(0.3));

        if (hiddenPane.getLayoutX() < 0) {
            transition.setToX(250);
        } else {
            transition.setToX(-250);
        }

        transition.play();
    }

    @FXML
    private void handleMyFlightsButtonClick() {
        System.out.println("My Flights clicked");
    }

    @FXML
    private void handleAccountSettingsButtonClick(ActionEvent event) throws Exception {
        AccountSettingsRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AccountSettingsScene.fxml")));
        window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        AccountSettingsScene = new Scene(AccountSettingsRoot);
        window.setScene(AccountSettingsScene);
        window.show();
    }

    @FXML
    private void handleSignOffButtonClick(ActionEvent event) throws Exception {
        openSceneRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("openScene.fxml")));
        window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        openScene = new Scene(openSceneRoot);
        window.setScene(openScene);
        window.show();
    }
}
