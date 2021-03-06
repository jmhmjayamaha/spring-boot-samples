package lk.harshana.service.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.harshana.dao.person.PersonDao;
import lk.harshana.model.Person;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao personDao;

	@Override
	public List<Person> getAllPerson() {
		return personDao.findAll();
	}

	@Override
	public Person getPersonById(String id) {
		
		return personDao.findById(id);
	}

	@Override
	public void savePerson(Person person) {
		
		personDao.save(person);
		
	}

	@Override
	public boolean updatePerson(String id, Person person) {
		Person p = getPersonById(id);
		if(p == null) {
			return false;
		} else {
			personDao.save(person);
			return true;
		}
	}

	@Override
	public boolean deletePerson(String id) {
		Person p = getPersonById(id);
		if(p == null) {
			return false;
		}
		else {
			personDao.delete(id);
			return true;
		}
	}

	@Override
	public List<Person> getPersonByName(String name) {
		return personDao.findByName(name);
	}
	
	
}
