package lk.harshana.service.user;

import java.util.List;

import lk.harshana.model.User;

public interface UserService {

	void saveUser(User user);
	List<User> getAllUsers();
	List<User> getUserByFirstName(String fName);
	List<User> getUserByLastName(String lName);
	User getUser(int id);
	boolean updateUser(int id,User user);
	boolean deletePerson(int id);
	
}
