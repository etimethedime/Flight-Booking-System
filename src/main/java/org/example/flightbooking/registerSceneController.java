package org.example.flightbooking;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class registerSceneController {
    private TextField firstName = new TextField();
    private TextField lastName = new TextField();
    private TextField street = new TextField();
    private TextField zipCode = new TextField();
    private TextField state =  new TextField();
    private TextField username =  new TextField();
    private TextField password =  new TextField();
    private TextField email =  new TextField();
    private TextField SSN = new TextField();
    private TextField  secQuestion =  new TextField();
    private TextField secAnswer = new TextField();
    private TextField secPIN =  new TextField();
    public Stage window;
    public Scene openScene;
    public Parent openSceneRoot;
    public Scene nextScene;
    public Parent nextRoot;
    public Scene logInScene;
    public Parent logInRoot;


    public void Register(){
        String firstName = this.firstName.getText();
        String lastName = this.lastName.getText();
        String street = this.street.getText();
        String zipCode = this.zipCode.getText();
        String state = this.state.getText();
        String username = this.username.getText();
        String password = this.password.getText();
        String email = this.email.getText();
        String SSN = this.SSN.getText();
        String secQuestion = this.secQuestion.getText();
        String secAnswer = this.secAnswer.getText();
        String secPIN = this.secPIN.getText();

        Customer customer = new Customer(firstName,lastName,street,zipCode,state,username,password,email,SSN,secQuestion, secAnswer, secPIN);
        //add method to add customer object to database
    }
    public void handleRegister (ActionEvent event) throws IOException{
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
