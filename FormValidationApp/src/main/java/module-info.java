module com.example.formvalidationapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.formvalidationapp to javafx.fxml;
    exports com.example.formvalidationapp;
}