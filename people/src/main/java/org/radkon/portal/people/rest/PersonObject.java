package org.radkon.portal.people.rest;

import java.io.Serializable;

public class PersonObject implements Serializable {

    private static final long serialVersionUID = -4912939522976602828L;

    private String firstname;
    private String surname;
    private String email;

    PersonObject() {
        // ok
    }

    public PersonObject(String firstname, String surname, String email) {
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
