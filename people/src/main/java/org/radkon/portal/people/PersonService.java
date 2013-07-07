package org.radkon.portal.people;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
public class PersonService {

    @Inject
    private EntityManager entityManager;

    public PersonService() {
        // ok
    }

    PersonService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Person save(Person person) {
        return entityManager.merge(person);
    }

    public Person readById(String personId) {
        return entityManager.find(Person.class, personId);
    }

    public void delete(Person person) {
        if (person != null) {
            final Person reference = entityManager.getReference(Person.class, person.getId());
            if (reference != null) {
                entityManager.remove(reference);
            }
        }
    }

}
