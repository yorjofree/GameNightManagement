package com.freiorio.gamenightmanagement;

import javafx.beans.Observable;
import javafx.collections.ObservableList;

public class Table {
    private String game;
    private ObservableList<Person> players;
    private boolean started;
    private boolean ended;

    public Table(String game, ObservableList<Person> players) {
        this.game = game;
        this.players = players;
        this.started = false;
        this.ended = false;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public ObservableList<Person> getPlayers() {
        return players;
    }

    public void setPlayers(ObservableList<Person> players) {
        this.players = players;
    }

    public boolean addPlayer(Person player) {
        return players.add(player);
    }

    public boolean removePlayer(Person player) {
        return players.remove(player);
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
