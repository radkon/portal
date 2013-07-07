package org.radkon.portal.people;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.radkon.portal.people.rest.PersonObject;
import org.radkon.portal.people.rest.PersonResource;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.radkon.portal.DeploymentBuilder.*;

@RunWith(Arquillian.class)
public class PersonResourceTest {

    @Deployment
    public static Archive<?> setUp() throws Exception {
        return createDeployment().with(loggingModule(), persistenceModule(), peopleModule()).build();
    }

    @Inject
    PersonResource personResource;

    @Test
    public void testCRUD() throws Exception {

        final PersonObject person = new PersonObject("Markus", "Konrad", "markus.konrad@prodyna.com");

        final String personId = personResource.create(person);
        assertThat(personId).isNotNull().isNotEmpty();

        final PersonObject readPerson = personResource.read(personId);
        assertThat(readPerson).isNotNull();
        assertThat(readPerson.getFirstname()).isEqualTo(person.getFirstname());
        assertThat(readPerson.getSurname()).isEqualTo(person.getSurname());
        assertThat(readPerson.getEmail()).isEqualTo(person.getEmail());

        person.setEmail("mkonrad@prodyna.com");
        final PersonObject updatedPerson = personResource.update(personId, person);
        assertThat(updatedPerson).isNotNull();
        assertThat(updatedPerson.getFirstname()).isEqualTo(person.getFirstname());
        assertThat(updatedPerson.getSurname()).isEqualTo(person.getSurname());
        assertThat(updatedPerson.getEmail()).isEqualTo(person.getEmail());

        personResource.delete(personId);

        final PersonObject afterDeletionPerson = personResource.read(personId);
        assertThat(afterDeletionPerson).isNull();


    }
}
