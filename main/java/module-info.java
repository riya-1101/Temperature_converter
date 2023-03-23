module com.example.temprature_app {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.temperature_app to javafx.fxml;
    exports com.example.temperature_app;
}