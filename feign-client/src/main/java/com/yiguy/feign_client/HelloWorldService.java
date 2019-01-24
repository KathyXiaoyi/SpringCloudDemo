package com.yiguy.feign_client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 定义Feign，一个用@FeignClient注解的接口类
@FeignClient(value = "hello-service", fallback=HelloWorldServiceFailure.class)
public interface HelloWorldService {
	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String sayHello();
}
