package lk.harshana.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponentModule;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.util.JSON;

import lk.harshana.dto.PersonRequest;
import lk.harshana.model.Person;
import lk.harshana.service.person.PersonService;

@RestController
@RequestMapping(value="/api")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@RequestMapping(value="/savePerson", method=RequestMethod.POST)
	public ResponseEntity<?> savePerson(@RequestBody PersonRequest personRequset) {
		JSONObject object = null;
		try {
			Person person = new Person(personRequset.getName(), personRequset.getAddress(), personRequset.getAge(), personRequset.getEmail(), personRequset.getTelNo());
			personService.savePerson(person);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch(Exception e) {
			object = new JSONObject();
			object.put("error", e.getMessage());
			return new ResponseEntity<Object>(object, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/getAllPerson", method=RequestMethod.GET)
	public ResponseEntity<List<Person>> getAllPerson() {
		List<Person> list = personService.getAllPerson();
		JSONObject object = null;
		if(list.isEmpty()) {
			object = new JSONObject();
			object.put("status", "There is no conetent");
			return new ResponseEntity<List<Person>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Person>>(list, HttpStatus.OK);
	}
}
