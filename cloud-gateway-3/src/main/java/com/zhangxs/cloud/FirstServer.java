package com.zhangxs.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.zhangxs.cloud.config.AccessFilter;

@SpringBootApplication
@EnableZuulProxy//开启zuul
@EnableEurekaClient
public class FirstServer {
	public static void main(String[] args) {
		SpringApplication.run(FirstServer.class,args);
	}
	
	@Bean
	public AccessFilter accessFilter(){
		return new AccessFilter();
	}
}
