package com.freiorio.gamenightmanagement;

import java.util.Objects;

public class Person {
    private String name;
    private String lastname;
    private String CF;
    private boolean associate;

    public Person(String name, String lastname, String CF, boolean associate) {
        this.name = name;
        this.lastname = lastname;
        setCF(CF);
        this.associate = associate;
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

    public boolean isAssociate() {
        return associate;
    }

    public void setAssociate(boolean associate) {
        this.associate = associate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(getCF(), person.getCF());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getCF());
    }

    private void checkValidCF (String CF) throws IllegalArgumentException {
        if (!CF.matches("[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]")) {
            throw new IllegalArgumentException("CF format string is not correct. Correct format is AAAAAAddAddAdddA (A=alphabetic uppercase, d=digit)");
        }
    }
}
