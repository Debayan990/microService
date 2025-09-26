package com.cts.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name= "News-Service")
public interface NewsClient {

	@GetMapping("/news")
	public String showNews();
}
