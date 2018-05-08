package com.example.demo.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "producer") // 申明这是一个Feign客户端，并且指明服务id
public interface HelloFeignClient {

	// 这里定义了类似于SpringMVC用法的方法，就可以进行RESTful的调用了
	@RequestMapping(value = "/client", method = RequestMethod.GET)
	public String client();

}