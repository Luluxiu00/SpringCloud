package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.config.JdbcConfigBean;
import com.example.demo.feign.HelloFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class HelloController {

	@Autowired
    private RestTemplate restTemplate;
	
	@Autowired
	private HelloFeignClient feignClient;
	
	@Autowired
	private JdbcConfigBean jdbcConfigBean;

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello() {
    	String serviceId = "producer";
        return restTemplate.getForEntity("http://"+ serviceId +"/client", String.class).getBody();
    }
    
    
    @RequestMapping(value = "/hello2")
    @ResponseBody
    @HystrixCommand(fallbackMethod="fallBack")
    public String hello2() {
        return feignClient.client();
    }
    
    
    public String fallBack() {
    	return "eruceka 服务调用失败!!!";
    }
    
    
    @RequestMapping(value = "/test")
    @ResponseBody
    public String test() {
        return jdbcConfigBean.toString();
    }
    
}
