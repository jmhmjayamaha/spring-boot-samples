package lk.harshana.dao.person;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import lk.harshana.model.Person;

public interface PersonDao extends MongoRepository<Person, String>{

	List<Person> findByName(String name);
	Person findById(String id);
	
}
