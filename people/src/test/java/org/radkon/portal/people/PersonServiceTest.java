package org.radkon.portal.people;

import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class PersonServiceTest {

    EntityManager entityManagerMock = mock(EntityManager.class);

    PersonService personService;

    @Before
    public void before() {
        personService = new PersonService(entityManagerMock);
    }

    @Test
    public void creatingNewPersonViaSave() {
        // given
        final Person person = new Person("Markus", "Konrad", "markus.konrad@prodyna.com");
        // when
        personService.save(person);
        //then
        verify(entityManagerMock).merge(person);
    }

    @Test
    public void readingExistingPersonById() {
        // given
        final Person person = new Person("Markus", "Konrad", "markus.konrad@prodyna.com");
        stub(entityManagerMock.merge(person)).toReturn(person);
        final Person savedPerson = personService.save(person);
        // when
        personService.readById(savedPerson.getId());
        // then
        verify(entityManagerMock).find(Person.class, person.getId());
    }

    @Test
    public void updatingExistingPersonViaSave() {
        // given
        final Person person = new Person("Markus", "Konrad", "markus.konrad@prodyna.com");
        stub(entityManagerMock.merge(person)).toReturn(person);
        final Person createdPerson = personService.save(person);
        createdPerson.setEmail("mkonrad@prodyna.com");
        stub(entityManagerMock.merge(createdPerson)).toReturn(createdPerson);
        // when
        final Person updatedPerson = personService.save(createdPerson);
        // then
        assertThat(updatedPerson).isNotNull();
        assertThat(updatedPerson.getId()).isEqualTo(createdPerson.getId());
        assertThat(updatedPerson.getFirstname()).isEqualTo(createdPerson.getFirstname());
        assertThat(updatedPerson.getSurname()).isEqualTo(createdPerson.getSurname());
        assertThat(updatedPerson.getEmail()).isEqualTo(createdPerson.getEmail());
    }


}
