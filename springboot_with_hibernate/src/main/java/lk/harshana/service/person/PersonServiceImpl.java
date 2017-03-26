package lk.harshana.service.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.harshana.dao.person.PersonDao;
import lk.harshana.model.Person;

@Service("personService")
public class PersonServiceImpl implements PersonService  {

	@Autowired
	private PersonDao personDao;
	
	public void savePerson(Person person) {
		personDao.savePerson(person);
	}

	public boolean updatePerson(int id, Person person) {
		return personDao.updatePerson(id, person);
	}

	public void deletePerson(Person Person) {
		// TODO Auto-generated method stub
		
	}

	public List<Person> getAllPersons() {
		
		return personDao.getAllPersons();
	}

	public Person getPerson(int id) {
		Person person = personDao.getPerson(id);
		
		if(person == null ) {
			return null;
		}
		return person;
	}

	@Override
	public boolean deletePersonById(int id) {
		
		return personDao.deletePersonById(id);
	}

}
