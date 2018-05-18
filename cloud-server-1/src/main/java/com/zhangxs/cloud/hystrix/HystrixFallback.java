package com.zhangxs.cloud.hystrix;

import org.springframework.stereotype.Component;

import com.zhangxs.cloud.feign.FeignService;

@Component
public class HystrixFallback implements FeignService{

	@Override
	public String getUserName(String user_name) {
		return "访问错误";
	}
}
