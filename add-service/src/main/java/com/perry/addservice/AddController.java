package com.perry.addservice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddController {

	@RequestMapping(value = "/{num1}/{num2}")
	public String addNumbers(@PathVariable int num1, @PathVariable int num2) {
		return Integer.toString(num1 + num2);
	}
}
