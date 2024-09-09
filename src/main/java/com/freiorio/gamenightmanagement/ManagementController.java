package com.freiorio.gamenightmanagement;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class ManagementController {
    @FXML
    private Label welcomeText;
    private ListView<Person> people;
    private ListView<Table> tables;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}