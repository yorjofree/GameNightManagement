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
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class ManagementController {
    @FXML
    private Label emptyTablesView;
    @FXML
    private TableView<Person> peopleView;
    @FXML
    private TableColumn<Person, String> nickname;
    @FXML
    private TableColumn<Person, Integer> score;
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
    protected TableColumn<Table, String> state;
    @FXML
    protected ObservableList<Person> people;
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
        people = FXCollections.observableArrayList();
        tablesView.setItems(tables);
        tablesView.setPlaceholder(emptyTablesView);

        game.setCellValueFactory(new PropertyValueFactory<>("game"));
        nMax.setCellValueFactory(new PropertyValueFactory<>("nPlayers"));
        nAvailable.setCellValueFactory(new PropertyValueFactory<>("nAvailable"));
        players.setCellValueFactory(new PropertyValueFactory<>("nicknames"));
        state.setCellValueFactory(new PropertyValueFactory<>("state"));

        peopleView.setItems(people);
        nickname.setCellValueFactory(new PropertyValueFactory<>("nickname"));
        score.setCellValueFactory(new PropertyValueFactory<>("score"));
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
        tableViewButtonBar.setDisable(true);
    }

    @FXML
    protected void onAddPlayerClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ManagementController.class.getResource("add-player-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 120);
        AddPlayerController controller = fxmlLoader.getController();
        controller.setTable(selectedTable);
        controller.setPeople(people);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Add player");
        stage.showAndWait();

        System.out.println(people.contains(controller.getPerson()));
        System.out.println(people.toString());
        peopleView.refresh();
        tablesView.refresh();
        tableViewButtonBar.setDisable(true);
    }

    @FXML
    protected void onRemovePlayerClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ManagementController.class.getResource("remove-player-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 120);
        RemovePlayerController controller = fxmlLoader.getController();
        controller.setTable(selectedTable);
        controller.setPlayers(selectedTable.getNicknames());

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Remove player");
        stage.showAndWait();
        tablesView.refresh();
        tableViewButtonBar.setDisable(true);
    }

    @FXML
    protected void onStartGameClick(ActionEvent event) {
        if (selectedTable.isReady()) {
            selectedTable.start();
            tablesView.refresh();
            tableViewButtonBar.setDisable(true);
        }
    }

    @FXML
    protected void onEndGameClick(ActionEvent event) throws IOException {
        if (selectedTable.isStarted()) {
            selectedTable.end();
            tablesView.refresh();
            tableViewButtonBar.setDisable(true);

            FXMLLoader fxmlLoader = new FXMLLoader(ManagementController.class.getResource("end-game-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 300, 400);
            EndGameController controller = fxmlLoader.getController();
            controller.setPeople(people);
            controller.setPlayers(selectedTable.getNicknames());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Remove player");
            stage.showAndWait();
        }
    }

    @FXML
    protected void onViewRanking(MouseEvent event) {
        peopleView.setVisible(true);
        peopleView.refresh();
    }

    @FXML
    protected void onViewTables(MouseEvent event) {
        peopleView.setVisible(false);
        tablesView.refresh();
    }
}