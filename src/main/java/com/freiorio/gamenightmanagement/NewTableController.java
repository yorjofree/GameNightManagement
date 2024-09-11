package com.freiorio.gamenightmanagement;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class NewTableController {
    @FXML
    private Button addTableButton;
    @FXML
    private TextField gameTextField;
    @FXML
    private ChoiceBox<Integer> numberOfPlayers;
    private Table table;

    public void initialize() {
        numberOfPlayers.setItems(FXCollections.observableList(List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)));
    }

    @FXML
    protected void onAddTableButtonClick(ActionEvent event) {
        String gameName = gameTextField.getText();
        int n = numberOfPlayers.getValue();
        if (gameName != null && !gameName.isEmpty()) {
            table = new Table(gameName, n);
            Stage stage = (Stage) gameTextField.getScene().getWindow();
            stage.close();
        }
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
