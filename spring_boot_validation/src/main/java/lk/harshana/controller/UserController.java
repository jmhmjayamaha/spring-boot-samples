package lk.harshana.controller;

import java.util.AbstractMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lk.harshana.dto.UserDto;
import lk.harshana.model.User;
import lk.harshana.service.UserService;

@RestController
@RequestMapping(value="/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void saveUser(@RequestBody @Validated UserDto dto) {
		userService.saveUser(new User(dto.getName(), dto.getAge(), dto.getAddress()));
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.CREATED)
	public void updateUser(@PathVariable(value="id") Integer id,@RequestBody @Validated UserDto dto) {
		userService.updateUser(id, new User(dto.getName(), dto.getAge(), dto.getAddress()));
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.OK)
	public AbstractMap.SimpleEntry<String, String> deleteUser(@PathVariable(value="id") Integer id) {
		if(userService.deleteUser(id)) {
			return new AbstractMap.SimpleEntry<String, String>("staus", "DELETED");
		}
		return new AbstractMap.SimpleEntry<String, String>("staus", "NOT DELETED");
	}
}
