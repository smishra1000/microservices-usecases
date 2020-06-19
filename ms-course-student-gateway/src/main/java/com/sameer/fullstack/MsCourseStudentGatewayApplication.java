package com.sameer.fullstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableEurekaClient
@CrossOrigin("*")
public class MsCourseStudentGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCourseStudentGatewayApplication.class, args);
	}

	@Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		final org.springframework.web.cors.CorsConfiguration config = new CorsConfiguration();
//		config.setAllowCredentials(true);
//		config.setAllowedOrigins(Collections.singletonList("*"));
//		config.setAllowedHeaders(Collections.singletonList("*"));
//		config.setAllowedMethods(Arrays.stream(HttpMethod.values()).map(HttpMethod::name).collect(Collectors.toList()));
//		source.registerCorsConfiguration("/**", config);
//		return new CorsFilter(source);
		return new CorsFilter(source);
	}
}
