package com.cts.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondController {
	
	@Value("${app.second.message}")
	private String message;
	
	@GetMapping("/news")
	public String showNews() {
		return "Breaking News: Stock markets hit a new high"+" | "+ message;
	}

}
