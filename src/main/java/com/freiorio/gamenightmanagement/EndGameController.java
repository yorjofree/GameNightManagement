package com.freiorio.gamenightmanagement;

import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.util.Objects;

public class EndGameController {
    private ObservableList<Person> people;

    @FXML
    private ChoiceBox<String> first;
    @FXML
    private ChoiceBox<String> second;
    @FXML
    private ChoiceBox<String> third;

    public void initialize() {
        first.setValue("--NONE--");
        second.setValue("--NONE--");
        third.setValue("--NONE--");
    }

    public void setPeople(ObservableList<Person> people) {
        this.people = people;
    }

    public void setPlayers(ObservableList<String> nicknames) {
        first.setItems(nicknames);
        second.setItems(nicknames);
        third.setItems(nicknames);
    }

    @FXML
    protected void onSaveButtonClick(ActionEvent event) {
        String firstPlacement = first.getValue();
        String secondPlacement = second.getValue();
        String thirdPlacement = third.getValue();
        if (!firstPlacement.equals(secondPlacement) && !secondPlacement.equals(thirdPlacement) && !thirdPlacement.equals(firstPlacement)) {
            people.forEach(person -> {
                if (person.getNickname().equals(firstPlacement)) {
                    person.addScore(40);
                }
                if (person.getNickname().equals(secondPlacement)) {
                    person.addScore(20);
                }
                if (person.getNickname().equals(thirdPlacement)) {
                    person.addScore(10);
                }
            });
        }

        Stage stage = (Stage) first.getScene().getWindow();
        stage.close();
    }
}
