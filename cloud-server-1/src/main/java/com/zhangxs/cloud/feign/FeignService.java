package com.zhangxs.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhangxs.cloud.hystrix.HystrixFallback;

//@FeignClient(name="cloud-server-2",configuration = DisableHystrixConfiguration.class)  //自定义不启用hystrix服务
@FeignClient(name="cloud-server-2",fallback = HystrixFallback.class) //添加降级服务方法
public interface FeignService {
	
	@RequestMapping(value="/getUserName", method =RequestMethod.GET)
	public String getUserName(@RequestParam(required = true, value = "user_name")String user_name);
}
