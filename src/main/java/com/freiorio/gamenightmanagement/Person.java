package com.freiorio.gamenightmanagement;

import java.util.Objects;

public class Person implements Comparable<Person>{
    private String name;
    private String lastname;
    private String CF;
    private String nickname;
    private boolean associate;
    private int score;


    public Person(String name, String lastname, String nickname, boolean associate) {
        this.name = name;
        this.lastname = lastname;
        this.nickname = nickname;
        this.associate = associate;
        this.CF = "unknown";
        this.score = 0;
    }

    public Person(String name, String lastname, String CF, String nickname, boolean associate, int score) {
        this.name = name;
        this.lastname = lastname;
        setCF(CF);
        this.nickname = nickname;
        this.associate = associate;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCF() {
        return CF;
    }

    public void setCF(String CF) {
        checkValidCF(CF);
        this.CF = CF;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isAssociate() {
        return associate;
    }

    public void setAssociate(boolean associate) {
        this.associate = associate;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(getNickname(), person.getNickname());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getNickname());
    }

    private void checkValidCF (String CF) throws IllegalArgumentException {
        if (!CF.matches("[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]")) {
            throw new IllegalArgumentException("CF format string is not correct. Correct format is AAAAAAddAddAdddA (A=alphabetic uppercase, d=digit)");
        }
    }

    @Override
    public int compareTo(Person o) {
        return this.nickname.compareTo(o.getNickname());
    }
}
