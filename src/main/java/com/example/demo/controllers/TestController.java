package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

/**
 * @ClassName: TestController
 * @Author: ren
 * @DESCRIPTION: 2019/4/2 0002 下午 3:56
 **/
@RestController
public class TestController {

    @Value("${spring.application.name}")
    private String appName;

    @LoadBalanced
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("test")
    public String test(HttpSession session) {
        System.out.println(System.currentTimeMillis());
        return appName + ":" + session.getId();
    }

    @GetMapping("ribbon")
    public String ribbon() {
        return restTemplate.getForObject("http://nacos-feign-client/test", String.class);
    }
}
