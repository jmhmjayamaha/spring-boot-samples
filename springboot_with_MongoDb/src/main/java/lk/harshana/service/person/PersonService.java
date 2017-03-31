package lk.harshana.service.person;

import java.util.List;

import lk.harshana.model.Person;

public interface PersonService {

	List<Person> getAllPerson();
	Person getPersonById(String id);
	List<Person> getPersonByName(String name);
	void savePerson(Person person);
	void updatePerson(String id, Person person);
	boolean deletePerson(String id);
	
}
