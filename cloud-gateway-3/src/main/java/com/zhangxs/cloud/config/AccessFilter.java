package com.zhangxs.cloud.config;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 请求登录拦截
 * @author zxs-web
 *
 */
public class AccessFilter extends ZuulFilter{

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest r=ctx.getRequest();
		String accessToken=r.getParameter("accessToken");//获取请求token
		if(accessToken==null){
			System.out.println("access token is empty");
			ctx.getResponse().setCharacterEncoding("UTF-8");//设置字符集，避免乱码
			ctx.getResponse().setHeader("content-type", "text/html;charset=UTF-8");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);//设置状态码
			ctx.setResponseBody("未登录");
			return null;
		}
		System.out.println("access token ok");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;//是否被执行，这里true是所有请求都执行。实际中可以根据一些方法的返回来控制
	}

	@Override
	public int filterOrder() {
		return 0;//用来顺序
	}

	@Override
	public String filterType() {
		return "pre";//pre在请求被路由之前执行
	}

}
