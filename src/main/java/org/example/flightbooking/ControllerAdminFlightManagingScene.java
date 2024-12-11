package org.example.flightbooking;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class ControllerAdminFlightManagingScene {
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
    @FXML
    private VBox hiddenPane;


    @FXML
    private TextField flightIDTextField;
    @FXML
    private TextField flightNumberTextField;
    @FXML
    private TextField departureCityTextField;
    @FXML
    private TextField arrivalCityTextField;
    @FXML
    private TextField departureTimeTextField;
    @FXML
    private TextField arrivalTimeTextField;
    @FXML
    private TextField terminalTextField;

    Parent openSceneRoot;

    Scene openScene;

    Stage window;

    Parent availableRoot;

    Scene availableScene;


    @FXML
    private ComboBox<String> seatOptionComboBox;

    public static Flight selectedFlight;


    public void initialize() throws SQLException {
        initializeFlightViewTable();

        // Create the options for the ComboBox
        ObservableList<String> seatOptions = FXCollections.observableArrayList("Aisle", "Window", "Middle");

        // Set the items in the ComboBox
        //seatOptionComboBox.setItems(seatOptions);
    }


    public void initializeFlightViewTable() throws SQLException {
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

    @FXML
    private void handleDeleteFlightFromDatabase(ActionEvent event)throws SQLException{
        selectedFlight = adminGetSelectedFlight();
        ControllerLogInScene.a1.adminDeleteFlight(selectedFlight.FlightID);
    }
    @FXML
    private void handleUpdateFlightFromDatabase(ActionEvent event)throws SQLException{
        /*
        selectedFlight = adminGetSelectedFlight();
        flightIDTextField.setText(selectedFlight.FlightID);
        flightNumberTextField.setText(selectedFlight.FlightNO);
        departureCityTextField.setText(selectedFlight.DepartureCity);
        arrivalCityTextField.setText(selectedFlight.ArrivalCity);
        departureTimeTextField.setText(selectedFlight.DepartureTime);
        arrivalTimeTextField.setText(selectedFlight.ArrivalTime);
        terminalTextField.setText(selectedFlight.Terminal);

         */

        ControllerLogInScene.a1.adminUpdateFlight(flightNumberTextField.getText(), departureCityTextField.getText(), arrivalCityTextField.getText(), departureTimeTextField.getText(), arrivalTimeTextField.getText(), terminalTextField.getText(), flightIDTextField.getText());
    }
    @FXML
    private void handleInsertFlightFromDatabase(ActionEvent event)throws SQLException{
        selectedFlight = adminGetSelectedFlight();
        ControllerLogInScene.a1.adminInsertFlight(flightIDTextField.getText(), flightNumberTextField.getText(), departureCityTextField.getText(), arrivalCityTextField.getText(), departureTimeTextField.getText(), arrivalTimeTextField.getText(), terminalTextField.getText());
    }

    public Flight adminGetSelectedFlight(){
        return tableView.getSelectionModel().getSelectedItem();

    }
    @FXML
    private void handleMenuButtonClick() {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(hiddenPane);
        transition.setDuration(Duration.seconds(0.3));
        System.out.println("hello");

        if (hiddenPane.getLayoutX() < 0) {
            transition.setToX(250);
        } else {
            transition.setToX(-250);
        }

        transition.play();
    }

    @FXML
    private void handleSignOffButtonClick(ActionEvent event) throws Exception {
        openSceneRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("openScene.fxml")));
        window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        openScene = new Scene(openSceneRoot);
        window.setScene(openScene);
        window.show();
    }

    @FXML
    private void handleGoBackButtonClick(ActionEvent event) throws Exception {
        availableRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AvailableFlightsScene.fxml")));
        window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        availableScene = new Scene(availableRoot);
        window.setScene(availableScene);
        window.show();
    }
}