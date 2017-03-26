package lk.harshana.dao.person;

import java.util.List;

import lk.harshana.model.Person;

public interface PersonDao {

	void savePerson(Person person);
	void updatePerson(Person person);
	void deletePerson(Person Person);
	boolean deletePersonById(int id);
	List<Person> getAllPersons();
	Person getPerson(int id);
	
}
