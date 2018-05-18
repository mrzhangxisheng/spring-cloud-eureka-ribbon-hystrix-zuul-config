package com.zhangxs.cloud.controller;

import java.util.Random;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@ConfigurationProperties(prefix="server")
public class TestController {
	
	private static String port;
	public void setPort(String port) { 
	    this.port = port; 
	  } 
	
	@RequestMapping(value="/getUserName",method= RequestMethod.GET)
	public String getUserName(@RequestParam(required = true, value = "user_name") String user_name) throws InterruptedException{
		int time =new Random().nextInt(3000);
		System.out.println(time);
		Thread.sleep(time);
		return user_name+":"+port;
	}
}
