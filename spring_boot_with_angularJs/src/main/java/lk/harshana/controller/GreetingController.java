package lk.harshana.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lk.harshana.model.Greeting;

@RestController
@RequestMapping(value="/greeting")
public class GreetingController {

	private static List<Greeting> greetings;
	
	static {
		greetings  = new ArrayList<Greeting>();
		greetings.add(new Greeting(1, "welcome to angularjs examples"));
		greetings.add(new Greeting(2, "It is time to celebrate"));
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<Greeting> getGreetings() {
		return greetings;
	}
}
