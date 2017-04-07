package lk.harshana.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value="/getAllUsers" , method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> list = userService.getAllUsers();
		
		if(list.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<User>>(list, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/getUserByFirstName/{name}" , method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUserByFirstName(@PathVariable("name") String name) {
		List<User> list = userService.getUserByFirstName(name);
		
		if(list.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<User>>(list, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/getUserByLastName/{name}" , method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUserByLastName(@PathVariable("name") String name) {
		List<User> list = userService.getUserByLastName(name);
		
		if(list.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<User>>(list, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/getUserById/{id}" , method = RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
		User user = userService.getUser(id);
		
		if(user == null ) {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<User>(user ,HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/delete/{id}" , method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
		boolean delete = userService.deletePerson(id);
		JSONObject jsonObject = null;
		
		if(delete) {
			jsonObject = new JSONObject();
			jsonObject.put("Status", "deleted");
			return new ResponseEntity<Object>(jsonObject, HttpStatus.OK);
		}
		else {
			jsonObject = new JSONObject();
			jsonObject.put("Status", "couldn't deleted ");
			return new ResponseEntity<Object>(jsonObject, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/update/{id}" , method=RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable("id") int id , @RequestBody UserRequest userRequest) {
		User user = new User();
		user.setId(id);
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setAddress(userRequest.getAddress());
		user.setAge(userRequest.getAge());
		user.setEmail(userRequest.getEmail());
		user.setTelNo(userRequest.getTelNo());
		
		boolean update = userService.updateUser(id, user);
		
		if(update) {
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
}
