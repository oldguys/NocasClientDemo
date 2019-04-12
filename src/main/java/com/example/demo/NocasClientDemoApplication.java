package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NocasClientDemoApplication {

    public static void main(String[] args) {
        System.out.println("测试:"+System.currentTimeMillis());
        SpringApplication.run(NocasClientDemoApplication.class, args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
