package com.yiguy.service_ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "serviceFailure")
	public String getHelloContent() {
		return restTemplate.getForObject("http://hello-service/hello", String.class);
	}

	// 该方法的返回值必须和被注解的方法返回值一致
	public String serviceFailure() {
		return "hello world service is not available!";
	}
}
