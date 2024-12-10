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


    public void initialize() throws Exception{
        initializeFlightViewTable();
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

    }
    @FXML
    private void handleUpdateFlightFromDatabase(ActionEvent event)throws SQLException{

    }
    @FXML
    private void handleInsertFlightFromDatabase(ActionEvent event)throws SQLException{

    }
}