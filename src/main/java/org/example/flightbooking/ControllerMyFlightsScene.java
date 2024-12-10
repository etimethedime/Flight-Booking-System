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


    @FXML
    private void initialize() throws SQLException {
        initializeMyFlightsViewTable();
    }


    private void initializeMyFlightsViewTable() throws SQLException {
        ObservableList<FlightBooked> list = ControllerLogInScene.c1.getUserFlights();

        BookingID.setCellValueFactory(new PropertyValueFactory<>("Booking ID"));
        FlightID.setCellValueFactory(new PropertyValueFactory<>("Flight ID"));
        DepartureCityCol.setCellValueFactory(new PropertyValueFactory<>("Departure"));
        ArrivalCityCol.setCellValueFactory(new PropertyValueFactory<>("Arrival"));
        DepartureTimeCol.setCellValueFactory(new PropertyValueFactory<>("Departure Time"));
        ArrivalTimeCol.setCellValueFactory(new PropertyValueFactory<>("Arrival Time"));
        SeatCol.setCellValueFactory(new PropertyValueFactory<>("Seating Option"));

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
}
