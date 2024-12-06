module org.example.flightbooking {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.flightbooking to javafx.fxml;
    exports org.example.flightbooking;
}