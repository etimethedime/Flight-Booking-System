package org.example.flightbooking;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import javafx.scene.control.TextField;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class ControllerRegisterScene {


    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField address;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField email;
    @FXML
    private TextField SSN;
    @FXML
    private ComboBox secQuestion;
    @FXML
    private TextField secAnswer;

    public Stage window;
    public Scene logInScene;
    public Parent logInRoot;

    @FXML
    public void Register() throws SQLException {
        String firstName = this.firstName.getText();
        String lastName = this.lastName.getText();
        String username = this.username.getText();
        String password = this.password.getText();
        String address = this.address.getText();
        String email = this.email.getText();
        String SSN = this.SSN.getText();
        String secQuestion = this.secQuestion.getSelectionModel().getSelectedItem().toString();
        String secAnswer = this.secAnswer.getText();


        Customer customer = new Customer();
        System.out.println(customer.register(username, password, firstName, lastName, email, address, SSN, secQuestion, secAnswer));
    }

    public void handleLogInButtonClick(ActionEvent event) throws IOException {
        logInRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("logInScene.fxml")));
        window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        logInScene = new Scene(logInRoot);
        window.setScene(logInScene);
        window.show();
    }

}