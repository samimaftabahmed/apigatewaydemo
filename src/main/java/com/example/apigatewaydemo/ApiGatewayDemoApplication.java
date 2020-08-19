package com.example.apigatewaydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ApiGatewayDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayDemoApplication.class, args);
	}

}
