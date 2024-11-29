package org.example.flightbooking;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
public class BookingApplication extends Application{

    //Scenes
    Scene openScene, logInScene, registerScene;


    @Override
    public void start(Stage window) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/flightbooking/openScene.fxml"));
        Parent openSceneRoot = loader.load();
        openScene = new Scene(openSceneRoot);
        //The First Scene
        window.setTitle("Flight Booker");
        window.setScene(openScene);
        window.show();

        FXMLLoader logInLoader = new FXMLLoader(getClass().getResource("/org/example/flightbooking/logInScene.fxml"));
        Parent logInSceneRoot = logInLoader.load();
        logInScene = new Scene(logInSceneRoot);

        FXMLLoader registerLoader = new FXMLLoader(getClass().getResource("/org/example/flightbooking/registerScene.fxml"));
        Parent registerSceneRoot = registerLoader.load();
        registerScene = new Scene(registerSceneRoot);



    }


    public static void main(String[] args) {
        launch(args);
    }


}

