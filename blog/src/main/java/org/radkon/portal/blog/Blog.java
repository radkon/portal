package org.radkon.portal.blog;

import org.radkon.portal.people.Person;
import org.radkon.portal.persistence.PersistentObject;

import java.io.Serializable;

public class Blog implements Serializable {

    private static final long serialVersionUID = -954545207933438177L;

    private String title;
    private Person owner;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
