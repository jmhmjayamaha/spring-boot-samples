package lk.harshana.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lk.harshana.model.Greeting;

@RestController
public class GreetingController {

	@RequestMapping(value="/greeting" , method = RequestMethod.GET)
	public Greeting getGreeting() {
		return new Greeting("Greeting...");
	}
}
