package org.radkon.portal.people;

import org.radkon.portal.persistence.PersistentObject;

public class Person extends PersistentObject {

    private static final long serialVersionUID = -8519668230243094633L;

    private String firstname;
    private String surname;
    private String email;

    protected Person() {
        // ok
    }

    public Person(String firstname, String surname, String email) {
        setFirstname(firstname);
        setSurname(surname);
        setEmail(email);
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
