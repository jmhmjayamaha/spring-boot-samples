package lk.harshana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lk.harshana.model.User;
import lk.harshana.service.UserService;

@Controller
public class GreetingController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value="name", required = false, defaultValue = "jayamaha") String name, Model model) {
		model.addAttribute("name" , name);
		return "greeting";
	}
	
	@RequestMapping("/findUser")
	public String getUser(@RequestParam(value="name" , required = false, defaultValue = "harshana") String name, Model model) {
		User user = userService.getUser(name);
		model.addAttribute("userName", name);
		model.addAttribute("address", user.getAddress());
		model.addAttribute("id", user.getId());
		
		return "user";
	}
}
