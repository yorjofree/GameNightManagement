package com.freiorio.gamenightmanagement;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ManagementController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}