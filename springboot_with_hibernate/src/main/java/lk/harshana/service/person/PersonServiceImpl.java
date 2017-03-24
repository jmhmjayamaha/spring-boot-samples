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

	public void updatePerson(Person person) {
		// TODO Auto-generated method stub
		
	}

	public void deletePerson(Person Person) {
		// TODO Auto-generated method stub
		
	}

	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return null;
	}

	public Person getPerson() {
		// TODO Auto-generated method stub
		return null;
	}

}
