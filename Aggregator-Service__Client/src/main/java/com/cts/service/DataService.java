package com.cts.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.cts.clients.NewsClient;
import com.cts.clients.WeatherClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DataService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private RestClient.Builder restClientBuilder;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	
	@Autowired
	private WeatherClient weatherClient;
	@Autowired
	private NewsClient newsClient;
	
//	Logger log=LoggerFactory.getLogger(getClass());		//self created logger, otherwise use lombok @slf4j
	
	
//	public String fetchBoth() {
//		/* using RestTemplate */
////		String weather = restTemplate.getForObject("http://locahost:8051/weather", String.class);
////		String news = restTemplate.getForObject("http://locahost:8052/news", String.class);
//		
//		/* using RestClient */
////		String weather = restClientBuilder.build().get().uri("http://weather-service/weather").retrieve().body(String.class);
////		String news = restClientBuilder.build().get().uri("http://news-service/news").retrieve().body(String.class);
//		
//		/* using webClient */
////		String weather = webClientBuilder.build().get().uri("http://locahost:8051/weather").retrieve().bodyToMono(String.class).block();
////		String news = webClientBuilder.build().get().uri("http://locahost:8052/news").retrieve().bodyToMono(String.class).block();
//		
//		/* using FeignClient (part of SpringCloud) */
//		String weather=weatherClient.showWeather();
//		String news=newsClient.showNews();
//		
//		
//		return weather+" "+news;
//	}
	
	
	@Retry(name="weather",fallbackMethod = "weatherFallback")
	@CircuitBreaker(name = "weatherBreak",fallbackMethod = "weatherFallback")
	public String getWeather() {
		log.info("Weather service is getting called ==============================");
		return weatherClient.showWeather();
	}
	
	@Retry(name="news",fallbackMethod = "newsFallback")
	@CircuitBreaker(name="newsBreak",fallbackMethod = "newsFallback")
	public String getNews() {
		log.info("News service is getting called ==============================");
		return newsClient.showNews();
	}
	
	
	public String weatherFallback(Throwable throwable) {
		return "Weather service is not available";
	}
	public String newsFallback(Throwable throwable) {
		return "News service is not available";
	}
}
