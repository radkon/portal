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

    public PersonService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Person create(Person person) {
        entityManager.persist(person);
        return person;
    }

    public Person readById(String personId) {
        return entityManager.find(Person.class, personId);
    }

    public Person update(Person person) {
        return entityManager.merge(person);
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
