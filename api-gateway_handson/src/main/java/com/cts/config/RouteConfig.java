package com.cts.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {
	
	@Bean
	RouteLocator routeLocator(RouteLocatorBuilder builder) {
		
		return builder.routes()
				.route("weather-service",r->r.path("/weather")
						.uri("lb://weather-service"))
				.route("news-service",r->r.path("/news")
						.uri("lb://news-service"))
				.route("weather-service",r->r.path("/report")
						.uri("lb://aggregator-service-client"))
				.build();
	}
}
