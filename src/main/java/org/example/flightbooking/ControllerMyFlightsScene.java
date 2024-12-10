package org.example.flightbooking;

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
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.Objects;
public class ControllerMyFlightsScene {

    public Parent AvailableFLightsRoot;
    public Scene AvailableFlightsScene;
    public Stage window;

    // FXML table and columns

    @FXML
    private TableView<FlightBooked> MyFlightsView = new TableView<>();

    @FXML
    private TableColumn<Flight, String> BookingID;

    @FXML
    private TableColumn<Flight, String> FlightID;

    @FXML
    private TableColumn<Flight, String> DepartureCityCol;

    @FXML
    private TableColumn<Flight, String> ArrivalCityCol;

    @FXML
    private TableColumn<Flight, String> DepartureTimeCol;

    @FXML
    private TableColumn<Flight, String> ArrivalTimeCol;

    @FXML
    private TableColumn<Flight, String> SeatCol;
    
    public void initialize() throws SQLException {
        initializeMyFlightsViewTable();
    }


    public void initializeMyFlightsViewTable() throws SQLException {
        ObservableList<FlightBooked> list = ControllerLogInScene.c1.getUserFlights();

        BookingID.setCellValueFactory(new PropertyValueFactory<>("bookingID"));
        FlightID.setCellValueFactory(new PropertyValueFactory<>("flightID"));
        DepartureCityCol.setCellValueFactory(new PropertyValueFactory<>("departureCity"));
        ArrivalCityCol.setCellValueFactory(new PropertyValueFactory<>("arrivalCity"));
        DepartureTimeCol.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
        ArrivalTimeCol.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));
        SeatCol.setCellValueFactory(new PropertyValueFactory<>("seat"));


        MyFlightsView.setItems(list);
        MyFlightsView.refresh();
        System.out.println(list.toString());
    }


    public void GoBackToAvailableFlightsButtonClick(ActionEvent event) throws Exception {
        AvailableFLightsRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AvailableFlightsScene.fxml")));
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        AvailableFlightsScene = new Scene(AvailableFLightsRoot);
        window.setScene(AvailableFlightsScene);
        window.show();
    }

    public void handleDeleteFlightButton(ActionEvent event)throws Exception{

    }
}
