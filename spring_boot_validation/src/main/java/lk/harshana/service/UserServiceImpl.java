package lk.harshana.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.harshana.model.User;
import lk.harshana.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void updateUser(Integer id, User user) {
		if(userRepository.findOne(id) != null) {
			user.setId(id);
			userRepository.save(user);
		}
	}

	@Override
	public boolean deleteUser(Integer id) {
		if(userRepository.findOne(id) != null ){
			userRepository.delete(id);
			return true;
		}
		return false;
	}
	
	
}
