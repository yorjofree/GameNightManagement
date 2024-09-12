package com.freiorio.gamenightmanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class AddPlayerController {
    @FXML
    private TextField nicknameTextField;

    private Table table;
    private ObservableList<Person> people;

    public Person getPerson() {
        return person;
    }

    private Person person;

    public void setPeople(ObservableList<Person> people) {
        this.people = people;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    @FXML
    protected void onAddPlayerButtonClick(ActionEvent event) {
        String nickname = nicknameTextField.getText();
        if (nickname != null && !nickname.isEmpty() && !table.getPlayers().contains(new Person(nickname)) && table.getNAvailable() > 0) {
            person = new Person(nickname);
            table.addPlayer(person);
            if (!people.contains(person)) {
                people.add(person);
                System.out.println(people);
                FXCollections.copy(people, new ArrayList<>(Set.copyOf(people)));
                System.out.println(people);
            }

            Stage stage = (Stage) nicknameTextField.getScene().getWindow();
            stage.close();
        }
    }
}
