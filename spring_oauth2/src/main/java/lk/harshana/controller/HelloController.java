package lk.harshana.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping(value="/")
	public String index() {
		return "hello world";
	}
	
	@GetMapping(value="/private")
	public String privete() {
		return "private";
	}
}
