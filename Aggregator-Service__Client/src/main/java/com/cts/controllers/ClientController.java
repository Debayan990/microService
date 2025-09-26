package com.cts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.service.DataService;

@RestController
public class ClientController {

	@Autowired
	private DataService dataService;
	
	@GetMapping("/report")
	public String getMessages() {
		
//		var result = dataService.fetchBoth();
		
		var w=dataService.getWeather();
		var n=dataService.getNews();
		return w+" "+n;
		
	}
}
