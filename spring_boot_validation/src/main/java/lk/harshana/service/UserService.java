package lk.harshana.service;

import java.util.List;

import lk.harshana.model.User;

public interface UserService {

	List<User> getAllUsers();
	void saveUser(User user);
	void updateUser(Integer id,User user);
	boolean deleteUser(Integer id);
	
}
