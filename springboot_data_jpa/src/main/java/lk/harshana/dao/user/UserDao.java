package lk.harshana.dao.user;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import lk.harshana.model.User;

public interface UserDao extends CrudRepository<User, Long>{

	List<User> findByFirstName(String fName);
	List<User> findByLastName(String lName);
	User findById(int id);
	
}
