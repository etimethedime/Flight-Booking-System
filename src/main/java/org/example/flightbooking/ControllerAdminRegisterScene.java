package org.example.flightbooking;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class ControllerAdminRegisterScene {

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;

    @FXML
    private TextField EmployeeID;

    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField confirmPassword;


    public Stage window;
    public Scene logInScene;
    public Parent logInRoot;

    @FXML
    public void Register() throws SQLException {
        String EmployeeID = this.EmployeeID.getText();
        String firstName = this.firstName.getText();
        String lastName = this.lastName.getText();
        String username = this.username.getText();
        String password = this.password.getText();
        String confirmPassword = this.confirmPassword.getText();


        Admin admin = new Admin();
        System.out.println(admin.adminRegister(EmployeeID, username, password, confirmPassword, firstName, lastName));
    }

    public void handleLogInButtonClick(ActionEvent event) throws IOException {
        logInRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("logInScene.fxml")));
        window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        logInScene = new Scene(logInRoot);
        window.setScene(logInScene);
        window.show();
    }

    public void handleCustomerRegisterButtonClick (ActionEvent event) throws IOException {
        logInRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("registerScene.fxml")));
        window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        logInScene= new Scene(logInRoot);
        window.setScene(logInScene);
        window.show();
    }

}
