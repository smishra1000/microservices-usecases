package com.sameer.fullstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsCourseStudentGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCourseStudentGatewayApplication.class, args);
	}

}
