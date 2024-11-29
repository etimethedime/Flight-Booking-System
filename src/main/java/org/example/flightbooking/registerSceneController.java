package org.example.flightbooking;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.Objects;

public class registerSceneController {
    public Stage window;
    public Scene openScene;
    public Parent openSceneRoot;
    public Scene nextScene;
    public Parent nextRoot;

    public void handleLeaveRegister (ActionEvent event) throws IOException {
        openSceneRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("openScene.fxml")));
        window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        openScene = new Scene(openSceneRoot);
        window.setScene(openScene);
        window.show();
    }

}
