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

	public boolean updatePerson(int id, Person person) {
		return update(id,person);
	}

	public void deletePerson(Person Person) {
		// TODO Auto-generated method stub
		
	}

	public List<Person> getAllPersons() {
		
		return listAllEntity();
	}

	public Person getPerson(int id) {
		// TODO Auto-generated method stub
		return findById(id);
	}

	@Override
	public boolean deletePersonById(int id) {
		
		return delete(id);
	}

}
