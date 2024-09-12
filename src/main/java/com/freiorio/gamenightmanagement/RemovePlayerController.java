package com.freiorio.gamenightmanagement;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class RemovePlayerController {
    private Table table;

    @FXML
    private ChoiceBox<String> players;

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public void setPlayers(ObservableList<String> nicknames) {
        players.setItems(nicknames);
    }

    @FXML
    protected void onRemovePlayerButtonClick(ActionEvent event) {
        table.removePlayer(new Person(players.getValue()));

        Stage stage = (Stage) players.getScene().getWindow();
        stage.close();
    }
}
