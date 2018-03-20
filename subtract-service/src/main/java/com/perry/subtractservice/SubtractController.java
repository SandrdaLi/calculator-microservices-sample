package com.perry.subtractservice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubtractController {

	@RequestMapping(value = "/{num1}/{num2}")
	public String subtract(@PathVariable int num1, @PathVariable int num2) {
		return Integer.toString(num1 - num2);
	}

}
