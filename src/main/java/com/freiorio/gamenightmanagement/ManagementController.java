package com.freiorio.gamenightmanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ManagementController {
    @FXML
    private Label emptyTablesView;
    @FXML
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
    private ButtonBar tableViewButtonBar;

    private Table selectedTable;

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
        players.setCellValueFactory(new PropertyValueFactory<>("nicknameSet"));

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

    @FXML
    protected void onTableViewClick(MouseEvent event) {
        TableView.TableViewSelectionModel<Table> selectionModel = tablesView.getSelectionModel();
        if (!selectionModel.isEmpty()) {
            tableViewButtonBar.setDisable(false);
            selectedTable = selectionModel.getSelectedItem();
        }
    }

    @FXML
    protected void onRemoveTableButtonClick(ActionEvent event) {
        tables.remove(selectedTable);
    }

    @FXML
    protected void onAddPlayerClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ManagementController.class.getResource("add-player-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 120);
        AddPlayerController controller = fxmlLoader.getController();
        controller.setTable(selectedTable);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Add player");
        stage.showAndWait();
        tablesView.refresh();
    }


}