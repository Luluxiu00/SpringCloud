package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DiscoveryController {
    
    @Autowired
    private DiscoveryClient discoveryClient;
    
    @Value("${server.port}")
    private String port;
    
    @RequestMapping("/client")
    public String client() {
        String services = "Services: " + discoveryClient.getServices()+" port :"+port;
        System.out.println(services);
        return services;
    }
}