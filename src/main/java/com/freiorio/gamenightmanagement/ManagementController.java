package com.freiorio.gamenightmanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArrayBase;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Popup;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManagementController {
    @FXML
    private Label emptyTablesView;
    private TableView<Person> peopleView;
    @FXML
    protected TableView<Table> tablesView;
    @FXML
    protected TableColumn<Table, String> game;
    @FXML
    protected TableColumn<Table, Integer> nMax;
    @FXML
    protected TableColumn<Table, Integer> nAvailable;
    @FXML
    protected TableColumn<Table, ObservableSet<Person>> players;
    @FXML
    protected TableColumn<Table, String> time;
    @FXML
    protected ObservableSet<Person> people;
    @FXML
    protected ObservableList<Table> tables;

    @FXML
    protected void onNewPersonClick(ActionEvent event) {
    }

    public void initialize() {
        tables = FXCollections.observableArrayList();
        tablesView.setItems(tables);
        tablesView.setPlaceholder(emptyTablesView);

        game.setCellValueFactory(new PropertyValueFactory<>("game"));
        nMax.setCellValueFactory(new PropertyValueFactory<>("nPlayers"));
        nAvailable.setCellValueFactory(new PropertyValueFactory<>("nAvailable"));
        players.setCellValueFactory(new PropertyValueFactory<>("players"));

    }

    @FXML
    protected void onNewTableClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ManagementController.class.getResource("new-table-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 150);
        NewTableController controller = fxmlLoader.getController();
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("New Table");
        stage.showAndWait();
        tables.add(controller.getTable());
    }


}