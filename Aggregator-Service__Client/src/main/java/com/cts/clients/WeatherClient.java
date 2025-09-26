package com.cts.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name= "Weather-Service")
public interface WeatherClient {

	@GetMapping("/weather")
	public String showWeather();
}
