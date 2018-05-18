package com.zhangxs.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhangxs.cloud.feign.FeignService;


@RestController
public class TestController {

	@Autowired
	FeignService feign;
	
	@RequestMapping(value="/getUserName",method=RequestMethod.GET)
	public String getUserName(@RequestParam(required = true, value = "user_name")String user_name){
		return feign.getUserName(user_name);
	}
}
