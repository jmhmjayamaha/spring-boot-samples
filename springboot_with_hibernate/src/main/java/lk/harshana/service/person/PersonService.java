package lk.harshana.service.person;

import java.util.List;

import lk.harshana.model.Person;

public interface PersonService {

	void savePerson(Person person);
	void updatePerson(Person person);
	void deletePerson(Person Person);
	boolean deletePersonById(int id);
	List<Person> getAllPersons();
	Person getPerson(int id);
}
