package com.freiorio.gamenightmanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Table {
    private String game;
    private ObservableSet<Person> players;
    private int nPlayers;
    private boolean started;
    private boolean ended;

    public Table(String game, int nPlayers) {
        this.game = game;
        this.players = FXCollections.observableSet(new LinkedHashSet<>());
        this.nPlayers = nPlayers;
        this.started = false;
        this.ended = false;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public ObservableSet<Person> getPlayers() {
        return players;
    }

    public void setPlayers(ObservableSet<Person> players) {
        this.players = players;
    }

    public ObservableList<String> getNicknames() {
        ObservableList<String> nicknameSet = FXCollections.observableList(new ArrayList<>());
        players.forEach(player -> nicknameSet.add(player.getNickname()));
        return nicknameSet;
    }

    public int getNPlayers() {
        return nPlayers;
    }

    public void setNPlayers(int nPlayers) {
        this.nPlayers = nPlayers;
    }

    public int getNAvailable() {
        return getNPlayers() - players.size();
    }

    public String getState() {
        if (isStarted() && !isEnded()) {
            return "started";
        }
        if (isStarted() && isEnded()) {
            return "ended";
        }
        return "ready";
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

    public boolean isReady() {
        return !started && !ended;
    }

    public void start() {
        started = true;
    }

    public void end() {
        ended = true;
    }
}
