package org.example.flightbooking;

import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class ControllerAvailableFlightsScene {

    public Parent openSceneRoot;
    public Parent MyFlightsRoot;
    public Parent AccountSettingsRoot;
    public Scene openScene;
    public Scene MyFlightScene;
    public Scene AccountSettingsScene;
    public Stage window;


    @FXML
    private VBox hiddenPane;
    @FXML
    private Button menuButton;
    @FXML
    private Button meButton;
    @FXML
    private Button accountSettingsButton;
    @FXML
    private Button signOffButton;
    @FXML
    private TableView<Flight> tableView = new TableView<>();

    @FXML
    private TableColumn<Flight, String> FlightIDCol = new TableColumn<>();

    @FXML
    private TableColumn<Flight, String> FlightNumberCol = new TableColumn<>();
    @FXML
    private TableColumn<Flight, String> DepartureCityCol = new TableColumn<>();
    @FXML
    private TableColumn<Flight, String> ArrivalCityCol = new TableColumn<>();
    @FXML
    private TableColumn<Flight, String> DepartureTimeCol = new TableColumn<>();
    @FXML
    private TableColumn<Flight, String> ArrivalTimeCol = new TableColumn<>();
    @FXML
    private TableColumn<Flight, String> TerminalCol = new TableColumn<>();



    public void initialize() throws SQLException {
        initializeFlightViewTable();
    }
    @FXML
    private void handleMenuButtonClick() {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(hiddenPane);
        transition.setDuration(Duration.seconds(0.3));

        if (hiddenPane.getLayoutX() < 0) {
            transition.setToX(250);
        } else {
            transition.setToX(-250);
        }

        transition.play();
    }

    public void handleMyFlightsSceneClick(ActionEvent event)throws Exception{
        MyFlightsRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MyFlightsScene.fxml")));
        window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        MyFlightScene = new Scene(MyFlightsRoot);
        window.setScene(MyFlightScene);
        window.show();
    }

    public void handleAccountSettingsButtonClick(ActionEvent event) throws Exception {
        AccountSettingsRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AccountSettingScene.fxml")));
        window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        AccountSettingsScene = new Scene(AccountSettingsRoot);
        window.setScene(AccountSettingsScene);
        window.show();
    }

    @FXML
    private void handleSignOffButtonClick(ActionEvent event) throws Exception {
        openSceneRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("openScene.fxml")));
        window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        openScene = new Scene(openSceneRoot);
        window.setScene(openScene);
        window.show();
    }

    public   void initializeFlightViewTable() throws SQLException {
        ObservableList<Flight> list = ControllerLogInScene.c1.getAllFlights();
        FlightIDCol.setCellValueFactory(new PropertyValueFactory<>("FlightID"));
        FlightNumberCol.setCellValueFactory(new PropertyValueFactory<>("FlightNO"));
        DepartureCityCol.setCellValueFactory(new PropertyValueFactory<>("DepartureCity"));
        ArrivalCityCol.setCellValueFactory(new PropertyValueFactory<>("ArrivalCity"));
        DepartureTimeCol.setCellValueFactory(new PropertyValueFactory<>("DepartureTime"));
        ArrivalTimeCol.setCellValueFactory(new PropertyValueFactory<>("ArrivalTime"));
        TerminalCol.setCellValueFactory(new PropertyValueFactory<>("Terminal"));

        tableView.setItems(list);
        tableView.refresh();
        System.out.println(list.toString());
    }



}
