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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lk.harshana.dto.PersonRequest;
import lk.harshana.model.Person;
import lk.harshana.service.person.PersonService;

@RestController
@RequestMapping(value = "/api")
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/savePerson", method = RequestMethod.POST)
	public ResponseEntity<?> savePerson(@RequestBody PersonRequest personRequest) {

		JSONObject jsonObject = null;

		try {
			Person person = new Person();
			person.setName(personRequest.getName());
			person.setAddress(personRequest.getAddress());
			person.setNic(personRequest.getNic());
			person.setTelNo(personRequest.getTelNo());
			person.setEmail(personRequest.getEmail());

			personService.savePerson(person);
			jsonObject = new JSONObject();
			jsonObject.put("status", "true");
			return new ResponseEntity<Object>(jsonObject, HttpStatus.OK);
		} catch (Exception e) {
			jsonObject = new JSONObject();
			jsonObject.put("error", e.getMessage());
			jsonObject.put("status", "false");

			return new ResponseEntity<Object>(jsonObject, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/allPerson", method = RequestMethod.GET)
	public ResponseEntity<List<Person>> getAllPersons() {
		List<Person> list = personService.getAllPersons();

		if (list.isEmpty()) {
			return new ResponseEntity<List<Person>>(list, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Person>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/getPerson/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getPerson(@PathVariable("id") int id) {
		Person person = personService.getPerson(id);
		if (person == null) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("Status", "false");
			jsonObject.put("Discription", "No content found");
			return new ResponseEntity<Object>(jsonObject, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}
	
	@RequestMapping(value="/deletePerson/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<?> deletePerson(@PathVariable("id") int id) {
		boolean delete = personService.deletePersonById(id);
		JSONObject jsonObject = null;
		
		if(delete == false) {
			jsonObject = new JSONObject();
			jsonObject.put("Status", "false");
			return new ResponseEntity<Object>(jsonObject, HttpStatus.BAD_REQUEST);
		}
		else {
			jsonObject = new JSONObject();
			jsonObject.put("Status", "true");
			return new ResponseEntity<Object>(jsonObject, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/updatePerson/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updatePerson(@PathVariable("id") int id, @RequestBody PersonRequest personRequest) {
		Person person = new Person();
		person.setId(id);
		person.setName(personRequest.getName());
		person.setAddress(personRequest.getAddress());
		person.setNic(personRequest.getNic());
		person.setTelNo(personRequest.getTelNo());
		person.setEmail(personRequest.getEmail());
		
		boolean update = personService.updatePerson(id, person);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Status", "false");
		if(update == false) {
			return new ResponseEntity<Object>(jsonObject, HttpStatus.BAD_REQUEST);
		}
		else {
			jsonObject = new JSONObject();
			jsonObject.put("Status", "true");
			return new ResponseEntity<Object>(jsonObject, HttpStatus.OK);
		}
	}
}
