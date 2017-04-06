package lk.harshana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lk.harshana.dto.UserRequest;
import lk.harshana.model.User;
import lk.harshana.service.user.UserService;

@RestController
@RequestMapping(value="/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/save" , method=RequestMethod.POST)
	public void saveUser(@RequestBody UserRequest userRequest) {
		User user = new User();
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setAddress(userRequest.getAddress());
		user.setAge(userRequest.getAge());
		user.setEmail(userRequest.getEmail());
		user.setTelNo(userRequest.getTelNo());
		
		userService.saveUser(user);
	}
}
