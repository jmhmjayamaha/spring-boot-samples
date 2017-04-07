package lk.harshana.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.harshana.dao.user.UserDao;
import lk.harshana.model.User;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public void saveUser(User user) {
		userDao.save(user);
	}

	public List<User> getAllUsers() {
		return (List<User>) userDao.findAll();
	}

	public List<User> getUserByFirstName(String fName) {
		return userDao.findByFirstName(fName);
	}

	public List<User> getUserByLastName(String lName) {
		return userDao.findByLastName(lName);
	}

	public User getUser(int id) {
		return userDao.findById(id);
	}

	public boolean updateUser(int id, User user) {
		User u = getUser(id);
		
		if(u == null) {
			return false;
		} else {
			userDao.save(user);
			return true;
		}
	}

	public boolean deletePerson(int id) {
		User user = getUser(id);
		
		if(user == null) {
			return false;
		}
		else {
			userDao.delete(user);
			return true;
		}
	}

}
