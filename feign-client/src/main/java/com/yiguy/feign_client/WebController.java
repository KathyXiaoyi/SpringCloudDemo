package com.yiguy.feign_client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
	@Autowired
	private HelloWorldService helloWorldFeignService;

	@RequestMapping(value = "/hello")
	public String sayHello() {
		return helloWorldFeignService.sayHello();
	}
}
