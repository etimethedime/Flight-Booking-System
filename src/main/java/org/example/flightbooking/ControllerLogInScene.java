package org.example.flightbooking;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class ControllerLogInScene {
    private int UserCase;

    public ComboBox<String> modeSwitch;
    public Stage window;
    public Scene openScene;
    public Scene AvailableFlightsScene;
    public Parent openSceneRoot;
    public Parent AvailableFlightsRoot;

    @FXML
    public TextField username;

    @FXML
    public TextField password;

    @FXML
    public Text errorMessage;

    public static Customer c1 = new Customer();
    public static Admin a1 = new Admin();


    @FXML
    private int selectMode(){
        if(modeSwitch.getSelectionModel().getSelectedItem().equals("Passenger")){
            UserCase = 1;
            return UserCase;
        }
        else if(modeSwitch.getSelectionModel().getSelectedItem().equals("Admin")) {
            UserCase = 2;
            return UserCase;
        }
        else {
            return -1;
        }
    }
    @FXML
    private int Admin() {
        UserCase = 2;
        return UserCase;
    }
    @FXML
    private void handleSuccessfulLogin(ActionEvent event) throws IOException, SQLException {
        errorMessage.setText("");
        switch(selectMode()) {
            case 1:
                if (c1.logIn(username.getText(), password.getText())) {
                    c1.setUser(username.getText());
                    AvailableFlightsRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AvailableFlightsScene.fxml")));
                    window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    AvailableFlightsScene = new Scene(AvailableFlightsRoot);
                    window.setScene(AvailableFlightsScene);
                    window.show();
                } else {
                    errorMessage.setText("Username or password incorrect");
                }
            case 2:
                if (a1.adminLogIn(username.getText(), password.getText())) {
                    a1.setUser(username.getText());
                    AvailableFlightsRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AvailableFlightsScene.fxml")));
                    window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    AvailableFlightsScene = new Scene(AvailableFlightsRoot);
                    window.setScene(AvailableFlightsScene);
                    window.show();
                } else {
                    errorMessage.setText("Username or password incorrect");
                }
            }
        }


    public void handleLeaveLogIn(ActionEvent event) throws IOException {
        openSceneRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("openScene.fxml")));
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        openScene = new Scene(openSceneRoot);
        window.setScene(openScene);
        window.show();
    }
}
