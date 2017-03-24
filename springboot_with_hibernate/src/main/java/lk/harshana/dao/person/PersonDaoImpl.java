package lk.harshana.dao.person;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lk.harshana.dao.FrameworkDao;
import lk.harshana.model.Person;

@Repository("personDao")
@Transactional
public class PersonDaoImpl extends FrameworkDao<Person> implements PersonDao  {

	public void savePerson(Person person) {
		persist(person);
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
