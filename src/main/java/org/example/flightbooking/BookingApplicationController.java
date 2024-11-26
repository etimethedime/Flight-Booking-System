package org.example.flightbooking;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BookingApplicationController {

    // Buttons
    @FXML
    private Button logInButton;
    @FXML
    private Button registerButton;
    @FXML
    private Button leaveRegister;
    @FXML
    private Button leaveLogIn;

    // Scenes
    @FXML
    private Scene openScene;
    @FXML
    private Scene logInScene;
    @FXML
    private Scene registerScene;


    //Stage
    private Stage window;

    public void setWindow(Stage window) {
        this.window = window;
    }

    //Actions

    @FXML
    private void handleRegisterButtonClick() {

        window.setScene(registerScene);
    }

    @FXML
    private void handleLogInButtonClick() {

        window.setScene(logInScene);
    }

    @FXML
    private void handleLeaveRegisterClick() {

        window.setScene(openScene);
    }

    @FXML
    private void handleLeaveLogInClick() {

        window.setScene(openScene);
    }

}
