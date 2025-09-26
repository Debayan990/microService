package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
public class AggregatorServiceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(AggregatorServiceClientApplication.class, args);
	}
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	@LoadBalanced
	RestClient.Builder restClientBuilder(){
		return RestClient.builder();
	}

	@Bean
//	@LoadBalanced
	WebClient.Builder webClientBuilder(){
		return WebClient.builder();
	}
}
