package com.example;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class SpringController {

	@RequestMapping("/")
	public String index() {
		return "Enter a number 1-10 in the url bar to see one of my author recommendations. Ex: http://localhost:8080/{number}";
	}

	@GetMapping("/{id}")
	public String getRecommendation(@PathVariable String id) {
		switch (id) {
		case "1":
			return "Brandon Sanderson";
		case "2":
			return "Brent Weeks";
		case "3":
			return "Brian McClellan";
		case "4":
			return "J.R.R. Tolkein";
		case "5":
			return "John Flanagan";
		case "6":
			return "Lee Child";
		case "7":
			return "Robert Jordan";
		case "8":
			return "Robin Hobb";
		case "9":
			return "Terry Brooks";
		case "10":
			return "Vince Flynn";
		}
		return "Enter a number 1-10";
	}
}