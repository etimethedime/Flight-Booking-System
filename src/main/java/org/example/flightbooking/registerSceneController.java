package org.example.flightbooking;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class registerSceneController {

    private TextField query = new TextField();
    private TextField firstName = new TextField();
    private TextField lastName = new TextField();
    private TextField address = new TextField();

    private TextField username =  new TextField();
    private TextField password =  new TextField();
    private TextField email =  new TextField();
    private TextField SSN = new TextField();
    private TextField  secQuestion =  new TextField();
    private TextField secAnswer = new TextField();

    public Stage window;
    public Scene openScene;
    public Parent openSceneRoot;
    public Scene nextScene;
    public Parent nextRoot;
    public Scene logInScene;
    public Parent logInRoot;


    public void Register() throws SQLException {
        String s = query.getText();
        String firstName = this.firstName.getText();
        String lastName = this.lastName.getText();
        String username = this.username.getText();
        String password = this.password.getText();
        String address = this.address.getText();
        String email = this.email.getText();
        String SSN = this.SSN.getText();
        String secQuestion = this.secQuestion.getText();
        String secAnswer = this.secAnswer.getText();




// merging


        //Customer customer = new Customer();
        //customer.register(username,password,firstName,lastName,email,address,SSN,secQuestion,secAnswer);

        //customer class should have method to add newly registered user into database
    }
    public void handleRegister (ActionEvent event) throws IOException, SQLException {
        Register();
        System.out.println("Account created!");
    }
    public void handleLeaveRegister (ActionEvent event) throws IOException {
        openSceneRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("openScene.fxml")));
        window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        openScene = new Scene(openSceneRoot);
        window.setScene(openScene);
        window.show();
    }

    public void handleLogInButtonClick(ActionEvent event) throws IOException {
        logInRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("logInScene.fxml")));
        window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        logInScene = new Scene(logInRoot);
        window.setScene(logInScene);
        window.show();
    }

}
