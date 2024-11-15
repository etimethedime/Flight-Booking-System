module org.example.flightbooking {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.flightbooking to javafx.fxml;
    exports org.example.flightbooking;
}