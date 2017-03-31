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
			return new ResponseEntity<List<Person>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Person>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getPersonByName/{name}", method=RequestMethod.GET)
	public ResponseEntity<List<Person>> getPersonByName(@PathVariable("name") String name) {
		List<Person> list = personService.getPersonByName(name);
		
		if(list.isEmpty()) {
			return new ResponseEntity<List<Person>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Person>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getPersonById/{id}", method=RequestMethod.GET)
	public ResponseEntity<Person> getPersonById(@PathVariable("id") String id) {
		Person person = personService.getPersonById(id);
		
		if(person == null) {
			return new ResponseEntity<Person>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}
	
	@RequestMapping(value="/deletePerson/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deletePersonById(@PathVariable("id") String id) {
		boolean delete = personService.deletePerson(id);
		JSONObject object = null;
		
		if(delete) {
			object = new JSONObject();
			object.put("Status", "true");
			return new ResponseEntity<Object>(object, HttpStatus.OK);
		} else {
			object = new JSONObject();
			object.put("Status", "false");
			object.put("Error", "No content to delete");
			return new ResponseEntity<Object>(object, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/updatePerson/{id}", method=RequestMethod.PUT)
	public ResponseEntity<?> updatePerson(@PathVariable("id")String id, @RequestBody Person person) {
		person.setId(id);
		boolean update = personService.updatePerson(id, person);
		JSONObject object = null;
		
		try {
			if(update) {
				object = new JSONObject();
				object.put("Status", "true");
				return new ResponseEntity<Object>(object, HttpStatus.OK);
			} else {
				object = new JSONObject();
				object.put("Status", "false");
				object.put("Error", "No Matching content to update");
				return new ResponseEntity<Object>(object, HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			object = new JSONObject();
			object.put("Status", "false");
			object.put("Error", e.getMessage());
			return new ResponseEntity<Object>(object, HttpStatus.BAD_REQUEST);
		}
	}
}
