import org.junit.Before;
import org.junit.Test;
import org.radkon.portal.people.Person;
import org.radkon.portal.people.PersonService;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PersonServiceTest {

    EntityManager mockedEntityManager = mock(EntityManager.class);

    PersonService personService;

    @Before
    public void before() {
        personService = new PersonService(mockedEntityManager);
    }

    @Test
    public void canCreateNewPerson() {
        // given
        final Person person = new Person("Markus", "Konrad", "markus.konrad@prodyna.com");
        // when
        final Person createdPerson = personService.create(person);
        //then
        assertThat(createdPerson).isNotNull();
        assertThat(createdPerson.getId()).isEqualTo(person.getId());
        assertThat(createdPerson.getFirstname()).isEqualTo(person.getFirstname());
        assertThat(createdPerson.getSurname()).isEqualTo(person.getSurname());
        assertThat(createdPerson.getEmail()).isEqualTo(person.getEmail());
    }

    @Test
    public void canReadExistingPerson() {
        // given
        final Person person = new Person("Markus", "Konrad", "markus.konrad@prodyna.com");
        final Person createdPerson = personService.create(person);
        doReturn(createdPerson).when(mockedEntityManager).find(Person.class, person.getId());
        // when
        final Person readPerson = personService.readById(createdPerson.getId());
        // then
        verify(mockedEntityManager).find(Person.class, person.getId());
        assertThat(readPerson).isNotNull();
        assertThat(readPerson.getId()).isEqualTo(createdPerson.getId());
        assertThat(readPerson.getFirstname()).isEqualTo(createdPerson.getFirstname());
        assertThat(readPerson.getSurname()).isEqualTo(createdPerson.getSurname());
        assertThat(readPerson.getEmail()).isEqualTo(createdPerson.getEmail());
    }

    @Test
    public void canUpdateExistingPerson() {
        // given
        final Person person = new Person("Markus", "Konrad", "markus.konrad@prodyna.com");
        final Person createdPerson = personService.create(person);
        doReturn(createdPerson).when(mockedEntityManager).find(Person.class, person.getId());
        // when
        final Person readPerson = personService.readById(createdPerson.getId());
        // then
        verify(mockedEntityManager).find(Person.class, person.getId());
        assertThat(readPerson).isNotNull();
        assertThat(readPerson.getId()).isEqualTo(createdPerson.getId());
        assertThat(readPerson.getFirstname()).isEqualTo(createdPerson.getFirstname());
        assertThat(readPerson.getSurname()).isEqualTo(createdPerson.getSurname());
        assertThat(readPerson.getEmail()).isEqualTo(createdPerson.getEmail());
    }


}
