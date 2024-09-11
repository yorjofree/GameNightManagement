package com.freiorio.gamenightmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddPlayerController {
    @FXML
    private TextField nicknameTextField;

    private String nickname;
    private Table table;

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    @FXML
    protected void onAddPlayerButtonClick(ActionEvent event) {
        nickname = nicknameTextField.getText();
        if (nickname != null && !nickname.isEmpty() && !table.getPlayers().contains(new Person(nickname)) && table.getNAvailable() > 0) {
            table.addPlayer(new Person(nickname));
            Stage stage = (Stage) nicknameTextField.getScene().getWindow();
            stage.close();
        }
    }
}
