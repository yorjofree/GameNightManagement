package com.freiorio.gamenightmanagement;

import javafx.beans.Observable;
import javafx.collections.ObservableList;

public class Table {
    private String game;
    private ObservableList<Person> gamers;
    private boolean started;
    private boolean ended;

    public Table(String game, ObservableList<Person> gamers) {
        this.game = game;
        this.gamers = gamers;
        this.started = false;
        this.ended = false;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public ObservableList<Person> getGamers() {
        return gamers;
    }

    public void setGamers(ObservableList<Person> gamers) {
        this.gamers = gamers;
    }

    public boolean addGamer(Person gamer) {
        return gamers.add(gamer);
    }

    public boolean removeGamer(Person gamer) {
        return gamers.remove(gamer);
    }

    public boolean isStarted() {
        return started;
    }

    public boolean isEnded() {
        return ended;
    }

    public void start() {
        started = true;
    }

    public void end() {
        ended = true;
    }
}
