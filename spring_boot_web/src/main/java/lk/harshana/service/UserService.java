package lk.harshana.service;

import java.util.List;

import lk.harshana.model.User;

public interface UserService {

	List<User> getAllUsers();
	User getUser(String name);
}
