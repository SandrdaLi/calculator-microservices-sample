package com.perry.calc;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalcController {

	@GetMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("add", "");
		model.addAttribute("sub", "");
		return "calculate";
	}

	@PostMapping(value = "/calculate")
	public String calculate(Model model, @RequestParam(name = "num1") String num1,
			@RequestParam(name = "num2") String num2) throws Exception {

//		String addService = "http://calculator-add-env.us-east-2.elasticbeanstalk.com/" + num1 + "/" + num2;
//		String subService = "http://calculator-sub-env.us-east-2.elasticbeanstalk.com/" + num1 + "/" + num2;

		String addService = "http://localhost:8084/" + num1 + "/" + num2;
		String subService = "http://calculator-sub-env.us-east-2.elasticbeanstalk.com/" + num1 + "/" + num2;

		String addResponse = "";
		String subResponse = "";

		if (!num1.equals("") && !num2.equals("")) {
			// Add
			URL url = new URL(addService);
			HttpURLConnection requestAdd = (HttpURLConnection) url.openConnection();
			requestAdd.connect();

			BufferedReader streamReader = new BufferedReader(new InputStreamReader((InputStream) requestAdd.getContent()));
			addResponse = streamReader.readLine();

			// Subtract
//			url = new URL(subService);
//			HttpURLConnection requestSub = (HttpURLConnection) url.openConnection();
//			requestSub.connect();
//			streamReader = new BufferedReader(new InputStreamReader((InputStream) requestSub.getContent()));
//			subResponse = streamReader.readLine();
		}
		model.addAttribute("add", addResponse);
		model.addAttribute("sub", subResponse);
		return "calculate";
	}
}
