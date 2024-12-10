package org.example.flightbooking;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.sql.SQLException;
import java.util.Objects;

public class ControllerAvailableFlightsScene {

    public Parent openSceneRoot;
    public Parent MyFlightsRoot;
    public Parent BookFlightVerrificationRoot;
    public Parent ManageFlightRoot;
    public Scene openScene;
    public Scene MyFlightScene;
    public Scene BookFlightVerrificationScene;
    public Scene ManageFlightScene;
    public Stage window = new Stage();
    @FXML
    private VBox hiddenPane;
    public static Flight selectedFlight;

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
    private ComboBox<String> seatOptionComboBox;



    public void initialize() throws SQLException {
        initializeFlightViewTable();

        // Create the options for the ComboBox
        ObservableList<String> seatOptions = FXCollections.observableArrayList("Aisle", "Window", "Middle");

        // Set the items in the ComboBox
        seatOptionComboBox.setItems(seatOptions);
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
    public void handleMyFlightsSceneClick(ActionEvent event)throws Exception{
        MyFlightsRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MyFlightsScene.fxml")));
        window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        MyFlightScene = new Scene(MyFlightsRoot);
        window.setScene(MyFlightScene);
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
    @FXML
    private void handleAdminManageFlightScene(ActionEvent event) throws Exception {
        ManageFlightRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AdminFlightManagingScene.fxml")));
        window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ManageFlightScene = new Scene(ManageFlightRoot);
        window.setScene(ManageFlightScene);
        window.show();
    }
    @FXML
    private void handleBookFlightButton(ActionEvent event) throws Exception{

        selectedFlight = getSelectedFlight();
        if(seatOptionComboBox.getSelectionModel().getSelectedItem() != null){
           selectedFlight.setSeat(seatOptionComboBox.getSelectionModel().getSelectedItem());
        }
        BookFlightVerrificationRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("BookFlightVerificationScene.fxml")));
        window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        BookFlightVerrificationScene = new Scene(BookFlightVerrificationRoot);
        window.setScene(BookFlightVerrificationScene);
        window.show();

    }

    public Flight getSelectedFlight(){
        return tableView.getSelectionModel().getSelectedItem();

    }


}
