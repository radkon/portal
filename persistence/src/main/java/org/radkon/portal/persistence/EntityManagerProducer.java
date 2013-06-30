package org.radkon.portal.persistence;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EntityManagerProducer {

    @Produces
    @PersistenceContext(unitName = "portal")
    private EntityManager entityManager;

}
