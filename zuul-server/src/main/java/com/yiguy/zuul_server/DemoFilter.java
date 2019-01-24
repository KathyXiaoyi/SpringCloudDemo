package com.yiguy.zuul_server;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class DemoFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(DemoFilter.class);

	// 这里可以写逻辑判断，是否要过滤，文本true表示永远过滤
	@Override
	public boolean shouldFilter() {
		return true;
	}

	// 过滤器的具体逻辑
	@Override
	public Object run() {
		System.out.println("----------------------------");
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		String info = request.getMethod() + "  " + request.getRequestURL().toString();
		log.info(info);
		System.out.println("----------------------------");
		return null;
	}

	// 返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型
	// pre: 路由之前
	// routing: 路由之时
	// post: 路由之后
	// error: 发送错误调用
	@Override
	public String filterType() {
		return "pre";
	}

	// 返回一个int值来指定过滤器的执行顺序，不同的过滤器允许返回相同的数字
	// 过滤的优先级，数字越大，优先级越低
	@Override
	public int filterOrder() {
		return 0;
	}
}
