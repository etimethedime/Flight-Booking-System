package org.example.flightbooking;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BookingApplication extends Application{
    //Buttons
    @FXML
    private Button registerButton;
    @FXML
    private Button logInButton;
    @FXML
    private Button leaveRegister;
    @FXML
    private Button leaveLogIn;

    //Stages
    Stage window;

    //Scenes
    Scene openScene, logInScene, registerScene;

    @Override
    public void start(Stage window) throws Exception {

        //The Stage name
        window.setTitle("Flight Booker");


        //Labels are static non-interactive text!
        Label l1 = new Label("Welcome to CME Bookings!");

        //log in
        Label l3 = new Label("Welcome Back!");
        //register
        Label l2 = new Label("New Customer!");

                //Giving Buttons a name and an Action

        //giving them a name
        registerButton = new Button();
        registerButton.setText("Register");
        //linking button to an action
        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                //performing action when button is clicked
                if(actionEvent.getSource() == registerButton){
                    window.setScene(registerScene);
                }

            }
        });

        leaveRegister = new Button();
        leaveRegister.setText("Back");
        leaveRegister.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(actionEvent.getSource() == leaveRegister){
                    window.setScene(openScene);
                }
            }
        });

        //simple version using Lambda Expression version (USE THIS TECHNIQUE)
        logInButton = new Button("Log In"); // you can set text in the constructor parameter
        logInButton.setOnAction(e -> window.setScene(logInScene));//you can set action with (e -> action)

        leaveLogIn = new Button("Back");
        leaveLogIn.setOnAction(e -> window.setScene(openScene));


                                                                                //Layouts are a way to organize the app


                // Layout 1 = VBOX - sets children in a vertical stack

        //the open scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/flightbooking/openScene.fxml"));
        Parent root = loader.load();
        openScene = new Scene(root, 400, 400);


        //Layout 2 = StackPane - stacks children on in front (or on top) of each other

        //the register scene
        StackPane stackRegister = new StackPane();
        stackRegister.getChildren().addAll(l2, leaveRegister);
        registerScene = new Scene(stackRegister,400, 400);

        //the log in scene
        StackPane stackLogIn = new StackPane();
        stackLogIn.getChildren().addAll(l3, leaveLogIn);
        logInScene = new Scene(stackLogIn,400, 400);

                //finally show your app
        window.setScene(openScene);
        window.setTitle("CME Bookings");
        window.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
