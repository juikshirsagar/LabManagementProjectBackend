package com.testcase.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;

import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

	 @Bean
	    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
	        return builder.routes()
	                .route(r ->r.path("/LabTest/**")
	                        .uri("http://localhost:8031/")
	                       )

	                .route(r -> r.path("/Patient/**")
	                        .uri("http://localhost:8032/")
	                        )
	                
	                .route(r -> r.path("/Report/**")
	                        .uri("http://localhost:8033/")
	                        )
	                .route(r -> r.path("/Registration/user/**")
	                        .uri("http://localhost:8034/")
	                        )
	                .route(r -> r.path("/Message/**")
	                        .uri("http://localhost:8088/")
	                        )
	                .build();
	    }
}
