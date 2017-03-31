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
	public void updatePerson(String id, Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deletePerson(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Person> getPersonByName(String name) {
		return personDao.findByName(name);
	}
	
	
}
