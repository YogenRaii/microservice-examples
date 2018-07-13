package com.eprogrammerz.examples.hystrix.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients(basePackages = {"com.eprogrammerz.examples"})
@EnableCircuitBreaker
@SpringBootApplication
public class ClientAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(ClientAppApplication.class, args);
	}
}
