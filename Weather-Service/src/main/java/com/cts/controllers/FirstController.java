package com.cts.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

	@Value("${app.first.message}")
	private String message;
	
	@GetMapping("/weather")
	public String showWeather() {
		return "Today's weather is Sunny, 30°C"+" | "+message;
	}
}
