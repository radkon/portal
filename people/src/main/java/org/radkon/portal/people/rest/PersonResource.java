package org.radkon.portal.people.rest;

import org.radkon.portal.people.Person;
import org.radkon.portal.people.PersonService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject
    private PersonService personService;

    @POST
    @Path("person")
    public String create(PersonObject person) {
        final Person savedPerson = personService.save(new Person(person.getFirstname(), person.getSurname(),
                person.getEmail()));
        return savedPerson.getId();
    }

    @GET
    @Path("person/{id}")
    public PersonObject read(@PathParam("id") String id) {
        final Person person = personService.readById(id);
        if (person == null) {
            return null;
        } else {
            return new PersonObject(person.getFirstname(), person.getSurname(), person.getEmail());
        }
    }

    @PUT
    @Path("person/{id}")
    public PersonObject update(@PathParam("id") String id, PersonObject person) {
        final Person existingPerson = personService.readById(id);
        existingPerson.setFirstname(person.getFirstname());
        existingPerson.setSurname(person.getSurname());
        existingPerson.setEmail(person.getEmail());
        final Person updatedPerson = personService.save(existingPerson);
        return new PersonObject(updatedPerson.getFirstname(), updatedPerson.getSurname(), updatedPerson.getEmail());
    }

    @DELETE
    @Path("person/{id}")
    public void delete(@PathParam("id") String id) {
        personService.deleteById(id);

    }

}
