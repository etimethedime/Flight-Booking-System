module org.example.flightbooking {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens org.example.flightbooking to javafx.fxml;
    exports org.example.flightbooking;
}