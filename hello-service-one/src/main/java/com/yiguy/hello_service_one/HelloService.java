package com.yiguy.hello_service_one;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RestController
@RefreshScope
public class HelloService {
	
	@Value("${hello}")
	private String hello;
	
	@RequestMapping(value="/hello")
	public String hello() {
		return hello +  "   port:8882";
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(HelloService.class, args);
	}
}
