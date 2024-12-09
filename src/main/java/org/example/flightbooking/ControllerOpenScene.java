package org.example.flightbooking;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class ControllerOpenScene {
    public Stage window;
    public Scene logInScene;
    public Parent logInRoot;
    public Scene registerScene;
    public Parent registerRoot;


    // Handle Log In Button Click
    public void handleLogInButtonClick(ActionEvent event) throws IOException {
        logInRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("logInScene.fxml")));
        window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        logInScene = new Scene(logInRoot);
        window.setScene(logInScene);
        window.show();

    }
    // Handle Register Button Click
    public void handleRegisterButtonClick(ActionEvent event) throws IOException {
        registerRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("registerScene.fxml")));
        window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        registerScene = new Scene(registerRoot);
        window.setScene(registerScene);
        window.show();
    }
}
