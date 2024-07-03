package com.example.formvalidationapp;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class FormValidationController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField contactField;

    @FXML
    private TextField postalField;

    @FXML
    private void initialize() {
    }

    @FXML
    private void handleValidateButton(ActionEvent event) {
        String username = nameField.getText();
        String contact = contactField.getText();
        String postalCode = postalField.getText();


        boolean isUsernameValid = username.matches("[A-Z][a-zA-Z]*");

        boolean isContactValid = contact.matches("(\\d{3}[-.\\s]?){2}\\d{4}");

        boolean isPostalValid = postalCode.matches("[A-Za-z]\\d[A-Za-z][-\\s]?\\d[A-Za-z]\\d");

        if (isUsernameValid && isContactValid && isPostalValid) {
            showAlert(Alert.AlertType.INFORMATION, "Validation Result", "Validation Successful!");
        } else {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Please check your input formats:\n"
                    + "- Username: First letter uppercase, followed by letters.\n"
                    + "- Contact Number: 10 digits, acceptable formats (XXX XXX XXXX or (XXX) XXX XXXX).\n"
                    + "- Postal Code: Canadian format (e.g., P6R 2V8 or p6r-2v8).");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
