package org.example.flightbooking;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class openSceneController {

    public Button logInButton; // Log In Button
    public Button registerButton; // Register Button

    // Handle Log In Button Click
    public void handleLogInButtonClick(ActionEvent event) throws IOException {
        // Load the logInScene.fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/path/to/logInScene.fxml"));
        Scene logInScene = new Scene(loader.load());

        // Get the current stage (window)
        Stage stage = (Stage) logInButton.getScene().getWindow();
        stage.setScene(logInScene); // Set the new scene to Log In scene
        stage.show(); // Show the new scene
    }

    // Handle Register Button Click
    public void handleRegisterButtonClick(ActionEvent event) throws IOException {
        // Load the registerScene.fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/path/to/registerScene.fxml"));
        Scene registerScene = new Scene(loader.load());

        // Get the current stage (window)
        Stage stage = (Stage) registerButton.getScene().getWindow();
        stage.setScene(registerScene); // Set the new scene to Register scene
        stage.show(); // Show the new scene
    }
}
